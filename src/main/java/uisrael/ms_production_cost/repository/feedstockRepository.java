package uisrael.ms_production_cost.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uisrael.ms_production_cost.model.Feedstock;

@Repository
public interface feedstockRepository extends JpaRepository<Feedstock, Integer>{	
	List<Feedstock> findByActiveTrue();
}
