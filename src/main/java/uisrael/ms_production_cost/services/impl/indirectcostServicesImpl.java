package uisrael.ms_production_cost.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uisrael.ms_production_cost.model.Indirectcost;
import uisrael.ms_production_cost.repository.indirectcostRepository;
import uisrael.ms_production_cost.services.indirectcostServices;

@Service
public class indirectcostServicesImpl implements indirectcostServices{

	@Autowired
	private indirectcostRepository repo;
	
	@Override
	public boolean save(Indirectcost newI) {
		newI.setActive(true); 
		return repo.save(newI) != null;
	}

	@Override
	public List<Indirectcost> list() {
		return repo.findByActiveTrue();
	}

	@Override
	public void delete(int id) {
		Optional<Indirectcost> indirectcostOpt = repo.findById(id);
		//La siguiente linea verifica si se encuentra activo el producto
		if (indirectcostOpt.isPresent()) {
			Indirectcost indirectcost = indirectcostOpt.get();
			indirectcost.setActive(false);
			repo.save(indirectcost);
		}		
	}

	@Override
	public void listId(int id) {
		repo.findById(id);
	}

	@Override
	public boolean update(Indirectcost I) {
		Optional<Indirectcost> productOpt = repo.findById(I.getId()); //Verifica si es existe o no el producto en la relación/tabla
        if (productOpt.isPresent()) {
        	Indirectcost existing = productOpt.get(); //Si existe, trae la entidad y la llena de nuevo para su actualización
        	existing.setCost(I.getCost());            
            return repo.save(existing) != null;            
        }
        else {
            return false;
        }
	}

}
