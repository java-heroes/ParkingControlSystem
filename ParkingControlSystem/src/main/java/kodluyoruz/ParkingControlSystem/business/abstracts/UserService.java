package kodluyoruz.ParkingControlSystem.business.abstracts;

import java.util.List;

import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();

	DataResult<List<User>> getAllSorted();

	Result add(User user);

	Result update(User user);

	Result delete(Integer id);

	DataResult<User> getByPlaque(String plaque);

	DataResult<List<User>> getByPlaqueContains(String plaque);

	DataResult<List<User>> getByPlaqueStartsWith(String plaque);

}
