package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ForgotPasswordDto;
import com.app.dto.LoginRequestDto;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.repository.CategoryRepository;
import com.app.repository.ProductRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CategoryRepository catRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired(required = false)
	private ModelMapper mapper;

	

	

	@Override
	public User authenticateCustomer(LoginRequestDto dto) {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
		if (user.getUserRole() == Role.CUSTOMER) {
			return user;
		} else {
			// return null;
			throw new ResourceNotFoundException("not a customer");
		}
	}


	@Override
	public User saveUserDetails(User user) {
		
		System.out.println("value of cart is while registering"+user.getCart());
		return userRepo.save(user);
	}
	
	 @Override
	    public User forgetPassword(ForgotPasswordDto dto) {
	        // TODO Auto-generated method stub
	    	//return userRepo.findByMobileNo(user.getMobileNo());
	    	
	    	return userRepo.findByEmail(dto.getEmail());
	    }


	@Override
	public User getCustomer(Long custId) {
		// TODO Auto-generated method stub
		return userRepo.findById(custId).get();
	}

	

}
