package kodluyoruz.ParkingControlSystem.business.abstracts;

import java.util.List;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.Owner;




public interface OwnerService {
	
	DataResult<List<Owner>> getAll();
	Result add(Owner owner);
	
    DataResult<Owner> getByOwnerName(String name);
	
	DataResult<Owner> getByOwnerNameAndOwnerSurname(String name, String surname);
	
	DataResult<List<Owner>> getByMailOrPhoneNumber(String mail, String phone_number);
	
	DataResult<List<Owner>> getByOwnerNameContains(String name);
	
	DataResult<List<Owner>> deleteByOwnerId(Integer id);
	
	
	
	
	
	
}
