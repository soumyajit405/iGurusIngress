package com.iscl.app.feature.login;

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

@Service("DefaultLginService")
public class DefaultLoginService implements LoginService{

	@Autowired
	LoginComponent logincomponent;
	
		
	@Override
	public RestResponse loginUser(HashMap<String,String> inputDetails) {
	
		return logincomponent.loginUser(inputDetails);
	}
	

}
