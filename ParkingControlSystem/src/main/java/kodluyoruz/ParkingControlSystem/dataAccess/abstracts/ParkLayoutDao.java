package kodluyoruz.ParkingControlSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodluyoruz.ParkingControlSystem.entities.concretes.ParkLayout;

public interface ParkLayoutDao extends JpaRepository<ParkLayout, Integer>{
	
	ParkLayout deleteById(int id);

	ParkLayout getByName(String name);
	
	ParkLayout getByNameAndCarParkId(String name, int carParkId);
	
	List<ParkLayout> getByNameOrCarPark(String name, int carParkId);
	
	List<ParkLayout> getByCarParkIdIn(List<Integer> carParks);
	
	List<ParkLayout> getByNameContains(String name);
	
	List<ParkLayout> getByNameStartsWith(String name);
	
	@Query("From ParkLayout where name=:name and carPark.id=:carParkId")
	List<ParkLayout> getByNameAndCarPark(String name, int carParkId);
}
