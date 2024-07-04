package uisrael.ms_production_cost.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uisrael.ms_production_cost.model.Workforce;
import uisrael.ms_production_cost.repository.workforceRepository;
import uisrael.ms_production_cost.services.workforceServices;

@Service
public class workforceServicesImpl implements workforceServices{

	@Autowired
	private workforceRepository repo;
	
	@Override
	public boolean save(Workforce newI) {
		newI.setActive(true); 
		if(newI.getId()!= 0) {
			System.out.println("Correcta inserción de los datos");
			return repo.save(newI)!=null;			
		}
		return false;
	}

	@Override
	public List<Workforce> list() { 
		return repo.findByActiveTrue();
	}

	@Override
	public void delete(int id) {
		Optional<Workforce> workforceOpt = repo.findById(id);
		//La siguiente linea verifica si se encuentra activo el producto
		if (workforceOpt.isPresent()) {
			Workforce workforce = workforceOpt.get();
			workforce.setActive(false);
			repo.save(workforce);
		}		
	}

	@Override
	public void listId(int id) {
		repo.findById(id);
	}

	@Override
	public boolean update(Workforce I) {
		Optional<Workforce> productOpt = repo.findById(I.getId()); //Verifica si es existe o no el producto en la relación/tabla
        if (productOpt.isPresent()) {
        	Workforce existing = productOpt.get(); //Si existe, trae la entidad y la llena de nuevo para su actualización
        	existing.setName(I.getName());
        	existing.setCost(I.getCost());        	
            return repo.save(existing) != null;            
        }
        else {
            return false;
        }
        
		
	}
	
}
