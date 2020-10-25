package com.iscl.app.feature.common;

import java.io.Serializable;
import javax.persistence.*;

import com.iscl.app.feature.userProfile.AllUser;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_roles_pl database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="user_roles_pl")
@NamedQuery(name="UserRolesPl.findAll", query="SELECT u FROM UserRolesPl u")
public class UserRolesPl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_role_id")
	private int userRoleId;

	@Column(name="active_status")
	private String activeStatus;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="soft_delete")
	private String softDelete;

	@Column(name="user_role_desc")
	private String userRoleDesc;

	@Column(name="user_role_name")
	private String userRoleName;

	//bi-directional many-to-one association to AllUser
	@OneToMany(mappedBy="userRolesPl")
	private List<AllUser> allUsers;

	public UserRolesPl() {
	}
	
}