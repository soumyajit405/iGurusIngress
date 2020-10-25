package com.iscl.app.feature.teacher;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iscl.app.dto.ErrorResponse;
import com.iscl.app.dto.RestResponse;
import com.iscl.app.feature.common.UserRolesRepository;
import com.iscl.app.feature.userProfile.AllAdminCode;
import com.iscl.app.feature.userProfile.AllAdminCodeRepository;
import com.iscl.app.feature.userProfile.AllOtp;
import com.iscl.app.feature.userProfile.AllOtpRepository;
import com.iscl.app.feature.userProfile.AllTeacherProfile;
import com.iscl.app.feature.userProfile.AllUser;
import com.iscl.app.feature.userProfile.AllUserRepository;
import com.iscl.app.util.CustomMessages;

@Transactional
@Repository
@Service("DefaultTeacherComponent")
public class DefaultTeacherComponent implements TeacherComponent{

	
	@Autowired
	TeacherProfileRespository teacherProfilerepository;
	
	@Autowired
	AllAdminCodeRepository adminCodeRepo;
	
	@Autowired
	AllUserRepository alluserRepo;

	@Override
	public RestResponse updateTeacherProfile( AllTeacherProfile allteacherProfile) {

		RestResponse response = new RestResponse();
		try {
			int userId = allteacherProfile.getAllUser1().getAllUsersId();
			AllAdminCode adminCode= adminCodeRepo.findAdminCodeByAdmin(allteacherProfile.getAllUser2().getAllAdminCodes().get(0).getCode());
			if (adminCode == null) {
				 HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("NSA"));
				validationMessage.put("key", 300);
				response.setResponse(validationMessage);
				return response;
			} 
			AllTeacherProfile teacherProfile=teacherProfilerepository.findUserCountById(userId);
			if (teacherProfile != null) {
				alluserRepo.updateUserEmail(allteacherProfile.getAllUser1().getEmail(), userId);
				teacherProfilerepository.updateTeacherProfile(allteacherProfile.getTeacherName(), adminCode.getAllUser().getAllUsersId(),userId);
				
			} else {
				allteacherProfile.setAllUser2(adminCode.getAllUser());
				teacherProfilerepository.save(allteacherProfile);
			}
			 HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("AS"));
				validationMessage.put("key", 200);
				response.setResponse(validationMessage);
				
			
		} catch(Exception e ) {
			e.printStackTrace();
			ErrorResponse errorResponse = new ErrorResponse(CustomMessages.getCustomMessages("ISE"), 500);
			response.setResponse(errorResponse);
		}
		return response;
	}

	@Override
	public RestResponse getTeacherProfile(int allUserId) {
		RestResponse response = new RestResponse();
		try {
			 
			AllTeacherProfile teacherProfile=teacherProfilerepository.findUserCountById(allUserId);
			if (teacherProfile != null) {
				HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("NSU"));
				validationMessage.put("key", 200);
				response.setResponse(validationMessage);
				
			} else {
				
			}
			 	HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("AS"));
				validationMessage.put("key", 200);
				response.setResponse(validationMessage);
				
			
		} catch(Exception e ) {
			e.printStackTrace();
			ErrorResponse errorResponse = new ErrorResponse(CustomMessages.getCustomMessages("ISE"), 500);
			response.setResponse(errorResponse);
		}
		return response;

	}

}
