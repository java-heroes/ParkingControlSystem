package kodluyoruz.ParkingControlSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.ParkingControlSystem.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getByPlaque(String plaque);

	List<User> getByPlaqueContains(String plaque);

	List<User> getByPlaqueStartsWith(String plaque);

}
