package uisrael.ms_production_cost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uisrael.ms_production_cost.model.Product;

@Repository
public interface productRepository extends JpaRepository<Product, Integer>{
	List<Product> findByActiveTrue();
}
