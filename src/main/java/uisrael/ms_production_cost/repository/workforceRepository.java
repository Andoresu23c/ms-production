package uisrael.ms_production_cost.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uisrael.ms_production_cost.model.Workforce;

@Repository
public interface workforceRepository extends JpaRepository<Workforce, Integer>{
	List<Workforce> findByActiveTrue();
}
