package kodluyoruz.ParkingControlSystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodluyoruz.ParkingControlSystem.business.abstracts.ParkLayoutService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.ErrorResult;
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
	public Result update(ParkLayout parkLayout) {
		Optional<ParkLayout> getParkLayout = parkLayoutDao.findById(parkLayout.getId());
		if(!getParkLayout.isPresent()) {
			return new ErrorResult("Data Id'si bulunamadı");
		}
		this.parkLayoutDao.save(parkLayout);
		return new SuccessResult("Data güncellendi");
	}

	@Override
	public DataResult<ParkLayout> deleteById(int id) {
		return new SuccessDataResult<ParkLayout>(this.parkLayoutDao.deleteById(id), "Data silindi");
	}
	
	@Override
	public DataResult<ParkLayout> getByName(String name) {
		return new SuccessDataResult<ParkLayout>(this.parkLayoutDao.getByName(name), "Data listelendi");
		
	}

	@Override
	public DataResult<ParkLayout> getByNameAndCarParkId(String name, int carParkId) {
		return new SuccessDataResult<ParkLayout>(this.parkLayoutDao.getByNameAndCarParkId(name, carParkId), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getByNameOrCarPark(String name, int carParkId) {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.getByNameOrCarPark(name, carParkId), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getByCarParkIdIn(List<Integer> carParks) {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.getByCarParkIdIn(carParks), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getByNameContains(String name) {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.getByNameContains(name), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getByNameStartsWith(String name) {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.getByNameStartsWith(name), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getByNameAndCarPark(String name, int carParkId) {
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.getByNameAndCarPark(name, carParkId), "Data listelendi");
		
	}

	@Override
	public DataResult<List<ParkLayout>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return new SuccessDataResult<List<ParkLayout>>(this.parkLayoutDao.findAll(sort), "Otopark düzeni listelendi");
	}

	

}
