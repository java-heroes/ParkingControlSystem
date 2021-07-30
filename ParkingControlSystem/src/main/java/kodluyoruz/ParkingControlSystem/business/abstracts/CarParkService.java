package kodluyoruz.ParkingControlSystem.business.abstracts;

import java.util.List;

import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.CarPark;

public interface CarParkService {
	
	DataResult<List<CarPark>> getAll();
	
	DataResult<List<CarPark>> getAllSorted();
	
	Result add(CarPark carPark);
	
	Result update(CarPark parkLayout);
	
	DataResult<Integer> getByCapacity(int id);
	
	CarPark getById(int carParkId);
	
	DataResult<CarPark> deleteById(int id);
	
	DataResult<CarPark> getByName (String name);
	
	DataResult<CarPark> getByNameAndOwnerId(String name, int ownerId);

	DataResult<List<CarPark>> getByNameOrOwnerId(String name, int ownerId);
	
	DataResult<List<CarPark>> getByOwnerIdIn(List<Integer> owners);
	
	DataResult<List<CarPark>> getByNameContains(String name);
	
	DataResult<List<CarPark>> getByNameStartsWith(String name);
	
	DataResult<List<CarPark>> getByNameAndOwner(String name, int ownerId);

}
