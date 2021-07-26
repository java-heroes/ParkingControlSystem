package kodluyoruz.ParkingControlSystem.dataAccess.abstracts;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodluyoruz.ParkingControlSystem.entities.concretes.Owner;


public interface OwnerDao extends JpaRepository<Owner ,Integer> {
	
	   Owner getByOwnerName(String name);
	
		Owner getByOwnerNameAndOwnerSurname(String name, String surname);
	    
	    List<Owner> getByMailOrPhoneNumber(String mail, String phone_number);
		
		List<Owner> getByOwnerNameContains(String name);
		
		List<Owner> deleteByOwnerId(Integer id);
		
	
}
