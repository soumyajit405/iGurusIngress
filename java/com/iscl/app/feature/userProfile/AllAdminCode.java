package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the all_admin_code database table.
 * 
 */
@Entity
@Table(name="all_admin_code")
@NamedQuery(name="AllAdminCode.findAll", query="SELECT a FROM AllAdminCode a")
public class AllAdminCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="all_admin_code_id")
	private int allAdminCodeId;

	@Column(name="active_status")
	private String activeStatus;

	private String code;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="all_users_id")
	private AllUser allUser;

	//bi-directional many-to-one association to CodeTypePl
	@ManyToOne
	@JoinColumn(name="code_type_id")
	private CodeTypePl codeTypePl;

	//bi-directional many-to-one association to AllStudentProfile
	@OneToMany(mappedBy="allAdminCode")
	private List<AllStudentProfile> allStudentProfiles;

	public AllAdminCode() {
	}

	public int getAllAdminCodeId() {
		return this.allAdminCodeId;
	}

	public void setAllAdminCodeId(int allAdminCodeId) {
		this.allAdminCodeId = allAdminCodeId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public AllUser getAllUser() {
		return this.allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
	}

	public CodeTypePl getCodeTypePl() {
		return this.codeTypePl;
	}

	public void setCodeTypePl(CodeTypePl codeTypePl) {
		this.codeTypePl = codeTypePl;
	}

	public List<AllStudentProfile> getAllStudentProfiles() {
		return this.allStudentProfiles;
	}

	public void setAllStudentProfiles(List<AllStudentProfile> allStudentProfiles) {
		this.allStudentProfiles = allStudentProfiles;
	}

	public AllStudentProfile addAllStudentProfile(AllStudentProfile allStudentProfile) {
		getAllStudentProfiles().add(allStudentProfile);
		allStudentProfile.setAllAdminCode(this);

		return allStudentProfile;
	}

	public AllStudentProfile removeAllStudentProfile(AllStudentProfile allStudentProfile) {
		getAllStudentProfiles().remove(allStudentProfile);
		allStudentProfile.setAllAdminCode(null);

		return allStudentProfile;
	}

}