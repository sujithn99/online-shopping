package net.nsk.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.nsk.shoppingbackend.dao.CategoryDAO;
import net.nsk.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		category.setId(1);
		category.setName("Television");
		category.setDescription("description for television");
		category.setImageUrl("CAT_1.png");
		category.setActive(true);

		categories.add(category);

		// cat 2

		category = new Category();

		category.setId(2);
		category.setName("Mobile");
		category.setDescription("description for Mobile!");
		category.setImageUrl("CAT_2.png");
		category.setActive(true);

		categories.add(category);

		// cat 2

		category = new Category();

		category.setId(3);
		category.setName("Laptop");
		category.setDescription("description for Laptop");
		category.setImageUrl("CAT_3.png");
		category.setActive(true);

		categories.add(category);

	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// for each loop
		for(Category category : categories) {
			if(category.getId() == id) return category;
		}
		
		return null;
	}

}
