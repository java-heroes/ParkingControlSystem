package kodluyoruz.ParkingControlSystem.dataAccess.abstracts;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodluyoruz.ParkingControlSystem.entities.concretes.Owner;


public interface OwnerDao extends JpaRepository<Owner ,Integer> {
	
	
		Owner getByOwnerNameAndOwnerSurname(String name, String surname);
	    
	    List<Owner> getByMailOrPhoneNumber(String mail, String phone_number);
		
		List<Owner> getByOwnerNameContains(String name);
		
		public void deleteById(Integer id);
		
	
}
