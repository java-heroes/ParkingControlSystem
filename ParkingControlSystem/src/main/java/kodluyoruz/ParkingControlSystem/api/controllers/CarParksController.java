package kodluyoruz.ParkingControlSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodluyoruz.ParkingControlSystem.business.abstracts.CarParkService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.CarPark;

@RestController
@RequestMapping("/api/carParks")
public class CarParksController {
	
private CarParkService carParkService;
	
	@Autowired
	public CarParksController(CarParkService carParkService) {
		super();
		this.carParkService = carParkService;
	}

	@GetMapping("/getall")
	public  DataResult<List<CarPark>> getAll(){
		return this.carParkService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody CarPark carPark) {
		return this.carParkService.add(carPark);
	}
	
	@PutMapping("/update")
    public Result update(@RequestBody CarPark carPark) {
        return this.carParkService.update(carPark);
    }
	
	
	@DeleteMapping("/delete/{id}")
	private void deleteById(@PathVariable("id") int id) {
		carParkService.deleteById(id);
	}
	
	@GetMapping("/getByName")
	public DataResult<CarPark> getByName(@RequestParam String name){
		return this.carParkService.getByName(name);
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<CarPark>> getAllSorted(){
		return this.carParkService.getAllSorted();
	}

}
