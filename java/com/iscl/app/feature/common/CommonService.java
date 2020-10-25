package com.iscl.app.feature.common;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.iscl.app.dto.RestResponse;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public interface CommonService 
{
    
    @RequestMapping(value ="getUserRolesPl" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public  RestResponse getUserRolesPl();
    
	@RequestMapping(value = "health", method = RequestMethod.GET, headers = "Accept=application/json")
	public  RestResponse healthCheck();
        
}
