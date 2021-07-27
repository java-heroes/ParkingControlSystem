package kodluyoruz.ParkingControlSystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodluyoruz.ParkingControlSystem.entities.concretes.ParkLayout;

public interface ParkLayoutDao extends JpaRepository<ParkLayout, Integer>{

}
