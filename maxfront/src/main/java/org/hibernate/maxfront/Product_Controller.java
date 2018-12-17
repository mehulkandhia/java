package org.hibernate.maxfront;

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
public class Product_Controller {

	@Autowired
	productdao production;

	@Autowired
	catdao categories;
	
	@RequestMapping(value="/process")
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
	
	@RequestMapping(value="/InsertProduction",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("prod")product prod,@RequestParam("pimage")MultipartFile prodImage,Model m)
	{
		production.add(prod);
String path="C:\\Users\\HP\\eclipse-workspace\\front\\src\\main\\webapp\\assets\\images\\";
		
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
	public String editProduct(@PathVariable("productid")int productid,Model m)
	{
		product prod=production.getproduct(productid);
		m.addAttribute("prod",prod);
		
		List<product> productList=production.ListProducts();
		m.addAttribute("productList", productList);
		
		List<Category> ListCategory=categories.ListCategories();
		m.addAttribute("ListCategory",this.getCategoryList(ListCategory));
		return "updating";
	}

	@RequestMapping(value="/UpsetProduct",method=RequestMethod.POST)
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
	}
	
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
