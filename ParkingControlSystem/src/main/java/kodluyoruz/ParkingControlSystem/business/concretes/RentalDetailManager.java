package kodluyoruz.ParkingControlSystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodluyoruz.ParkingControlSystem.business.abstracts.RentalDetailService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.ErrorResult;
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
	public Result add(RentalDetail rentalDetail) {
		this.rentalDetailDao.save(rentalDetail);
		return new SuccessResult("Data eklendi");
	}

	@Override
	public Result update(RentalDetail rentalDetail) {
		Optional<RentalDetail> getRentalDetail = rentalDetailDao.findById(rentalDetail.getId());
		  if(!getRentalDetail.isPresent()) {
		         return new ErrorResult("Data ID'si bulunamadı");
		    }
	    this.rentalDetailDao.save(rentalDetail);
		return new SuccessResult("Data güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		this.rentalDetailDao.deleteById(id);
		return new SuccessResult("Data silindi");
	}

}
