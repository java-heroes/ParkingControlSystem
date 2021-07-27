package kodluyoruz.ParkingControlSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodluyoruz.ParkingControlSystem.business.abstracts.OwnerService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessDataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.SuccessResult;
import kodluyoruz.ParkingControlSystem.dataAccess.abstracts.OwnerDao;
import kodluyoruz.ParkingControlSystem.entities.concretes.Owner;

@Service
public class OwnerManager implements OwnerService {
	
	private OwnerDao ownerDao;
	
	@Autowired
	public OwnerManager(OwnerDao ownerDao)  {
		super();
		this.ownerDao = ownerDao;
	}

	@Override
	public DataResult<List<Owner>> getAll() {
		return new SuccessDataResult<List<Owner>>(this.ownerDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Owner owner) {
		this.ownerDao.save(owner);
		return new SuccessResult("Otopark sahibi eklendi");
	}
	
	@Override
	public Result update(Owner owner) {
		this.ownerDao.save(owner);
		return new SuccessResult("Otopark sahibi gÃ¼ncellendi");
	}

	@Override
	public DataResult<Owner> getByName(String name) {
		return new SuccessDataResult<Owner>
		(this.ownerDao.getByName(name), "Data listelendi");
	}

	@Override
	public DataResult<Owner> getByNameAndSurname(String name, String surname) {
		return new SuccessDataResult<Owner>
		(this.ownerDao.getByNameAndSurname(name, surname), "Data listelendi");
	}

	@Override
	public DataResult<List<Owner>> getByEmailOrPhoneNumber(String email, String phoneNumber) {
		return new SuccessDataResult<List<Owner>>
		(this.ownerDao.getByEmailOrPhoneNumber(email, phoneNumber), "Data listelendi");
	}

	@Override
	public DataResult<List<Owner>> getByNameContains(String name) {
		return new SuccessDataResult<List<Owner>>
		(this.ownerDao.getByNameContains(name), "Data listelendi");
	}

	
	@Override
	public DataResult<List<Owner>> deleteById(int id) {
		return new SuccessDataResult<List<Owner>>
		(this.ownerDao.deleteById(id), "Data silindi");
	}

	

}