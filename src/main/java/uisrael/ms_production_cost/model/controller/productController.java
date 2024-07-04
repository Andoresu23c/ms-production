package uisrael.ms_production_cost.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uisrael.ms_production_cost.model.Product;
import uisrael.ms_production_cost.services.impl.productServicesImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/production-cost/product")
public class productController {
	@Autowired
	private productServicesImpl serv;
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.OK)
	public boolean save (@RequestBody Product nProd) {
		return serv.newProduct(nProd);
	}
	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> list(){
		return serv.listProduct();
	}
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public boolean update(@RequestBody Product prod) {
		return serv.update(prod);
	}
	@DeleteMapping("/delete-{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		serv.deleteProduct(id);
	}
}
