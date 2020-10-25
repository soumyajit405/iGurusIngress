package com.iscl.app.feature.teacher;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.iscl.app.dto.RestResponse;
import com.iscl.app.feature.userProfile.AllTeacherProfile;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

public interface TeacherComponent 
{
    
	public RestResponse updateTeacherProfile( AllTeacherProfile allteacherProfile);
    
	public RestResponse getTeacherProfile(int allUserId);
    
}
