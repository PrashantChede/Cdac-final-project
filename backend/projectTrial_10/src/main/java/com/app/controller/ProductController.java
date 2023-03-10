package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HospitalDto;
import com.app.dto.ProductDtoToUpdate;
import com.app.pojos.Product;
import com.app.service.ProductService;

@RestController
//To enable CORS header 
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService hospService;

	@Autowired
	private ModelMapper mapper;

	@PostMapping("/addProduct/{categoryId}")
	public Product addHospital(@PathVariable Long categoryId, @RequestBody HospitalDto newHospital) {
		Product newProduct = mapper.map(newHospital, Product.class);

		return hospService.addHospital(categoryId, newProduct);
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteHospital(@PathVariable Long productId) {
		return hospService.deleteHospital(productId);
	}

	@GetMapping("/getAllProducts/{catId}")
	public List<Product> getAllProducts(@PathVariable Long catId) {
		return hospService.getAllProducts(catId);
	}

	@PutMapping("/updateHospital")
	public Product updateProduct(@RequestBody ProductDtoToUpdate detachedProduct) {

		return hospService.updateProduct(detachedProduct);
	}

}
