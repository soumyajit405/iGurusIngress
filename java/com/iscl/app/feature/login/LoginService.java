package com.iscl.app.feature.login;

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
public interface LoginService 
{
    
    @RequestMapping(value ="loginUser" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public RestResponse loginUser(@RequestBody HashMap<String,String> inputDetails);
        
}
