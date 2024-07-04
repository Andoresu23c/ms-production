package uisrael.ms_production_cost.services;

import java.util.List;

import uisrael.ms_production_cost.model.Feedstock;

public interface feedstockServices {
	public boolean save (Feedstock newFeed);
	public List<Feedstock> list();
	public void delete(int id);
	public void listId(int id);
	public boolean update(Feedstock feed);
}
