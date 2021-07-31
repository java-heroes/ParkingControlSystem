package kodluyoruz.ParkingControlSystem.business.concretes;

import kodluyoruz.ParkingControlSystem.business.abstracts.ParkRentalService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.*;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.ParkRentalDao;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
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

    @Override
    public DataResult<List<ParkRental>> getAll() {
        return new SuccessDataResult<List<ParkRental>>(this.parkRentalDao.findAll(), "Data listelendi");
    }


    @Override
    public Result add(ParkRental parkRental) {
        this.parkRentalDao.save(parkRental);
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
    public DataResult<ParkRental> getByRentDate(Date rentDate) {
        return new SuccessDataResult<ParkRental>
                (this.parkRentalDao.getByRentDate(rentDate), "Data listelendi");
    }

    /*@Override
    public DataResult<ParkRental> getByRentDateAndEndDate(Date rentDate, Date endDate) {
        return new SuccessDataResult<ParkRental>
                (this.parkRentalDao.getByRentDateAndEndDate(rentDate, endDate), "Data listelendi");
    }
*/
    @Override
    public DataResult<List<ParkRental>> getByRentDateContains(Date rentDate) {
        return new SuccessDataResult<List<ParkRental>>
                (this.parkRentalDao.getByRentDateContains(rentDate), "Data listelendi");
    }

    @Override
    public DataResult<ParkRental> deleteById(int id) {
        return new SuccessDataResult<ParkRental>(this.parkRentalDao.deleteById(id),"Data silindi");
    }
}
