package net.nsk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.nsk.shoppingbackend.dao.CategoryDAO;
import net.nsk.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private static Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.nsk.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Fashion");
	 * category.setDescription("description for television");
	 * category.setImageUrl("CAT_4.png"); category.setActive(true);
	 * 
	 * assertEquals("successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(3);
	 * 
	 * assertEquals("successfully fetched a single category inside the table!",
	 * "Mobile", category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(2);
	 * category.setName("TV");
	 * 
	 * assertEquals("successfully Updated a single category inside the table!",
	 * true, categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(2);
	 * 
	 * 
	 * assertEquals("successfully deleted a single category inside the table!",
	 * true, categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListeCategory() {
	 * 
	 * assertEquals("successfully fetched list of category inside the table!", 4,
	 * categoryDAO.list().size());
	 * 
	 * }
	 */

	@Test
	public void testCrudCategory() {

		category = new Category();

		category.setName("Laptop");
		category.setDescription("description for Laptop");
		category.setImageUrl("CAT_1.png");
		category.setActive(true);

		assertEquals("successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("description for television");
		category.setImageUrl("CAT_2.png");
		category.setActive(true);

		assertEquals("successfully added a category inside the table!", true, categoryDAO.add(category));

		// fetching and updating category
		category = categoryDAO.get(2);
		category.setName("TV");
		
		assertEquals("successfully Updated a single category inside the table!", true, categoryDAO.update(category));

		// deleting category
		category = categoryDAO.get(2);

		assertEquals("successfully deleted a single category inside the table!", true, categoryDAO.delete(category));
		
		// fetching list
		assertEquals("successfully fetched list of category inside the table!", 6,categoryDAO.list().size());
	}

}
