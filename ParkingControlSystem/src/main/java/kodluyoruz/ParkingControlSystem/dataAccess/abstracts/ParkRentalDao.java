package kodluyoruz.ParkingControlSystem.dataAccess.abstracts;

import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface ParkRentalDao extends JpaRepository<ParkRental, Integer> {


    ParkRental getByRentDate(Date rentDate);

    //ParkRental getByRentDateAndEndDate(Date rentDate, Date endDate);

    List<ParkRental> getByRentDateContains(Date rentDate);

    ParkRental deleteById(int id);
    
    List<ParkRental> getByParkLayoutId(int parkLayoutId);
}
