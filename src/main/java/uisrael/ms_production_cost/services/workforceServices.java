package uisrael.ms_production_cost.services;

import java.util.List;

import uisrael.ms_production_cost.model.Workforce;


public interface workforceServices {
	public boolean save (Workforce newI);
	public List<Workforce> list();
	public void delete(int id);
	public void listId(int id);
	public boolean update(Workforce I);
}
