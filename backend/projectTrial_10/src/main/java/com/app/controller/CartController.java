package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Cart;
import com.app.service.CartService;

@RestController
//To enable CORS header 
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
//	@GetMapping("/getAllCart/{userId}")
//	public List<Cart> getAllCart(@PathVariable Long userId)
//	{
//		return cartService.getAllCart(userId);
//	}
	
}
