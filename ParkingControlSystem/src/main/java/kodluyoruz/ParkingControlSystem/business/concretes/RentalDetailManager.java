package kodluyoruz.ParkingControlSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodluyoruz.ParkingControlSystem.business.abstracts.ParkRentalService;
import kodluyoruz.ParkingControlSystem.business.abstracts.RentalDetailService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessDataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessResult;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.RentalDetailDao;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
import kodluyoruz.ParkingControlSystem.entities.concretes.RentalDetail;


@Service
public class RentalDetailManager implements RentalDetailService {
	private RentalDetailDao rentalDetailDao;

	@Autowired
	public RentalDetailManager(RentalDetailDao rentalDetailDao) {
		super();
		this.rentalDetailDao = rentalDetailDao;
	}
	
	@Autowired (required = false)
	private ParkRentalService parkRentalService;

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

	@Override
	public Result addRentalDetail(int parkRentalId, float totalPrice) {
		ParkRental tempRental=this.parkRentalService.getById(parkRentalId);
		RentalDetail tempDetail = new RentalDetail();
		tempDetail.setParkRental(tempRental);
		tempDetail.setTotalPrice(totalPrice);
		rentalDetailDao.save(tempDetail);
		return new SuccessResult("Data eklendi");
	}

}
