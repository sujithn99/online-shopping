package net.nsk.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import net.nsk.shoppingbackend.dao.ProductDAO;
import net.nsk.shoppingbackend.dto.Product;


@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		/*List<Product> list= productDAO.listActiveProducts();
		String result = new Gson().toJson(list);
		
		 response.getWriter().write(result);*/
		
		
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id){
		
		return productDAO.listActiveProductsByCategory(id);
	}
	
}
