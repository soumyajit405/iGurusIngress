package com.iscl.app.feature.signup;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iscl.app.dto.ErrorResponse;
import com.iscl.app.dto.RestResponse;
import com.iscl.app.feature.common.UserRolesPl;
import com.iscl.app.feature.common.UserRolesRepository;
import com.iscl.app.feature.userProfile.AllOtp;
import com.iscl.app.feature.userProfile.AllOtpRepository;
import com.iscl.app.feature.userProfile.AllUser;
import com.iscl.app.feature.userProfile.AllUserRepository;
import com.iscl.app.util.CustomMessages;

@Service("DefaultSignupService")
public class DefaultSignupService implements SignupService{

	@Autowired
	SignupComponent signupcomponent;
	
	@Override
	public RestResponse registerUser(HashMap<String, String> inputDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResponse verifyMobile(String mobileNumber) {
	
		return signupcomponent.verifyMobile(mobileNumber);
	}
	
	
	@Override
	public RestResponse verifyOtp(HashMap<String,Object> authenticationDetails) {
	
		return signupcomponent.verifyOtp((String)authenticationDetails.get("mobileNumber"), (String)authenticationDetails.get("otp"), (int)authenticationDetails.get("userRole"));
	}
	
	@Override
	public RestResponse resendOtp(String mobileNumber) {
	
		return signupcomponent.resendOtp(mobileNumber);
	}
	

}
