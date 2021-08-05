package kodluyoruz.ParkingControlSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodluyoruz.ParkingControlSystem.business.abstracts.RentalDetailService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
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
	
	
	
	
}
