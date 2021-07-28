package kodluyoruz.ParkingControlSystem.business.abstracts;

import java.util.List;

import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkLayout;

public interface ParkLayoutService {
	
	DataResult<List<ParkLayout>> getAll();
	
	Result add(ParkLayout parkLayout);
	
	DataResult<ParkLayout> getByName(char name);
	
	DataResult<ParkLayout> getByNameAndCarParkId(char name, int carParkId);
	
	DataResult<List<ParkLayout>> getByNameOrCarPark(char name, int carParkId);
	
	DataResult<List<ParkLayout>> getByCarParkIdIn(List<Integer> carParks);
	
	DataResult<List<ParkLayout>> getByNameContains(char name);
	
	DataResult<List<ParkLayout>> getByNameStartsWith(char name);
	
	DataResult<List<ParkLayout>> getByNameAndCarPark(char name, int carParkId);

}
