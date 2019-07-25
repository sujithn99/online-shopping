package net.nsk.shoppingbackend.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import net.nsk.shoppingbackend.dto.Category;

public interface CategoryDAO {

	public Category get(int id);
	public List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}
