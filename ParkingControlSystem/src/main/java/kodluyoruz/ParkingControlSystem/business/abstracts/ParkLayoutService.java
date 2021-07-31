package kodluyoruz.ParkingControlSystem.business.abstracts;

import java.util.List;

import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkLayout;

public interface ParkLayoutService {
	
	DataResult<List<ParkLayout>> getAll();
	
	DataResult<List<ParkLayout>> getAllSorted();
	
	Result update(ParkLayout parkLayout);
	
	DataResult<ParkLayout> deleteById(int id);
	
	DataResult<ParkLayout> getByName(String name);
	
	DataResult<ParkLayout> getByNameAndCarParkId(String name, int carParkId);
	
	DataResult<List<ParkLayout>> getByNameOrCarPark(String name, int carParkId);
	
	DataResult<List<ParkLayout>> getByCarParkIdIn(List<Integer> carParks);
	
	DataResult<List<ParkLayout>> getByNameContains(String name);
	
	DataResult<List<ParkLayout>> getByNameStartsWith(String name);
	
	DataResult<List<ParkLayout>> getByNameAndCarPark(String name, int carParkId);
	
	Result addParkLayoutName(int carParkId);

}
