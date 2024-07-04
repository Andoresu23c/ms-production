package uisrael.ms_production_cost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uisrael.ms_production_cost.model.Totalcost;

@Repository
public interface totalcostRepository extends JpaRepository<Totalcost, Integer>{
	List<Totalcost> findByActiveTrue();
}	
