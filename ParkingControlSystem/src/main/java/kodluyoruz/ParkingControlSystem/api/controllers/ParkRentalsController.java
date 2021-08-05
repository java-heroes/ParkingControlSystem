package kodluyoruz.ParkingControlSystem.api.controllers;

import kodluyoruz.ParkingControlSystem.business.abstracts.ParkRentalService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkRental;
import kodluyoruz.ParkingControlSystem.entities.dto.ParkRentalDto;
import kodluyoruz.ParkingControlSystem.entities.dto.ParkRentalDtoUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

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

    @Operation(summary="Park Rental Listesi", description = "Park rental listesi getirir")
    @GetMapping("/getAll")
    public DataResult<List<ParkRental>> getAll(){
        return this.parkRentalService.getAll();
    }

    
    @PostMapping(path="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result add(@RequestBody ParkRentalDto parkRentalDto){
        return this.parkRentalService.add(parkRentalDto);
    }

    @PutMapping("/update")
    public Result update(@RequestBody ParkRentalDtoUpdate parkRentalDtoUpdate) {
        return this.parkRentalService.update(parkRentalDtoUpdate);
    }

    @DeleteMapping("/delete/{id}")
    private DataResult<ParkRental> deleteById(@PathVariable("id") int id){
        return this.parkRentalService.deleteById(id);
    }
}
