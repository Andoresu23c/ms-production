package uisrael.ms_production_cost.services;

import java.util.List;

import uisrael.ms_production_cost.model.Totalcost;

public interface totalcostServices {
	public boolean save (Totalcost newI);
	public List<Totalcost> list();
	public void delete(int id);
	public void listId(int id);
	public boolean update(Totalcost I);
}
