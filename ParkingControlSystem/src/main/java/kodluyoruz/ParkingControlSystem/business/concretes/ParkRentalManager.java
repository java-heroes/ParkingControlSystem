package kodluyoruz.ParkingControlSystem.business.concretes;

import kodluyoruz.ParkingControlSystem.business.abstracts.ParkRentalService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.*;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.ParkLayoutDao;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.ParkRentalDao;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.RentalDetailDao;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.UserDao;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
import kodluyoruz.ParkingControlSystem.entities.concretes.RentalDetail;
import kodluyoruz.ParkingControlSystem.entities.dto.ParkRentalDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Result update(ParkRental parkRental) {
        Optional<ParkRental> getParkRental = parkRentalDao.findById(parkRental.getId());
        if(!getParkRental.isPresent()) {
            return new ErrorResult("Data ID'si bulunamadı");
        }
        this.parkRentalDao.save(parkRental);
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
		ParkRental temp=new ParkRental();
		temp.setUser(this.userDao.getById(parkRentalDto.userId));
		temp.setRentDate(parkRentalDto.rentDate);
		temp.setEndDate(parkRentalDto.endDate);
		temp.setParkLayout(this.parkLayoutDao.getById(parkRentalDto.parkLayoutId));
		ParkRental result = this.parkRentalDao.save(temp);

		RentalDetail detail = new RentalDetail();
		ParkRental tempRental=getById(result.getId());
		detail.setParkRental(tempRental);
		detail.setTotalPrice(0);//Total price hesaplaması eklenip parametre olarak verilecek
		this.rentalDetailDao.save(detail);
		
		
		return new SuccessResult("Eklendi");
	}

}
