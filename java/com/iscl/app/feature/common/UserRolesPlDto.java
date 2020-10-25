package com.iscl.app.feature.common;


import java.io.Serializable;
import javax.persistence.*;

import com.iscl.app.feature.userProfile.AllUser;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
public class UserRolesPlDto  {

	private int userRoleId;

	private String userRoleDesc;

	private String userRoleName;

	
}