package com.iscl.app.feature.common;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iscl.app.dto.RestResponse;

@Service("DefaultCommonService")
public class DefaultCommonService implements CommonService{

	@Autowired
	private  CommonComponent commonComponent;
	
	@Override
	public RestResponse getUserRolesPl() {
		return commonComponent.getUserRolesPl();
		
	}

	@Override
	public RestResponse healthCheck() {
		RestResponse response = new RestResponse();
		response.setResponse("Ingress Service Running");
		return response;
		
	}
	

}
