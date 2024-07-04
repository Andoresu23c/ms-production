package uisrael.ms_production_cost.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uisrael.ms_production_cost.model.Totalcost;
import uisrael.ms_production_cost.repository.totalcostRepository;
import uisrael.ms_production_cost.services.totalcostServices;

@Service
public class totalcostServicesImpl implements totalcostServices{

	@Autowired
	private totalcostRepository repo;
	
	
	@Override
	public boolean save(Totalcost newI) {
		newI.setActive(true); 
		return repo.save(newI) != null;
	}

	@Override
	public List<Totalcost> list() {
		return repo.findByActiveTrue();
	}

	@Override
	public void delete(int id) {
		Optional<Totalcost> totalcostOpt = repo.findById(id);
		//La siguiente linea verifica si se encuentra activo el producto
		if (totalcostOpt.isPresent()) {
			Totalcost totalcost = totalcostOpt.get();
			totalcost.setActive(false);
			repo.save(totalcost);
		}			
	}

	@Override
	public void listId(int id) {
		repo.findById(id);		
	}

	@Override
	public boolean update(Totalcost I) {
		Optional<Totalcost> productOpt = repo.findById(I.getId()); //Verifica si es existe o no el producto en la relación/tabla
        if (productOpt.isPresent()) {
        	Totalcost existing = productOpt.get(); //Si existe, trae la entidad y la llena de nuevo para su actualización
        	existing.setTotalCost(I.getTotalCost());            
            return repo.save(existing) != null;            
        }
        else {
            return false;
        }
        
	}

}
