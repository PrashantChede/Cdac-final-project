package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.LoginRequestDto;
import com.app.dto.ProductDtoToUpdate;
import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.pojos.User;


public interface ProductService {

	
	List<Product> getAllProducts(Long catId);

	Product addHospital(Long categoryId, Product addHospital);

	String deleteHospital(Long productId);

	 Product updateProduct(ProductDtoToUpdate detachedProduct);
	
}
