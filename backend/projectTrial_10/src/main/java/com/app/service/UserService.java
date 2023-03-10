package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.LoginRequestDto;
import com.app.dto.UserDto;
import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.pojos.User;


public interface UserService {

	List<User> getAllUsers();

	User authenticateAdmin(LoginRequestDto dto);
	User authenticateCustomer(LoginRequestDto dto);

	List<Category> getAllCategories();

	List<Product> getAllProducts(Long catId);

	//Product addHospital(Long categoryId, Product addHospital);

	User saveUserDetails(User user);

	String deleteCustomer(Long custId);
	
}
