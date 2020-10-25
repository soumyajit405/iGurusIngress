package com.iscl.app.feature.signup;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.iscl.app.dto.RestResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
public interface SignupService 
{
    
    @RequestMapping(value ="registerUser" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public RestResponse registerUser(@RequestBody HashMap<String,String> inputDetails);
    
    @RequestMapping(value ="verifyMobile/{mobileNumber}" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public RestResponse verifyMobile(@PathVariable("mobileNumber") String mobileNumber);
    
    @RequestMapping(value ="verifyOtp" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public RestResponse verifyOtp(@RequestBody HashMap<String,Object> authenticationDetails);
    
    
    @RequestMapping(value ="resendOtp/{mobileNumber}" , method =  RequestMethod.PUT , headers =  "Accept=application/json" )
    public RestResponse resendOtp(@PathVariable("mobileNumber") String mobileNumber);
        
}
