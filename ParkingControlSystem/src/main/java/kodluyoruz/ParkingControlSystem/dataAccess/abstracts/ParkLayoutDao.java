package kodluyoruz.ParkingControlSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodluyoruz.ParkingControlSystem.entities.concretes.ParkLayout;

public interface ParkLayoutDao extends JpaRepository<ParkLayout, Integer>{

	ParkLayout getByName(char name);
	
	ParkLayout getByNameAndCarParkId(char name, int carParkId);
	
	List<ParkLayout> getByNameOrCarPark(char name, int carParkId);
	
	List<ParkLayout> getByCarParkIdIn(List<Integer> carParks);
	
	List<ParkLayout> getByNameContains(char name);
	
	List<ParkLayout> getByNameStartsWith(char name);
	
	@Query("From ParkLayout where name=:name and carPark.id=:carParkId")
	List<ParkLayout> getByNameAndCarPark(char name, int carParkId);
}
