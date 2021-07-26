package kodluyoruz.ParkingControlSystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodluyoruz.ParkingControlSystem.business.abstracts.OwnerService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.Owner;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
	
	private OwnerService ownerService;
	
	@Autowired
	public OwnerController(OwnerService ownerService)  {
		super();
		this.ownerService = ownerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Owner>> getAll() {
		
		return this.ownerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Owner owner) {
		return this.ownerService.add(owner);
	}
	
	@DeleteMapping("/delete/{id}")
	private void deleteById(@PathVariable("id") Integer id) {
		ownerService.deleteByOwnerId(id);
	}
	

}
