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
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public DataResult<Owner> getByOwnerName(String name) {
		return new SuccessDataResult<Owner>
		(this.ownerDao.getByOwnerName(name), "Data listelendi");
	}

	@Override
	public DataResult<Owner> getByOwnerNameAndOwnerSurname(String name, String surname) {
		return new SuccessDataResult<Owner>
		(this.ownerDao.getByOwnerNameAndOwnerSurname(name, surname), "Data listelendi");
	}

	@Override
	public DataResult<List<Owner>> getByMailOrPhoneNumber(String mail, String phone_number) {
		return new SuccessDataResult<List<Owner>>
		(this.ownerDao.getByMailOrPhoneNumber(mail, phone_number), "Data listelendi");
	}

	@Override
	public DataResult<List<Owner>> getByOwnerNameContains(String name) {
		return new SuccessDataResult<List<Owner>>
		(this.ownerDao.getByOwnerNameContains(name), "Data listelendi");
	}

	@Override
	public DataResult<List<Owner>> deleteByOwnerId(Integer id) {
		return new SuccessDataResult<List<Owner>>
		(this.ownerDao.deleteByOwnerId(id), "Data silindi");
	}

}
