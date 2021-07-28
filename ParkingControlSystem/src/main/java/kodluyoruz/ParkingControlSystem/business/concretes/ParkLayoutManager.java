package kodluyoruz.ParkingControlSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodluyoruz.ParkingControlSystem.business.abstracts.ParkLayoutService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessDataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessResult;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.ParkLayoutDao;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkLayout;

@Service
public class ParkLayoutManager implements ParkLayoutService{
	
	private ParkLayoutDao parkLayoutDao;
	
	@Autowired
	public ParkLayoutManager(ParkLayoutDao parkLayoutDao) {
		super();
		this.parkLayoutDao = parkLayoutDao;
	}

	@Override
	public DataResult<List<ParkLayout>> getAll() {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.findAll(), "Data listelendi");
		
	}

	@Override
	public Result add(ParkLayout parkLayout) {
		this.parkLayoutDao.save(parkLayout);
		return new SuccessResult("Otopark düzeni eklendi");
	}

	@Override
	public DataResult<ParkLayout> getByName(char name) {
		return new SuccessDataResult<ParkLayout>(this.parkLayoutDao.getByName(name), "Data listelendi");
		
	}

	@Override
	public DataResult<ParkLayout> getByNameAndCarParkId(char name, int carParkId) {
		return new SuccessDataResult<ParkLayout>(this.parkLayoutDao.getByNameAndCarParkId(name, carParkId), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getByNameOrCarPark(char name, int carParkId) {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.getByNameOrCarPark(name, carParkId), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getByCarParkIdIn(List<Integer> carParks) {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.getByCarParkIdIn(carParks), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getByNameContains(char name) {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.getByNameContains(name), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getByNameStartsWith(char name) {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.getByNameStartsWith(name), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getByNameAndCarPark(char name, int carParkId) {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.getByNameAndCarPark(name, carParkId), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.findAll(sort), "Otopark düzeni listelendi");
	}

}
