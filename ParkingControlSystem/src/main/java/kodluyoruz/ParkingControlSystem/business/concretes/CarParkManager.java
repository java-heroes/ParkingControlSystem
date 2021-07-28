package kodluyoruz.ParkingControlSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodluyoruz.ParkingControlSystem.business.abstracts.CarParkService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessDataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessResult;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.CarParkDao;
import kodluyoruz.ParkingControlSystem.entities.concretes.CarPark;

@Service
public class CarParkManager implements CarParkService{

private CarParkDao carParkDao;
	
	@Autowired
	public CarParkManager(CarParkDao carParkDao) {
		super();
		this.carParkDao = carParkDao;
	}

	@Override
	public DataResult<List<CarPark>> getAll() {
		
		return new SuccessDataResult<List<CarPark>>(this.carParkDao.findAll(), "Otoparklar listelendi");
		
	}

	@Override
	public Result add(CarPark carPark) {
		this.carParkDao.save(carPark);
		return new SuccessResult("Otopark eklendi");
	}

	@Override
	public DataResult<CarPark> getByName(String name) {
		
		return new SuccessDataResult<CarPark>(this.carParkDao.getByName(name), "Otoparklar listelendi");
	}

	@Override
	public DataResult<CarPark> getByNameAndOwnerId(String name, int ownerId) {
		//business codes
		
		return new SuccessDataResult<CarPark>(this.carParkDao.getByNameAndOwner_id(name, ownerId), "Otoparklar listelendi");
	}

	@Override
	public DataResult<List<CarPark>> getByNameOrOwnerId(String name, int ownerId) {
		
		return new SuccessDataResult<List<CarPark>>(this.carParkDao.getByNameOrOwner_id(name, ownerId), "Otoparklar listelendi");
	}

	@Override
	public DataResult<List<CarPark>> getByOwnerIdIn(List<Integer> owners) {
		
		return new SuccessDataResult<List<CarPark>>(this.carParkDao.getByOwnerIn(owners), "Otoparklar listelendi");
	}

	@Override
	public DataResult<List<CarPark>> getByNameContains(String name) {
		
		return new SuccessDataResult<List<CarPark>>(this.carParkDao.getByNameContains(name), "Otoparklar listelendi");
	}

	@Override
	public DataResult<List<CarPark>> getByNameStartsWith(String name) {
		
		return new SuccessDataResult<List<CarPark>>(this.carParkDao.getByNameStartsWith(name), "Otoparklar listelendi");
	}

	@Override
	public DataResult<List<CarPark>> getByNameAndOwner(String name, int ownerId) {
		
		return new SuccessDataResult<List<CarPark>>(this.carParkDao.getByNameAndOwner(name, ownerId), "Otoparklar listelendi");
	}

	@Override
	public DataResult<List<CarPark>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return new SuccessDataResult<List<CarPark>>(this.carParkDao.findAll(sort), "Otoparklar listelendi");
	}
}
