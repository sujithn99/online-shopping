package net.nsk.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.nsk.shoppingbackend.dao.CategoryDAO;
import net.nsk.shoppingbackend.dto.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();

	

	public List<Category> list() {

		String selectActiveCategory = "from Category where active = :active";
		System.out.println("daolist ");
		Query query= sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	//getting single category
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	
	public boolean add(Category category) {

		try {
			// add the category to db
			sessionFactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// updating single category
	@Override
	public boolean update(Category category) {
		try {
			// add the category to db
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {
			// add the category to db
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	/*static {

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
*/
}
