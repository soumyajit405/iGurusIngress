package com.iscl.app.feature.signup;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.iscl.app.dto.RestResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

public interface SignupComponent 
{
    
    public RestResponse registerUser(HashMap<String,String> inputDetails);
    
    public RestResponse verifyMobile(String mobileNumber);
    
    public RestResponse verifyOtp(String mobileNumber, String otp, int userRoleId);
    
    public RestResponse resendOtp(String mobileNumber);
        
}
