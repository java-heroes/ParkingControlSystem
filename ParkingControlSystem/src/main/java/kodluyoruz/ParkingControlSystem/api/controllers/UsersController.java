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

import kodluyoruz.ParkingControlSystem.business.abstracts.UserService;
import kodluyoruz.ParkingControlSystem.core.utilities.results.DataResult;
import kodluyoruz.ParkingControlSystem.core.utilities.results.Result;
import kodluyoruz.ParkingControlSystem.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getAll")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}

	@GetMapping("/getAllSorted")
	public DataResult<List<User>> getAllSorted() {
		return this.userService.getAllSorted();
	}

	@PostMapping("/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}

	@PutMapping("/update")
	public Result update(@RequestBody User user) {
		return this.userService.update(user);
	}

	@DeleteMapping("/delete/{id}")
	private Result delete(@PathVariable("id") Integer id) {
		return this.userService.delete(id);
	}

	@GetMapping("/getByPlaque")
	public DataResult<User> getByPlaque(@RequestParam String plaque) {
		return this.userService.getByPlaque(plaque);
	}

	@GetMapping("/getByPlaqueContains")
	public DataResult<List<User>> getByPlaqueContains(@RequestParam String plaque) {
		return this.userService.getByPlaqueContains(plaque);
	}

	@GetMapping("/getByPlaqueStartsWith")
	public DataResult<List<User>> getByPlaqueStartsWith(@RequestParam String plaque) {
		return this.userService.getByPlaqueStartsWith(plaque);
	}
}
