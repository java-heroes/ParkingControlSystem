package kodluyoruz.ParkingControlSystem.business.concretes;

import kodluyoruz.ParkingControlSystem.business.abstracts.ParkRentalService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.*;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.ParkLayoutDao;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.ParkRentalDao;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.RentalDetailDao;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.UserDao;
import kodluyoruz.ParkingControlSystem.entities.concretes.CarPark;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkLayout;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
import kodluyoruz.ParkingControlSystem.entities.concretes.RentalDetail;
import kodluyoruz.ParkingControlSystem.entities.dto.ParkRentalDto;
import kodluyoruz.ParkingControlSystem.entities.dto.ParkRentalDtoUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class ParkRentalManager implements ParkRentalService {

    private ParkRentalDao parkRentalDao;

    @Autowired
    public ParkRentalManager(ParkRentalDao parkRentalDao) {
        super();
        this.parkRentalDao = parkRentalDao;
    }
    
    @Autowired(required = false)
    private UserDao userDao;
    
    @Autowired(required = false)
    private ParkLayoutDao parkLayoutDao;
    
    @Autowired(required = false)
    private RentalDetailDao rentalDetailDao;
    
    @Override
    public DataResult<List<ParkRental>> getAll() {
        return new SuccessDataResult<List<ParkRental>>(this.parkRentalDao.findAll(), "Data listelendi");
    }

    @Override
    public Result update(ParkRentalDtoUpdate parkRentalDtoUpdate) {
    	
    	ParkRental temp=new ParkRental();
		temp.setId(parkRentalDtoUpdate.id);
		temp.setEndDate(parkRentalDtoUpdate.endDate);
		temp.setUser(this.userDao.getById(parkRentalDtoUpdate.userId));
		temp.setRentDate(parkRentalDtoUpdate.rentDate);
		temp.setParkLayout(this.parkLayoutDao.getById(parkRentalDtoUpdate.parkLayoutId));
		ParkRental result = this.parkRentalDao.save(temp);

        Optional<ParkRental> getParkRental = parkRentalDao.findById(temp.getId());
        if(!getParkRental.isPresent()) {
            return new ErrorResult("Data ID'si bulunamadı");
        }  
       
        temp = parkRentalDao.getById(temp.getId());
        float totalPrice =calculateTotalPrice(temp);
        
        RentalDetail controlDetail =this.rentalDetailDao.getByParkRentalId(result.getId());
        controlDetail.setTotalPrice(totalPrice);
        this.rentalDetailDao.save(controlDetail);

        return new SuccessResult("Data güncellendi");
    }

    @Override
    public DataResult<ParkRental> deleteById(int id) {
        return new SuccessDataResult<ParkRental>(this.parkRentalDao.deleteById(id),"Data silindi");
    }

	@Override
	public ParkRental getById(Integer parkRentalId) {
		ParkRental tempRental=this.parkRentalDao.getById(parkRentalId);
		return tempRental;
	}

	@Override
	public Result add(ParkRentalDto parkRentalDto) {
		if(!outputControlByParkLayoutId(parkRentalDto.parkLayoutId).isSuccess()) {
			return new ErrorResult("Kiralama yapılamadı. Park yeri dolu!");
		}

		ParkRental temp=new ParkRental();
		temp.setUser(this.userDao.getById(parkRentalDto.userId));
		temp.setRentDate(parkRentalDto.rentDate);
		temp.setEndDate(parkRentalDto.endDate);
		temp.setParkLayout(this.parkLayoutDao.getById(parkRentalDto.parkLayoutId));
		ParkRental result = this.parkRentalDao.save(temp);

		RentalDetail detail = new RentalDetail();
		ParkRental tempRental=getById(result.getId());
		detail.setParkRental(tempRental);
		detail.setTotalPrice(0);
		this.rentalDetailDao.save(detail);
		
		
		return new SuccessResult("Eklendi");
	}

	@Override
	public DataResult<Boolean> outputControlByParkLayoutId(int parkLayoutId) {
		//Parametre gelen datadaki park layout id ile kiralama varmı, varsa rent date i ile end date i eşitmi? Eşitse kiralama
		
		List<ParkRental> parkRentals = this.parkRentalDao.getByParkLayoutId(parkLayoutId);
				
		for(ParkRental parkRental:parkRentals) { 
			String rentDateStr = "dd/MM/yyyy HH:mm:ss";
			DateFormat rdf = new SimpleDateFormat(rentDateStr);
			Date rentDate = parkRental.getRentDate();
			String rentDateAsString= rdf.format(rentDate);
					
			String endDateStr = "dd/MM/yyyy HH:mm:ss";
			DateFormat edf = new SimpleDateFormat(endDateStr);
			Date endDate = parkRental.getEndDate();
			String endDateAsString= edf.format(endDate);
					
			if(rentDateAsString.equals(endDateAsString)) { 
				return new ErrorDataResult<Boolean> (false); 
			} 
		}
		return new SuccessDataResult<Boolean>(true);
	}

	@Override
	public Float calculateTotalPrice(ParkRental  parkRental) {
		ParkLayout parkLayout = this.parkLayoutDao.getById(parkRental.getParkLayout().getId());
		CarPark carPark = parkLayout.getCarPark();
		float unitPrice = carPark.getUnitPrice();
		float notCalculated=0;
		
		String rentDateStr = "MM/dd/yyyy HH:mm:ss";
		DateFormat rdf = new SimpleDateFormat(rentDateStr);
		Date rentDate = parkRental.getRentDate();
		String rentDateAsString= rdf.format(rentDate);
		
		String endDateStr = "MM/dd/yyyy HH:mm:ss";
		DateFormat edf = new SimpleDateFormat(endDateStr);
		Date endDate = parkRental.getEndDate();
		String endDateAsString= edf.format(endDate);
		
		SimpleDateFormat obj = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); 
		
		try {
			
			Date dateRent = obj.parse(rentDateAsString);
			Date dateEnd = obj.parse(endDateAsString);
			
			long time_difference = dateEnd.getTime() - dateRent.getTime();
			
			long days_difference = TimeUnit.MILLISECONDS.toDays(time_difference) % 365;  
			long hours_difference = TimeUnit.MILLISECONDS.toHours(time_difference) % 24;
			long minutes_difference = TimeUnit.MILLISECONDS.toMinutes(time_difference) % 60;
			
			long calculateDay = days_difference * 24 * (long)unitPrice;
			long calculateHour = hours_difference * (long)unitPrice;
			long calculateMinute;
			
			long clockRule= 30;
			if(minutes_difference >= clockRule) {
				calculateMinute = 1 * (long)unitPrice;
			}else {
				calculateMinute = 0;
			}
			
			long calculateTotalPrice = calculateDay + calculateHour + calculateMinute;
			float totalPrice = (float)calculateTotalPrice;
			return totalPrice;
			
		}catch (ParseException excep) {   
            excep.printStackTrace();   
        }   
		return notCalculated;
		
	}
}
