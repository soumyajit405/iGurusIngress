package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the all_student_profile database table.
 * 
 */
@Entity
@Table(name="all_student_profile")
@NamedQuery(name="AllStudentProfile.findAll", query="SELECT a FROM AllStudentProfile a")
public class AllStudentProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="all_student_profile_id")
	private int allStudentProfileId;

	@Column(name="active_status")
	private String activeStatus;

	@Column(name="student_name")
	private String studentName;

	//bi-directional many-to-one association to AllAdminCode
	@ManyToOne
	@JoinColumn(name="all_admin_code_id")
	private AllAdminCode allAdminCode;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="all_users_id")
	private AllUser allUser1;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="parent_id")
	private AllUser allUser2;

	//bi-directional many-to-one association to ClassPl
	@ManyToOne
	@JoinColumn(name="class_id")
	private ClassPl classPl;

	public AllStudentProfile() {
	}

	public int getAllStudentProfileId() {
		return this.allStudentProfileId;
	}

	public void setAllStudentProfileId(int allStudentProfileId) {
		this.allStudentProfileId = allStudentProfileId;
	}

	public String getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public AllAdminCode getAllAdminCode() {
		return this.allAdminCode;
	}

	public void setAllAdminCode(AllAdminCode allAdminCode) {
		this.allAdminCode = allAdminCode;
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

	public ClassPl getClassPl() {
		return this.classPl;
	}

	public void setClassPl(ClassPl classPl) {
		this.classPl = classPl;
	}

}