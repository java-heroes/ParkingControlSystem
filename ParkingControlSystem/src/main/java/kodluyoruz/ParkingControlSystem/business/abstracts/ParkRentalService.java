package kodluyoruz.ParkingControlSystem.business.abstracts;

import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessDataResult;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
import java.util.Date;
import java.util.List;

public interface ParkRentalService {

    DataResult<List<ParkRental>> getAll();

    Result add(ParkRental parkRental);

    Result update(ParkRental parkRental);

    DataResult<ParkRental> getByRentDate(Date rentDate);

    DataResult<ParkRental> getByRentDateAndEndDate(Date rentDate, Date endDate);

    DataResult<List<ParkRental>> getByRentDateContains(Date rentDate);

    DataResult<ParkRental> deleteById(int id);
}
