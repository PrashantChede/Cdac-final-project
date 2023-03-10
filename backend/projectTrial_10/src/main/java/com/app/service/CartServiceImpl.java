package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Cart;
import com.app.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {

  @Autowired
  private CartRepository cartRepo;

//@Override
//public List<Cart> getAllCart(Long userId) {
//	// TODO Auto-generated method stub
//	
//	System.out.println("inside cartService !!");
//	List<Cart> allCarts=cartRepo.findAll();
//	List<Cart> reqCarts=new ArrayList<>();
//	for(Cart c : allCarts)
//	{
//		if(c.getCustomer().getId()==userId)
//		{
//			reqCarts.add(c);
//		}
//	}
//	
//	
//	System.out.println("after for loop");
//	System.out.println(reqCarts);
//	
//	return null;
//}
  
  
  
	
}
