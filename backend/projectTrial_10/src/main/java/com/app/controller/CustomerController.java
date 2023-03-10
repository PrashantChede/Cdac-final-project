package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CartItemDto;
import com.app.dto.CustomerDto;
import com.app.dto.ForgotPasswordDto;
import com.app.dto.LoginRequestDto;
import com.app.pojos.AadharCard;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.CartItemService;
import com.app.service.CustomerService;

@RestController
//To enable CORS header 
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custService;

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private JavaMailSender sender;

	@Autowired
	private CartItemService cartItemService;

	// authentication for customer
	@PostMapping("/signin")
	public User validateCustomer(@RequestBody LoginRequestDto dto) {
		System.out.println("in emp signin " + dto);
		return custService.authenticateCustomer(dto);
	}

//	@PostMapping("/saveCustomerdetails")
//	public User saveUserDetails(@RequestBody UserDto userDto) {
//		System.out.println("checking wheter details send from FE ok or NOK --"+userDto.getMobNo()+"  "+userDto.getAadharCardDto());
//		User user = mapper.map(userDto, User.class);
//		//System.out.println("in save User " + user);// id : null...
//		String destEmail = user.getEmail();
//		String password = user.getPassword();
//		String username = user.getFirstName();
//		System.out.println("-----------sending mail-----------");
//		System.out.println(" Email " + destEmail);
//		SimpleMailMessage mesg = new SimpleMailMessage();
//		mesg.setTo(destEmail);
//		mesg.setSubject("Highway Help Project");
//		System.out.println("before password is " + password);
//		mesg.setText("Oyy " + username
//				+ " you have been successfully Registered on Highway Help Platform !!!!! \n Your password is " + " :"
//				+ password + "\nDiscover the best services \nHave a Good Day!!!!!");
//		System.out.println("after password is " + password);
//		sender.send(mesg);
//		return custService.saveUserDetails(user);
//	}
	
	
	
	@PostMapping("/saveCustomerdetails")
	public User saveUserDetails(@RequestBody CustomerDto customerDto) {
		//System.out.println("checking wheter details send from FE ok or NOK --"+userDto.getMobNo()+"  "+userDto.getAadharCardDto());
	//	User user = mapper.map(userDto, User.class);
		//System.out.println("in save User " + user);// id : null...
		
		User user=new User();
		user.setFirstName(customerDto.getFirstName());
		user.setLastName(customerDto.getLastName());
		user.setEmail(customerDto.getEmail());
		user.setMobNo(customerDto.getMobNo());
		user.setPassword(customerDto.getPassword());
		user.setUserRole(Role.CUSTOMER);
		
		AadharCard adCard=new AadharCard(customerDto.getCardNumber(),customerDto.getLocation(),customerDto.getDob());
//		user.getAadharCard().setCardNumber(customerDto.getCardNumber());
//		user.getAadharCard().setLocation(customerDto.getLocation());
//		user.getAadharCard().setDob(customerDto.getDob());
		user.addAdharCard(adCard);
		
		
		
		String destEmail = user.getEmail();
		String password = user.getPassword();
		String username = user.getFirstName();
		System.out.println("-----------sending mail-----------");
		System.out.println(" Email " + destEmail);
		SimpleMailMessage mesg = new SimpleMailMessage();
		mesg.setTo(destEmail);
		mesg.setSubject("Highway Help Project");
		System.out.println("before password is " + password);
		mesg.setText("Oyy " + username
				+ " you have been successfully Registered on Highway Help Platform !!!!! \n Your password is " + " :"
				+ password + "\nDiscover the best services \nHave a Good Day!!!!!");
		System.out.println("after password is " + password);
		sender.send(mesg);
		return custService.saveUserDetails(user);
	}

	
	
	

	@PostMapping("/addCartItem")
	public String addCartItem(@RequestBody CartItemDto newCartItem) {
		System.out.println("inside customer controller !!");
		return cartItemService.addCartItem(newCartItem);
	}

	// if forgot password

	@PostMapping("/forgetPassword")
	public ResponseEntity<?> forgetUserPassword(@RequestBody ForgotPasswordDto dto) {

		try {
			System.out.println(dto);
			User validateuser = custService.forgetPassword(dto);
			System.out.println(validateuser);

			String destEmail = validateuser.getEmail();
			String password = validateuser.getPassword();
			String username = validateuser.getFirstName();
			System.out.println("-----------sending mail-----------");
			System.out.println(" Email " + destEmail);
			SimpleMailMessage mesg = new SimpleMailMessage();
			mesg.setTo(destEmail);
			mesg.setSubject("HighwayHelp Forget password");
			mesg.setText("Hi " + username + " Your password is " + ": " + password
					+ "\nPlease Try again For Login!!!!!!!!!!");
			sender.send(mesg);

			return new ResponseEntity<>(validateuser, HttpStatus.OK);
		} catch (Exception e) {
			ResourceNotFoundException resp = new ResourceNotFoundException("Enter Valid Email id");
			return new ResponseEntity<>(resp, HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/{custId}")
	public User getCustomer(@PathVariable Long custId)
	{
		return custService.getCustomer(custId);
	}

}
