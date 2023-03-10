package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CartItemDto;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;
import com.app.pojos.Product;
import com.app.pojos.User;
import com.app.repository.CartItemsRepository;
import com.app.repository.ProductRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemsRepository cartItemRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductService productService;

//	@Override
//	public String addCartItem(CartItemDto newCartItem) {
//		// TODO Auto-generated method stub
//		System.out.println("inside cartimplementation !!");
//		User user = userRepo.findById(newCartItem.getUserId()).get();
//		// System.out.println(user);
//
//		List<Product> productList = productService.getAllProducts(newCartItem.getCatId());
//		Product productToAdd = new Product();
//
//		for (Product p : productList) {
//			if (p.getId() == 4) {
//				productToAdd = p;
//				// System.out.println(productToAdd);
//			}
//		}
//		System.out.println("before cartItem");
//		CartItem cartItem = new CartItem();
//		cartItem.setCartProduct(productToAdd);
//		System.out.println(cartItem.getCartProduct());
//		System.out.println("after cartItem");
//
//		if (user.getCart() == null) {
//			Cart cart = new Cart();
//			cart.addCartItem(cartItem);
//			user.addCart(cart);
//			int totalItems = user.getCart().getTotalItems();
//			user.getCart().setTotalItems(totalItems);
//		} else {
//			user.getCart().addCartItem(cartItem);
//		//	user.addCart(user.getCart());
//			int totalItems = user.getCart().getTotalItems();
//			user.getCart().setTotalItems(totalItems + 1);
//		}
//
//		return "hospital booked successfully !!";
//	}

	
	
	
	
	
	
	
	
	
	@Override
	public String addCartItem(CartItemDto newCartItem) {
		// TODO Auto-generated method stub
		System.out.println("inside cartimplementation !!");
		User user = userRepo.findById(newCartItem.getUserId()).get();
		// System.out.println(user);

		List<Product> productList = productService.getAllProducts(newCartItem.getCatId());
		Product productToAdd = new Product();
		
		//find the nearest product available
		
		int distance[]=null;
		List<Integer> distanceList=new ArrayList<>();
		
//		for(Product p:productList)
//		{
//      }	
		for(int i=0;i<productList.size();i++)
		{
			 double latDistance = Math.toRadians(Double.parseDouble(newCartItem.getLatitude()) - Double.parseDouble(productList.get(i).getLatitude()));
			 double lngDistance = Math.toRadians(Double.parseDouble(newCartItem.getLongitude()) - Double.parseDouble(productList.get(i).getLongitude()));
			
			 double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				      + Math.cos(Math.toRadians(Double.parseDouble(newCartItem.getLatitude()))) * Math.cos(Math.toRadians(Double.parseDouble(productList.get(i).getLatitude())))
				      * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

				    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
				   // distance[i]= (int) (Math.round(6371 * c));
				    distanceList.add( (int) (Math.round(6371 * c)));
				    System.out.println("distance......"+(int) (Math.round(6371 * c)));
				    
				    //				    productId[i]=productList.get(i).getId();
//				    productToAdd.Add(productList.get(i));			    
		}	
		
//		int min=distance[0];
//		int index=0;
//		for(int i=0;i<distance.length;i++)
//		{
//			if(distance[i]>distance[i+1])
//			{
//				index++;
//				min=distance[i+1];
//			}
//		}
		
		
		int min=distanceList.get(0);
		int index=0;
		for(int i=0;i<distanceList.size()-1;i++)
		{
			if(distanceList.get(i)>distanceList.get(i+1))
			{
				index++;
				min=distanceList.get(i+1);
			}
		}
		
		
		productToAdd=productList.get(index);
		
		System.out.println("selected hospital "+productToAdd);
		
		
		
		
//		for (Product p : productList) {
//			if (p.getId() == 4) {
//				productToAdd = p;
//				// System.out.println(productToAdd);
//			}
//		}
		System.out.println("before cartItem");
		CartItem cartItem = new CartItem();
		cartItem.setCartProduct(productToAdd);
		System.out.println(cartItem.getCartProduct());
		System.out.println("after cartItem");

		if (user.getCart() == null){
			Cart cart = new Cart();
			cart.addCartItem(cartItem);
			user.addCart(cart);
			int totalItems = user.getCart().getTotalItems();
			user.getCart().setTotalItems(totalItems);
		}else{
			user.getCart().addCartItem(cartItem);
		//	user.addCart(user.getCart());
			int totalItems = user.getCart().getTotalItems();
			user.getCart().setTotalItems(totalItems + 1);
		}

		return productToAdd.getProductName()+"hospital booked successfully !!";
	}

	
	
	
	
	
	
	
	
	
	
}
