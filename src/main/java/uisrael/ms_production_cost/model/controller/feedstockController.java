package uisrael.ms_production_cost.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import uisrael.ms_production_cost.model.Feedstock;
import uisrael.ms_production_cost.services.impl.feedstockServicesImpl;

@RestController
@RequestMapping("/api/production-cost/feedstock")
public class feedstockController {
	@Autowired
	private feedstockServicesImpl serv;
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.OK)
	public boolean save (@RequestBody Feedstock n) {
		return serv.save(n);
	}
	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	public List<Feedstock> list(){
		return serv.list();
	}
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public boolean update(@RequestBody Feedstock n) {
		return serv.update(n);
	}
	@DeleteMapping("/delete-{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		serv.delete(id);
	}
}
