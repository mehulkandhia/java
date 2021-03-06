package org.hibernate.fraction.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dao.catdao;
import com.dao.productdao;
import com.model.Category;
import com.model.product;

@Controller
public class ProductController {

	@Autowired
	productdao production;

	@Autowired
	catdao categories;
	
	@RequestMapping(value="/product4")
	public String showproduct(Model m)
	{
		product prod=new product();
		m.addAttribute("prod",prod);
		List<product> ListProducts=production.ListProducts();
		m.addAttribute("productList", ListProducts);
		List<Category> ListCategory=categories.ListCategories();
		m.addAttribute("ListCategory",this.getCategoryList(ListCategory));
		m.addAttribute("userClickProduct", true);
		/*product prod=new product();
		m.addAttribute("prod",prod);*/
		return "product";
	}
	
	/*@RequestMapping(value="/product5")
	public String listproduct(Model m)
	{
		List<product> ListProducts=production.ListProducts();
		m.addAttribute("productList", ListProducts);
		return "listproduct";
	}
	
	@RequestMapping(value="/product6")
	public String update_delete(Model m)
	{
		product prod=new product();
		m.addAttribute("prod1",prod);
		List<product> ListProducts=production.ListProducts();
		m.addAttribute("productList", ListProducts);
		List<Category> ListCategory=categories.ListCategories();
		m.addAttribute("ListCategory",this.getCategoryList(ListCategory));
		return "update_deleteproduct";
	}*/
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("prod")product prod,@RequestParam("pimage")MultipartFile prodImage,Model m)
	{
		production.add(prod);
String path="C:\\Users\\HP\\eclipse-workspace\\fraction\\src\\main\\webapp\\assets\\images\\";
		
		path=path+String.valueOf(prod.getProductid())+".jpg";
		
		File imageFile=new File(path);
		
		if(!prodImage.isEmpty())
		{
			try
			{
				byte[] buffer=prodImage.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
				m.addAttribute("Error","Exception Occured during the Image Uploading"+e);	
			}
		}
		else
		{
			System.out.println("error occured");
			m.addAttribute("Error","Error Occured during the Image Uploading");
		}
		product prod1=new product();
		m.addAttribute("prod", prod1);
		
		List<product> ListProducts=production.ListProducts();
		m.addAttribute("productList", ListProducts);
		
		List<Category> ListCategory=categories.ListCategories();
		m.addAttribute("ListCategory",this.getCategoryList(ListCategory));
		return "product";
	}
	
	@RequestMapping(value="/editProduct/{productid}")
	public String editProduct(@PathVariable("productid")int productid,@RequestParam("price")int price,@RequestParam("stock")int stock,Model m)
	{
		product prod=production.getproduct(productid);
		prod.setPrice(price);
		prod.setStock(stock);
		production.update(prod);
		m.addAttribute("prod",prod);
		
		List<product> productList=production.ListProducts();
		m.addAttribute("productList", productList);
		
		List<Category> ListCategory=categories.ListCategories();
		m.addAttribute("ListCategory",this.getCategoryList(ListCategory));
		return "product";
	}
	
	/*@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String editProduct(@RequestParam("productid")int productid,@RequestParam("productname")String productname,
	@RequestParam("brandname") String brandname,@RequestParam("productdesc") String productdesc,@RequestParam("price") int price,
	@RequestParam("stock") int stock,@RequestParam("supplierid") int supplierid,@RequestParam("categoryid") String categoryid,Model m)
	{
		product prod3=production.getproduct(productid);
		prod3.setProductname(productname);
		prod3.setBrandname(brandname);
		prod3.setProductdesc(productdesc);
		prod3.setPrice(price);
		prod3.setStock(stock);
		prod3.setSupplierid(supplierid);
		int a=Integer.parseInt(categoryid);
		prod3.setCategoryid(a);
		production.update(prod3);
		
		m.addAttribute("prod",prod3);
		
		List<product> productList=production.ListProducts();
		m.addAttribute("productList", productList);
		
		List<Category> ListCategory=categories.ListCategories();
		m.addAttribute("ListCategory",this.getCategoryList(ListCategory));
		return "update_deleteproduct";
	}*/

	/*@RequestMapping(value="/UpsetProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("prod")product prod,Model m)
	{
		System.out.println("Three");
		//product prod=production.getproduct(productid);
		//product prod=production.getproduct(productid);
		production.update(prod);
		System.out.println("Four");
		//product prod=production.getproduct(productid);
		product prod1=new product();
		
		System.out.println("one");
		m.addAttribute("prod",prod1);
		
		System.out.println("Two");
		List<product> productList=production.ListProducts();
		m.addAttribute("productList", productList);
		
		List<Category> ListCategory=categories.ListCategories();
		m.addAttribute("ListCategory",this.getCategoryList(ListCategory));
		return "product";
	}*/
	
	@RequestMapping(value="/deleteProduct/{productid}")
	public String deleteProduct(@PathVariable("productid")int productid,Model m)
	{
		product prod=production.getproduct(productid);
		production.delete(prod);
		
		product prod1=new product();
		m.addAttribute("prod",prod1);
		
		List<product> ListProducts=production.ListProducts();
		m.addAttribute("productList", ListProducts);
		
		List<Category> ListCategory=categories.ListCategories();
		m.addAttribute("ListCategory",this.getCategoryList(ListCategory));
		
		return "product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> listCategory)
	{
		LinkedHashMap<Integer,String> categoryData=new LinkedHashMap<Integer,String>();
		
		int count=0;
		while(count<listCategory.size())
		{
			categoryData.put(listCategory.get(count).getCategoryid(),listCategory.get(count).getCategoryname());
			count++;
		}
		return categoryData;
	}
}
