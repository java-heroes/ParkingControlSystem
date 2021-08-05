package kodluyoruz.ParkingControlSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodluyoruz.ParkingControlSystem.business.abstracts.RentalDetailService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessDataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessResult;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.RentalDetailDao;
import kodluyoruz.ParkingControlSystem.entities.concretes.RentalDetail;


@Service
public class RentalDetailManager implements RentalDetailService {
	private RentalDetailDao rentalDetailDao;

	@Autowired
	public RentalDetailManager(RentalDetailDao rentalDetailDao) {
		super();
		this.rentalDetailDao = rentalDetailDao;
	}

	@Override
	public DataResult<List<RentalDetail>> getAll() {
		return new SuccessDataResult<List<RentalDetail>>(this.rentalDetailDao.findAll(), "Data listelendi");
	}
	
	@Override
	public DataResult<RentalDetail> getByParkRentalId(Integer parkRentalId){
		return new SuccessDataResult<RentalDetail>(this.rentalDetailDao.getByParkRentalId(parkRentalId), "Data listelendi");
	}

	@Override
	public Result delete(Integer id) {
		this.rentalDetailDao.deleteById(id);
		return new SuccessResult("Data silindi");
	}

}
