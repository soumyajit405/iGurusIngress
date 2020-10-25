package com.iscl.app.feature.teacher;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iscl.app.dto.ErrorResponse;
import com.iscl.app.dto.RestResponse;
import com.iscl.app.feature.common.UserRolesPl;
import com.iscl.app.feature.common.UserRolesRepository;
import com.iscl.app.feature.userProfile.AllOtp;
import com.iscl.app.feature.userProfile.AllOtpRepository;
import com.iscl.app.feature.userProfile.AllTeacherProfile;
import com.iscl.app.feature.userProfile.AllUser;
import com.iscl.app.feature.userProfile.AllUserRepository;
import com.iscl.app.util.CustomMessages;

@Service("DefaultTeacherProfileService")
public class DefaultTeacherProfileService implements TeacherService{

	@Autowired
	TeacherComponent teachercomponent;
	
	@Override
	public RestResponse updateTeacherProfile(AllTeacherProfile teacherProfile) {
		
		return teachercomponent.updateTeacherProfile(teacherProfile);
	}

	@Override
	public RestResponse getTeacherProfile(int allUserId) {
	
		return teachercomponent.getTeacherProfile(allUserId);
	}
	
}
