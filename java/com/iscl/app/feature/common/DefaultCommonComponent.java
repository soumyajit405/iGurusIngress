package com.iscl.app.feature.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iscl.app.dto.ErrorResponse;
import com.iscl.app.dto.RestResponse;
import com.iscl.app.util.CustomMessages;

@Service("DefaultCommonComponent")
public class DefaultCommonComponent implements CommonComponent {

	@Autowired
	private UserRolesRepository userrolerepository;


	
	@Override
	public RestResponse getUserRolesPl() {
		RestResponse response = new RestResponse();
		List<UserRolesPlDto> listOfRolesDto = new ArrayList<>();
        DozerBeanMapper dozenBeanMapper = new DozerBeanMapper();
		try {
			List<UserRolesPl> listOfRoles = userrolerepository.findAll();
			for (UserRolesPl userRolePl: listOfRoles) {
				listOfRolesDto.add(dozenBeanMapper.map(userRolePl, UserRolesPlDto.class));
			}
			response.setResponse(listOfRolesDto);

		} 	catch (Exception e) {
			e.printStackTrace();
			ErrorResponse errorResponse = new ErrorResponse(CustomMessages.getCustomMessages("ISE"), 500);
			response.setResponse(errorResponse);
		}
		return response;
	}

}
