package uisrael.ms_production_cost.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uisrael.ms_production_cost.model.Product;
import uisrael.ms_production_cost.repository.productRepository;
import uisrael.ms_production_cost.services.productServices;

@Service
public class productServicesImpl implements productServices{

	@Autowired
	private productRepository repo;
	
	@Override
	public boolean newProduct(Product newProduct) {
		newProduct.setActive(true); //se asegura que el producto esté activo
		return repo.save(newProduct) != null;
	}

	@Override
	public List<Product> listProduct() {		
		return repo.findByActiveTrue();
	}

	@Override
	public void deleteProduct(int id) {
		Optional<Product> productOpt = repo.findById(id);
		//La siguiente linea verifica si se encuentra activo el producto
		if (productOpt.isPresent()) {
			Product product = productOpt.get();
			product.setActive(false);
			repo.save(product);
		}		
	}

	@Override
	public void listProductId(int id) {
		
		repo.findById(id);
	}

	@Override
	public boolean update(Product nProd) {
		Optional<Product> productOpt = repo.findById(nProd.getId());
        if (productOpt.isPresent()) {
            Product existingProduct = productOpt.get();
            existingProduct.setName(nProd.getName());
            existingProduct.setCategory(nProd.getCategory());
            return repo.save(existingProduct) != null;
        }
        else {
            return false;
        }

	}
	

}
