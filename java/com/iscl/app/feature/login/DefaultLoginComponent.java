package com.iscl.app.feature.login;

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
@Service("DefaultLoginComponent")
public class DefaultLoginComponent implements LoginComponent{

	
	@Autowired
	AllUserRepository alluserrepository;
	
	@Autowired
	AllOtpRepository allOtprepository;

	@Override
	public RestResponse loginUser(HashMap<String, String> inputDetails) {
		// TODO Auto-generated method stub
		RestResponse response = new RestResponse();
		try {
			
			AllUser user = alluserrepository.findUserByPhone(inputDetails.get("mobileNumber"));
			if (user != null) {
				int count = allOtprepository.verifyOtp(user.getAllUsersId(), inputDetails.get("otp"));
				if (count == 0) {
					HashMap<String, Object> validationMessage = new HashMap<String, Object>();
					validationMessage.put("message", CustomMessages.getCustomMessages("OTF"));
					validationMessage.put("key", 200);
					response.setResponse(validationMessage);
				} else {
					HashMap<String, Object> validationMessage = new HashMap<String, Object>();
					validationMessage.put("message", CustomMessages.getCustomMessages("OTS"));
					validationMessage.put("key", 200);
					response.setResponse(validationMessage);
				}	
			} else {
				HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("UNE"));
				validationMessage.put("key", 200);
				//validationMessage.put("userId", user.getAllUsersId());
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
