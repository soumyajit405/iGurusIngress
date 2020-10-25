package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the all_teacher_profile database table.
 * 
 */
@Entity
@Table(name="all_teacher_profile")
@NamedQuery(name="AllTeacherProfile.findAll", query="SELECT a FROM AllTeacherProfile a")
public class AllTeacherProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="teacher_profile_id")
	private int teacherProfileId;

	@Column(name="active_status")
	private String activeStatus;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="teacher_name")
	private String teacherName;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="all_users_id")
	private AllUser allUser1;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="school_id")
	private AllUser allUser2;

	public AllTeacherProfile() {
	}

	public int getTeacherProfileId() {
		return this.teacherProfileId;
	}

	public void setTeacherProfileId(int teacherProfileId) {
		this.teacherProfileId = teacherProfileId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
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

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public AllUser getAllUser1() {
		return this.allUser1;
	}

	public void setAllUser1(AllUser allUser1) {
		this.allUser1 = allUser1;
	}

	public AllUser getAllUser2() {
		return this.allUser2;
	}

	public void setAllUser2(AllUser allUser2) {
		this.allUser2 = allUser2;
	}

}