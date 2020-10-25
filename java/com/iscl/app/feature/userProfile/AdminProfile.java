package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the admin_profile database table.
 * 
 */
@Entity
@Table(name="admin_profile")
@NamedQuery(name="AdminProfile.findAll", query="SELECT a FROM AdminProfile a")
public class AdminProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="admin_profile_id")
	private int adminProfileId;

	private String address;

	@Column(name="admin_name")
	private String adminName;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="emergency_contact")
	private String emergencyContact;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="school_name")
	private String schoolName;

	@Column(name="school_regd_id")
	private String schoolRegdId;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="all_users_id")
	private AllUser allUser;

	public AdminProfile() {
	}

	public int getAdminProfileId() {
		return this.adminProfileId;
	}

	public void setAdminProfileId(int adminProfileId) {
		this.adminProfileId = adminProfileId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmergencyContact() {
		return this.emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolRegdId() {
		return this.schoolRegdId;
	}

	public void setSchoolRegdId(String schoolRegdId) {
		this.schoolRegdId = schoolRegdId;
	}

	public AllUser getAllUser() {
		return this.allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
	}

}