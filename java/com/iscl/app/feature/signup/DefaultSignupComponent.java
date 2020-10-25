package com.iscl.app.feature.signup;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iscl.app.dto.ErrorResponse;
import com.iscl.app.dto.RestResponse;
import com.iscl.app.feature.common.UserRolesRepository;
import com.iscl.app.feature.userProfile.AllOtp;
import com.iscl.app.feature.userProfile.AllOtpRepository;
import com.iscl.app.feature.userProfile.AllUser;
import com.iscl.app.feature.userProfile.AllUserRepository;
import com.iscl.app.util.CustomMessages;

@Transactional
@Repository
@Service("DefaultSignupComponent")
public class DefaultSignupComponent implements SignupComponent{

	
	@Autowired
	AllUserRepository alluserrepository;
	
	@Autowired
	AllOtpRepository allOtprepository;
	
	@Autowired
	UserRolesRepository userRoleRepository;
	

	@Override
	public RestResponse registerUser(HashMap<String, String> inputDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResponse verifyMobile(String mobileNumber) {
		// TODO Auto-generated method stub
		RestResponse response = new RestResponse();
		try {
			
			AllUser user = alluserrepository.findUserByPhone(mobileNumber);
			int count = alluserrepository.findUserCount()+1;
			if (user !=null) {
				HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("USE"));
				validationMessage.put("key", 200);
				validationMessage.put("userId", user.getAllUsersId());
				response.setResponse(validationMessage);
			} else {
				AllUser newUser = new AllUser();
				newUser.setPhone(mobileNumber);
				newUser.setAllUsersId(count);
				alluserrepository.saveAndFlush(newUser);
				AllOtp allOtp = new AllOtp();
				allOtp.setAllUser(newUser);
				allOtp.setOtp("1111"); // hardcoded 
				allOtprepository.saveAndFlush(allOtp);
				HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("UNE"));
				validationMessage.put("key", 200);
				validationMessage.put("userId", newUser.getAllUsersId());
				response.setResponse(validationMessage);
			}
		} catch( Exception e) {
			e.printStackTrace();
			ErrorResponse errorResponse = new ErrorResponse(CustomMessages.getCustomMessages("ISE"), 500);
			response.setResponse(errorResponse);
		}
		return response;

	}

	@Override
	public RestResponse verifyOtp(String mobileNumber, String otp, int userRole) {
		// TODO Auto-generated method stub
		RestResponse response = new RestResponse();
		try {
			
			AllUser user = alluserrepository.findUserByPhone(mobileNumber);
			int count = allOtprepository.verifyOtp(user.getAllUsersId(), otp);
			if (count == 0) {
				HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("OTF"));
				validationMessage.put("key", 200);
				response.setResponse(validationMessage);
			} else {
				alluserrepository.updateUserRole(userRole, user.getAllUsersId());
				HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("OTS"));
				validationMessage.put("key", 200);
				response.setResponse(validationMessage);
			}
		} catch( Exception e) {
			e.printStackTrace();
			ErrorResponse errorResponse = new ErrorResponse(CustomMessages.getCustomMessages("ISE"), 500);
			response.setResponse(errorResponse);
		}
		return response;

	}
	
	@Override
	public RestResponse resendOtp(String mobileNumber) {
		// TODO Auto-generated method stub
		RestResponse response = new RestResponse();
		try {
			
			AllUser user = alluserrepository.findUserByPhone(mobileNumber);
			if (user !=null) {
				allOtprepository.updateOtp("1111",user.getAllUsersId());
				HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("SUC"));
				validationMessage.put("key", 200);
				response.setResponse(validationMessage);
			} else {
				HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("UNE"));
				validationMessage.put("key", 200);
				response.setResponse(validationMessage);
		
				
			}
		} catch( Exception e) {
			e.printStackTrace();
			ErrorResponse errorResponse = new ErrorResponse(CustomMessages.getCustomMessages("ISE"), 500);
			response.setResponse(errorResponse);
		}
		return response;

	}

}
