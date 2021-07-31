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
import org.springframework.web.bind.annotation.RestController;

import kodluyoruz.ParkingControlSystem.business.abstracts.RentalDetailService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.RentalDetail;

@RestController
@RequestMapping("/api/rentalDetails")
public class RentalDetailsController {

	private RentalDetailService rentalDetailService;
	
	@Autowired
	public RentalDetailsController(RentalDetailService rentalDetailService) {
		super();
		this.rentalDetailService = rentalDetailService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<RentalDetail>> getAll() {
		return this.rentalDetailService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody RentalDetail rentalDetail) {
		return this.rentalDetailService.add(rentalDetail);
	}

	@PutMapping("/update")
	public Result update(@RequestBody RentalDetail rentalDetail) {
		return this.rentalDetailService.update(rentalDetail);
	}

	@DeleteMapping("/delete/{id}")
	private Result delete(@PathVariable("id") Integer id) {
		return this.rentalDetailService.delete(id);
	}
}
