package org.hibernate.maxfront;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.catdao;
import com.model.Category;

@Controller
public class CategoryController {

	@Autowired
	catdao categories;
	
	@RequestMapping(value="/category1")
	public String showCategory(Model m)
	{
		System.out.println("JAva Code");
		List<Category> ListCategories=categories.ListCategories();
		//binding the listCategories and sending to jsp page
		m.addAttribute("ListCategories", ListCategories); 
		return "Category";
	}
	
	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategoryDetail(@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	{
	Category cat=new Category();
	cat.setCategoryname(categoryName);
	cat.setCategorydesc(categoryDesc);
	categories.add(cat);
	List<Category> ListCategories=categories.ListCategories();
	//binding the listCategories and sending to jsp page
	m.addAttribute("ListCategories", ListCategories);
	//categories.add(cat);
	return "Category";
	}
	

	@RequestMapping(value="/deleteCategory/{categoryid}")
	public String deleteCategory(@PathVariable("categoryid")int categoryid,Model m)
	{
		Category cat1=categories.getmodel(categoryid);
		categories.delete(cat1);
		
		List<Category> ListCategories=categories.ListCategories();
		//binding the listCategories and sending to jsp page
		m.addAttribute("ListCategories", ListCategories); 
		return "Category";
	}
	
	
	@RequestMapping(value="/editCategory/{categoryid}")
	public String editCategory(@PathVariable("categoryid")int categoryid,Model m)
	{
		Category cat2=categories.getmodel(categoryid);
		m.addAttribute("cat2",cat2);
		return "Update";
	}
	

	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryid")int categoryid,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc") String categoryDesc,Model m)
	{
		Category cat3=categories.getmodel(categoryid);
		
		cat3.setCategoryname(categoryName);
		cat3.setCategorydesc(categoryDesc);
		
		categories.update(cat3);
		
		List<Category> ListCategories=categories.ListCategories();
		//binding the listCategories and sending to jsp page
		m.addAttribute("ListCategories", ListCategories); 
		return "Category";
	}
	
	public LinkedHashMap<Integer, String> getCategoryList(List<Category> listCategory) {
		LinkedHashMap<Integer, String> categoryData = new LinkedHashMap<Integer, String>();

		int count = 0;
		while (count < listCategory.size()) {
			categoryData.put(listCategory.get(count).getCategoryid(), listCategory.get(count).getCategoryname());
			count++;
		}
		return categoryData;
	}	
}
