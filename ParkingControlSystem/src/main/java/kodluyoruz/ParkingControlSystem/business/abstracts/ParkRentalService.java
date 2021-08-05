package kodluyoruz.ParkingControlSystem.business.abstracts;

import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
import kodluyoruz.ParkingControlSystem.entities.dto.ParkRentalDto;
import kodluyoruz.ParkingControlSystem.entities.dto.ParkRentalDtoUpdate;

import java.util.List;

public interface ParkRentalService {

    DataResult<List<ParkRental>> getAll();

    Result update(ParkRentalDtoUpdate parkRentalDtoUpdate);

    DataResult<ParkRental> deleteById(int id);
    
    ParkRental getById(Integer parkRentalId);
    
    Result add(ParkRentalDto parkRentalDto);
    
    DataResult<Boolean> outputControlByParkLayoutId(int parkLayoutId);
    
    Float calculateTotalPrice(ParkRental parkRental);
}
