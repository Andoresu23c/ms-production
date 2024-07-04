package uisrael.ms_production_cost.services;

import java.util.List;

import uisrael.ms_production_cost.model.Indirectcost;

public interface indirectcostServices {
	public boolean save (Indirectcost newI);
	public List<Indirectcost> list();
	public void delete(int id);
	public void listId(int id);
	public boolean update(Indirectcost I);
}
