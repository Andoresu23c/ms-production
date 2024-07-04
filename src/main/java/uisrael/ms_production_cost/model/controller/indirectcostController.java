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

import uisrael.ms_production_cost.model.Indirectcost;
import uisrael.ms_production_cost.services.impl.indirectcostServicesImpl;

@RestController
@RequestMapping("/api/production-cost/indirectcost")
public class indirectcostController {
	@Autowired
	private indirectcostServicesImpl serv;
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.OK)
	public boolean save (@RequestBody Indirectcost n) {
		return serv.save(n);
	}
	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	public List<Indirectcost> list(){
		return serv.list();
	}
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public boolean update(@RequestBody Indirectcost n) {
		return serv.update(n);
	}
	@DeleteMapping("/delete-{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		serv.delete(id);
	}
}
