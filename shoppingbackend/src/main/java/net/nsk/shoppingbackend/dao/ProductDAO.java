package net.nsk.shoppingbackend.dao;

import java.util.List;

import net.nsk.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

	// bussiness methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryid);
	List<Product> getLatestActiveProducts(int count);


	

}
