package kodluyoruz.ParkingControlSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.ParkingControlSystem.entities.concretes.RentalDetail;

public interface RentalDetailDao extends JpaRepository<RentalDetail, Integer> {
	RentalDetail getByParkRentalId(Integer parkRentalId);
}
