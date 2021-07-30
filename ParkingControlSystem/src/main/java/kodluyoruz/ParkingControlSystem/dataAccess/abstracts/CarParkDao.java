package kodluyoruz.ParkingControlSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodluyoruz.ParkingControlSystem.entities.concretes.CarPark;

public interface CarParkDao extends JpaRepository<CarPark, Integer>{
	
	CarPark deleteById(int id);

	CarPark getByName (String name);
	
	CarPark getByNameAndOwner_id(String name, int ownerId);
	
	Integer getByCapacity(int id);

	List<CarPark> getByNameOrOwner_id(String name, int ownerId);
	
	List<CarPark> getByOwnerIn(List<Integer> owners);
	
	List<CarPark> getByNameContains(String name);
	
	List<CarPark> getByNameStartsWith(String name);
	
	@Query("From CarPark where name=:name and owner.id=:ownerId")
	List<CarPark> getByNameAndOwner(String name, int ownerId);
}
