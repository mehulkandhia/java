package org.hibernate.fraction.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.cartdao;
import com.dao.orderdao;
import com.dao.productdao;
import com.dao.userdao;
import com.model.Cart;
import com.model.OrderDetail;
import com.model.UserDetails;
import com.model.product;

@Controller
public class OrderController {

	@Autowired
	orderdao order2;
	
	@Autowired
	cartdao cart;
	
	@Autowired
	userdao user1;
	
	@Autowired
	productdao production;
	
	@RequestMapping(value="/payment")
	public String paymentprocess(@RequestParam("pmode")String pmode,HttpSession session,Model m)
	{
		//Cart cart1=new Cart();
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCart=cart.listCartItems(username);
		
		OrderDetail orderdetail=new OrderDetail();
		orderdetail.setUsername(username);
		orderdetail.setOrderDate(new Date());
		orderdetail.setPmode(pmode);
		orderdetail.setTotalShippingAmount(this.calcGrandTotalPrice(listCart));
		
		if(order2.UpdateCartItemStatus(username))
		{
			order2.PaymentProcess(orderdetail);
			m.addAttribute("cartitems", listCart);
			m.addAttribute("paymentDetail", orderdetail);
			UserDetails user=user1.getuser(username);
			m.addAttribute("user", user);
		}
		
		return "Receipt";
	}
	
	@RequestMapping(value="/confirm")
	public String confirm()
	{
		/*Cart cart1=new Cart();
		product prod=production.getproduct(productid);
		System.out.println("ProductId :"+prod.getProductid()+"Quantity of product :"+prod.getStock()+"Quantity in cart :"+cart1.getQuantity());

		int i=prod.getStock()-cart1.getQuantity();
		
		System.out.println("Product Quantity Updated :"+i);
		
		prod.setStock(i);
		production.update(prod);*/
		return "Confirm";
	}
	
	@RequestMapping(value="/orderdetail")
	public String orderdetail(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		List<OrderDetail> ListOrder=order2.OrderList();
		m.addAttribute("orderList", ListOrder);
		UserDetails user=user1.getuser(username);
		m.addAttribute("user", user);
		return "orderdetails";
	}
	
	private int calcGrandTotalPrice(List<Cart> listCart) {
		int grandTotal=0;
		int count=0;
		while(count<listCart.size())
		{
			Cart cart=listCart.get(count);
			grandTotal=grandTotal+(cart.getQuantity()*cart.getPrice());
			count++;
		}
		return grandTotal;
		}
	}
