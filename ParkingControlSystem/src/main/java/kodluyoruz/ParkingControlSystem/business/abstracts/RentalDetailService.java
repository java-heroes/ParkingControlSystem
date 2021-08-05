package kodluyoruz.ParkingControlSystem.business.abstracts;

import java.util.List;

import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.RentalDetail;

public interface RentalDetailService {

	DataResult<List<RentalDetail>> getAll();
	
	DataResult<RentalDetail> getByParkRentalId(Integer parkRentalId);

	Result delete(Integer id);
	
}
