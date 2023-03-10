package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ProductDtoToUpdate;
import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CategoryService catService;

	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Product> getAllProducts(Long catId) {
		// TODO Auto-generated method stub

		// return productRepo.findById(catId);
		List<Product> allProducts = new ArrayList<>();
		allProducts = productRepo.findAll();
		List<Product> reqProducts = new ArrayList<>();
		System.out.println(allProducts);
		System.out.println(reqProducts);
		for (Product p : allProducts) {
			System.out.println(p.getProductCategory());
			if (p.getProductCategory().getId() == catId) {
				reqProducts.add(p);
			}
		}
		System.out.println(reqProducts);
		return reqProducts;
	}

	@Override
	public Product addHospital(Long categoryId, Product addHospital) {
		Category cat = catService.findCategory(categoryId);
//		Category cat11=new Category();
//		cat11.addProduct(addHospital);
		Product newProduct = addHospital;
		newProduct.setProductCategory(cat);
		return productRepo.save(newProduct);

	}

	@Override
	public String deleteHospital(Long productId) {
		// TODO Auto-generated method stub
		String msg = "Deletion of product details failed Invalid Id!!!!!!!!!!!";
		if (productRepo.existsById(productId)) {
			productRepo.deleteById(productId);
			msg = "product deleted successfully !!";
		}
		return msg;
	}

	@Override
	public Product updateProduct(ProductDtoToUpdate detachedProduct) {
		
		Product persistentProduct = productRepo.findById(detachedProduct.getId())
				.orElseThrow(() -> new ResourceNotFoundException("invalid product id !!!!!"));
		persistentProduct.setProductName(detachedProduct.getProductName());
		persistentProduct.setDescription(detachedProduct.getDescription());
		persistentProduct.setLatitude(detachedProduct.getLatitude());
		persistentProduct.setLongitude(detachedProduct.getLongitude());
		persistentProduct.setInStock(detachedProduct.getInStock());
		return persistentProduct;
	}

}
