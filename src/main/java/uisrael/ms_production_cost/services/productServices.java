package uisrael.ms_production_cost.services;

import java.util.List;

import uisrael.ms_production_cost.model.Product;

public interface productServices {
	public boolean newProduct (Product newProduct);
	public List<Product> listProduct();
	public void deleteProduct(int id);
	public void listProductId(int id);
	public boolean update(Product newproduct);
}
