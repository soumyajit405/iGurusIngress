package com.iscl.app.feature.teacher;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.iscl.app.dto.RestResponse;
import com.iscl.app.feature.userProfile.AllTeacherProfile;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
public interface TeacherService 
{
    
    @RequestMapping(value ="updateTeacherProfile" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public RestResponse updateTeacherProfile(@RequestBody AllTeacherProfile allteacherProfile);
    
    @RequestMapping(value ="getTeacherProfile/{alluserId}" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public RestResponse getTeacherProfile(@PathVariable("alluserId") int allUserId);
    
        
}
