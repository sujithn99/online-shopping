package net.nsk.shoppingbackend.dao;


import java.util.List;

import net.nsk.shoppingbackend.dto.Category;

public interface CategoryDAO {

	public List<Category> list();
	
	public Category get(int id);
}
