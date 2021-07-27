package kodluyoruz.ParkingControlSystem.dataAccess.abstracts;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodluyoruz.ParkingControlSystem.entities.concretes.Owner;


public interface OwnerDao extends JpaRepository<Owner ,Integer> {
	
	   Owner getByName(String name);
	
		Owner getByNameAndSurname(String name, String surname);
	    
	    List<Owner> getByEmailOrPhoneNumber(String email, String phoneNumber);
		
		List<Owner> getByNameContains(String name);
		
		Owner deleteById(int id);
		
	
}