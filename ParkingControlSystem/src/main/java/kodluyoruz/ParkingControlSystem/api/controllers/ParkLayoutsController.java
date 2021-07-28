package kodluyoruz.ParkingControlSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import kodluyoruz.ParkingControlSystem.business.abstracts.ParkLayoutService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.ParkLayout;

@RestController
@RequestMapping("/api/parkLayouts")
public class ParkLayoutsController {
	
	private ParkLayoutService parkLayoutService;

	@Autowired
	public ParkLayoutsController(ParkLayoutService parkLayoutService) {
		super();
		this.parkLayoutService = parkLayoutService;
	}
	
	@GetMapping("/getall")
	public  DataResult<List<ParkLayout>> getAll(){
		return this.parkLayoutService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody ParkLayout parkLayout) {
		return this.parkLayoutService.add(parkLayout);
	}
	
	@GetMapping("/getByName")
	public DataResult<ParkLayout> getByName(@RequestParam char name){
		return this.parkLayoutService.getByName(name);
	}
	
	@GetMapping("/getByNameAndCarParkId")
	public DataResult<ParkLayout> getByNameAndCarParkId(@RequestParam("name") char name,@RequestParam("carParkId") int carParkId){
		return this.getByNameAndCarParkId(name, carParkId);
	}

}
