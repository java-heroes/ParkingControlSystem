package kodluyoruz.ParkingControlSystem.business.abstracts;

import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
import java.util.List;

public interface ParkRentalService {

    DataResult<List<ParkRental>> getAll();

    Result add(ParkRental parkRental);

    Result update(ParkRental parkRental);

    DataResult<ParkRental> deleteById(int id);
    
    ParkRental getById(Integer parkRentalId);
}
