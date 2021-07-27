package kodluyoruz.ParkingControlSystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodluyoruz.ParkingControlSystem.business.abstracts.UserService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.ErrorResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessDataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessResult;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.UserDao;
import kodluyoruz.ParkingControlSystem.entities.concretes.User;

@Service
public class UserManager implements UserService {
	private UserDao userDao;

	public static List<User> users;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Data eklendi");
	}

	@Override
	public Result update(User user) {
		Optional<User> getUser = userDao.findById(user.getId());
		  if(!getUser.isPresent()) {
		         return new ErrorResult("Data ID'si bulunamadı");
		    }
	    this.userDao.save(user);
		return new SuccessResult("Data güncellendi");
	}

	@Override
	public Result delete(Integer id) {
		this.userDao.deleteById(id);
		return new SuccessResult("Data silindi");
	}

	@Override
	public DataResult<User> getByPlaque(String plaque) {
		return new SuccessDataResult<User>(this.userDao.getByPlaque(plaque), "Data listelendi");
	}

	@Override
	public DataResult<List<User>> getByPlaqueContains(String plaque) {
		return new SuccessDataResult<List<User>>(this.userDao.getByPlaqueContains(plaque), "Data listelendi");
	}

	@Override
	public DataResult<List<User>> getByPlaqueStartsWith(String plaque) {
		return new SuccessDataResult<List<User>>(this.userDao.getByPlaqueStartsWith(plaque), "Data listelendi");
	}

	@Override
	public DataResult<List<User>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "plaque");
		return new SuccessDataResult<List<User>>(this.userDao.findAll(sort), "Başarılı");
	}

}
