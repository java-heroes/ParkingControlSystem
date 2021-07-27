package kodluyoruz.ParkingControlSystem.business.abstracts;

import java.util.List;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.Owner;




public interface OwnerService {
	
	DataResult<List<Owner>> getAll();
	
	Result add(Owner owner);
	
	Result update(Owner owner);
	
    DataResult<Owner> getByName(String name);
	
	DataResult<Owner> getByNameAndSurname(String name, String surname);
	
	DataResult<List<Owner>> getByEmailOrPhoneNumber(String email, String phoneNumber);
	
	DataResult<List<Owner>> getByNameContains(String name);
	
	DataResult<Owner> deleteById(int id);
	
	
}