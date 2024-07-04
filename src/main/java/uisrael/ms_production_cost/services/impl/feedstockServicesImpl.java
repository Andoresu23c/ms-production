package uisrael.ms_production_cost.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uisrael.ms_production_cost.model.Feedstock;
import uisrael.ms_production_cost.repository.feedstockRepository;
import uisrael.ms_production_cost.services.feedstockServices;

@Service
public class feedstockServicesImpl implements feedstockServices{
	@Autowired
    private feedstockRepository repo;
	
	@Override
	public boolean save(Feedstock newFeed) {
		newFeed.setActive(true); 
		return repo.save(newFeed) != null;
	}

	@Override
	public List<Feedstock> list() {		
		return repo.findByActiveTrue();
	}
	
	@Override
	public void delete(int id) {
		Optional<Feedstock> feedstockOpt = repo.findById(id);
		//La siguiente linea verifica si se encuentra activo el producto
		if (feedstockOpt.isPresent()) {
			Feedstock feedstock = feedstockOpt.get();
			feedstock.setActive(false);
			repo.save(feedstock);
		}			
	}

	@Override
	public void listId(int id) {
		repo.findById(id);
		
	}

	@Override
	public boolean update(Feedstock feed) {
		 Optional<Feedstock> feedstockOpt = repo.findById(feed.getId());
	        if (feedstockOpt.isPresent()) {
	            Feedstock existingFeedstock = feedstockOpt.get();
	            existingFeedstock.setName(feed.getName());
	            existingFeedstock.setQuantity(feed.getQuantity());
	            existingFeedstock.setUnit(feed.getUnit());
	            existingFeedstock.setUnitCost(feed.getUnitCost());	            
	            return repo.save(existingFeedstock) != null;
	        }
	     return true;
	}

}
