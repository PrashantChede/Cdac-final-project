package com.app.service;

import com.app.dto.ForgotPasswordDto;
import com.app.dto.LoginRequestDto;
import com.app.pojos.User;

public interface CustomerService {

	User authenticateCustomer(LoginRequestDto dto);

	User saveUserDetails(User user);

	User forgetPassword(ForgotPasswordDto dto);

	User getCustomer(Long custId);

}
