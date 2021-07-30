package kodluyoruz.ParkingControlSystem.api.controllers;

import kodluyoruz.ParkingControlSystem.business.abstracts.ParkRentalService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/parkRentals")
public class ParkRentalsController {

    private ParkRentalService parkRentalService;

    @Autowired
    public ParkRentalsController(ParkRentalService parkRentalService) {
        super();
        this.parkRentalService=parkRentalService;
    }

    @GetMapping("/getAll")
    public DataResult<List<ParkRental>> getAll(){
        return this.parkRentalService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody ParkRental parkRental){
        return this.parkRentalService.add(parkRental);
    }

    @PutMapping("/update")
    public Result update(@RequestBody ParkRental parkRental) {
        return this.parkRentalService.update(parkRental);
    }

    @DeleteMapping("/delete/{id}")
    private DataResult<ParkRental> deleteById(@PathVariable("id") int id){
        return this.parkRentalService.deleteById(id);
    }
}
