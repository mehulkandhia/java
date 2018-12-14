package org.hibernate.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.cartdao;
import com.dao.productdao;
import com.model.Cart;
import com.model.product;

@Controller
public class CartController {

	@Autowired
	cartdao productcart;
	
	@Autowired
	productdao production;
	
	public int calcGrandTotalPrice(List<Cart> listcartitems)
	{
		
		int count=0;
		int grandTotal=0;
		while(count<listcartitems.size())
		{
			Cart cart=listcartitems.get(count);
			grandTotal=grandTotal+(cart.getQuantity()*cart.getPrice());
			count++;
		}
		return grandTotal;
	}
	
	@RequestMapping(value="/addtoCart/{productid}/add")
	public String addtoCart(@PathVariable("productid")int productid,@RequestParam("quantity")int quantity,Model m, String username)
	{
		Cart cart1=new Cart();
		product prod=production.getproduct(productid);
		
		cart1.setProductid(productid);
		cart1.setPrice(prod.getPrice());
		cart1.setProductname(prod.getProductname());
		cart1.setQuantity(quantity);
		cart1.setStatus("N");
		cart1.setUsername("vivo");
		System.out.println("ProductId :"+prod.getProductid()+"Quantity of product :"+prod.getStock()+"Quantity in cart :"+cart1.getQuantity());

		int i=prod.getStock()-cart1.getQuantity();
		
		System.out.println("Product Quantity Updated :"+i);
		
		prod.setStock(i);
		production.update(prod);
		m.addAttribute("cartItems",productcart.add(cart1));	
		m.addAttribute("cartItem",cart1);
		
		List<Cart> listCartItems=productcart.listCartItems(username);
		m.addAttribute("cartitems",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
		m.addAttribute("userClickAddCart", true);
		return "Cart1";
	}
	
	@RequestMapping(value="/UpdateCart/{cartid}/update")
	public String UpdateCart(@PathVariable("cartid")int cartid,@RequestParam("quantity")int quantity,Model m, String username)
	{
		Cart cart1=productcart.getCartItem(cartid);
		cart1.setQuantity(quantity);
		productcart.update(cart1);
		List<Cart> listcartitems=productcart.listCartItems(username);
		m.addAttribute("cartit", productcart.listCartItems(username));
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listcartitems));
		m.addAttribute("cart1", cart1);
		
		List<Cart> cartitemlist=productcart.listCartItems(username);
		m.addAttribute("cartitems", cartitemlist);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(cartitemlist));
		return "Cart1";
	}
	
	@RequestMapping(value="/DeleteCart/{cartid}/delete")
	public String DeleteCart(@PathVariable("cartid")int cartid,Model m)
	{
		String username="vivo";
		Cart cart1=productcart.getCartItem(cartid);
		/*cart1.getProductid();
		//product prod;
		product prod=production.getproduct(productid);
		System.out.println("ProductId :"+prod.getProductid()+"Quantity of product :"+prod.getStock()+"Quantity in cart :"+cart1.getQuantity());

		int i=cart1.getQuantity() + prod.getStock();
		
		System.out.println("Product Quantity Updated :"+i);
		
		prod.setStock(i);
		production.update(prod);*/
		productcart.delete(cart1);
		//product prod=production.getproduct(productid);
		/*System.out.println("ProductId :"+prod.getProductid()+"Quantity of product :"+prod.getStock()+"Quantity in cart :"+cart1.getQuantity());

		int i=cart1.getQuantity() + prod.getStock();
		
		System.out.println("Product Quantity Updated :"+i);
		
		prod.setStock(i);
		production.update(prod);*/
		List<Cart> listcartitems=productcart.listCartItems(username);
		m.addAttribute("cartit", productcart.listCartItems(username));
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listcartitems));
		m.addAttribute("cart1", cart1);
		
		List<Cart> cartitemlist=productcart.listCartItems(username);
		m.addAttribute("cartitems", cartitemlist);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(cartitemlist));
		return "Cart1";
	}
	
	
}
