package kodluyoruz.ParkingControlSystem.business.concretes;

import kodluyoruz.ParkingControlSystem.business.abstracts.ParkRentalService;
import kodluyoruz.ParkingControlSystem.business.abstracts.RentalDetailService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.*;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.ParkRentalDao;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
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
    private RentalDetailService rentalDetailService;

    @Override
    public DataResult<List<ParkRental>> getAll() {
        return new SuccessDataResult<List<ParkRental>>(this.parkRentalDao.findAll(), "Data listelendi");
    }

    @Override
    public Result add(ParkRental parkRental) {
        this.parkRentalDao.save(parkRental);
        float totalPrice = 0; //(Geçici Değişken) total price hesaplaması yapılınca kaldırılacak.
        rentalDetailService.addRentalDetail(parkRental.getId(), totalPrice);
        return new SuccessResult("Data eklendi");
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
}
