package org.hibernate.fraction.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	cartdao productcart1;
	
	@Autowired
	productdao production;
	
	@RequestMapping(value="/cart")
	public String showCart(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<Cart> listcart=productcart1.listCartItems(username);
		m.addAttribute("cartitems", listcart);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listcart));
		return "Cart1";
	}
	public int calcGrandTotalPrice(List<Cart> listcart)
	{
		
		int count=0;
		int grandTotal=0;
		while(count<listcart.size())
		{
			Cart cart=listcart.get(count);
			grandTotal=grandTotal+(cart.getQuantity()*cart.getPrice());
			count++;
		}
		return grandTotal;
	}
	
	@RequestMapping(value="/cartedit/{productid}/addition")
	public String addtoCart(@PathVariable("productid")int productid,@RequestParam("quantity")int quantity,Model m, String username,HttpSession session)
	{
		Cart cart1=new Cart();
		username=(String)session.getAttribute("username");
		product prod=production.getproduct(productid);
		
		cart1.setProductid(productid);
		cart1.setPrice(prod.getPrice());
		cart1.setProductname(prod.getProductname());
		cart1.setQuantity(quantity);
		cart1.setStatus("N");
		cart1.setUsername(username);
		System.out.println("ProductId :"+prod.getProductid()+"Quantity of product :"+prod.getStock()+"Quantity in cart :"+cart1.getQuantity());

		int i=prod.getStock()-cart1.getQuantity();
		
		System.out.println("Product Quantity Updated :"+i);
		
		prod.setStock(i);
		production.update(prod);
		m.addAttribute("cartItems",productcart1.add(cart1));	
		m.addAttribute("cartItem",cart1);
		
		List<Cart> listCartItems=productcart1.listCartItems(username);
		m.addAttribute("cartitems",listCartItems);
		m.addAttribute("grandTotal",this.calcGrandTotalPrice(listCartItems));
		m.addAttribute("userClickAddCart", true);
		return "Cart1";
	}
	
	@RequestMapping(value="/UpdateCart/{cartid}/update")
	public String UpdateCart(@PathVariable("cartid")int cartid,@RequestParam("quantity")int quantity,Model m, String username,HttpSession session)
	{
		username=(String)session.getAttribute("username");
		Cart cart1=productcart1.getCartItem(cartid);
		cart1.setQuantity(quantity);
		productcart1.update(cart1);
		List<Cart> listcartitems=productcart1.listCartItems(username);
		m.addAttribute("cartit", productcart1.listCartItems(username));
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(listcartitems));
		m.addAttribute("cart1", cart1);
		
		List<Cart> cartitemlist=productcart1.listCartItems(username);
		m.addAttribute("cartitems", cartitemlist);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(cartitemlist));
		return "Cart1";
	}
	
	@RequestMapping(value="/DeleteCart/{cartid}/delete")
	public String DeleteCart(@PathVariable("cartid")int cartid,Model m, String username,HttpSession session)
	{
		 username=(String)session.getAttribute("username");
		Cart cart1=productcart1.getCartItem(cartid);
		
		productcart1.delete(cart1);
			
		List<Cart> cartitemlist=productcart1.listCartItems(username);
		m.addAttribute("cartitems", cartitemlist);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(cartitemlist));
		return "Cart1";
	}
	
	@RequestMapping(value="/checkout")
	public String checkout(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartitemlist=productcart1.listCartItems(username);
		m.addAttribute("cartitems", cartitemlist);
		m.addAttribute("grandTotal", this.calcGrandTotalPrice(cartitemlist));
		
		return "order";
	}
}
