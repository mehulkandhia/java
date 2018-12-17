package org.hibernate.fraction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.catdao;
import com.dao.productdao;
import com.model.Category;
import com.model.product;

@Controller
public class HomeController {

	@Autowired
	catdao categories;
	
	@Autowired
	productdao production;
	
	@RequestMapping(value= {"", "/home1", "/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("test");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("cat", categories.ListCategories());
		System.out.println("JAva Code");
		
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("test");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		System.out.println("JAva Code");
		return mv;
	}
	
	/*@RequestMapping(value="/product")
	public ModelAndView product()
	{
		ModelAndView mv=new ModelAndView("test");
		mv.addObject("title", "Product");
		mv.addObject("userClickProduct", true);
		System.out.println("JAva Code");
		return mv;
	}*/
	
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("test");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		System.out.println("JAva Code");
		return mv;
	}
	
	@RequestMapping(value="/listproducts/products")
	public ModelAndView ShowAllProducts()
	{
		ModelAndView mv=new ModelAndView("test");
		mv.addObject("title", "AllProducts");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("productList", production.ListProducts());
		mv.addObject("cat", categories.ListCategories());
		System.out.println("JAva Code");
		
		return mv;
	}
	
	@RequestMapping(value="/category1/{categoryid}/products")
	public ModelAndView ShowCategoryProducts(@PathVariable("categoryid")int categoryid)
	{
		ModelAndView mv=new ModelAndView("test");
		//CategoryDao to fetch a single category
		
		Category c=null;
		c=categories.getmodel(categoryid);
		mv.addObject("title", c.getCategoryname());
		
		//passing the list of categories
		mv.addObject("cat", categories.ListCategories());
		
		//Passing a single category
		mv.addObject("c", c);
		
		mv.addObject("userClickAllCategoryProducts", true);
		System.out.println("JAva Code");
		
		return mv;
	}
	
	@RequestMapping(value="/show/{productid}/product")
	public ModelAndView ShowSingleProduct(@PathVariable("productid") int productid)
	{
		ModelAndView mv=new ModelAndView("test");
		product prod=production.getproduct(productid);
		mv.addObject("title", prod.getProductname());
		mv.addObject("product", prod);
		mv.addObject("userClickShowProduct", true);
		System.out.println("JAva Code");
		
		return mv;
	}
}
