package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the class_pl database table.
 * 
 */
@Entity
@Table(name="class_pl")
@NamedQuery(name="ClassPl.findAll", query="SELECT c FROM ClassPl c")
public class ClassPl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="class_pl_id")
	private int classPlId;

	@Column(name="class_pl_desc")
	private String classPlDesc;

	@Column(name="class_pl_name")
	private String classPlName;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	//bi-directional many-to-one association to AllParentChild
	@OneToMany(mappedBy="classPl")
	private List<AllParentChild> allParentChilds;

	//bi-directional many-to-one association to AllStudentProfile
	@OneToMany(mappedBy="classPl")
	private List<AllStudentProfile> allStudentProfiles;

	//bi-directional many-to-one association to AllTeacherSubject
	@OneToMany(mappedBy="classPl")
	private List<AllTeacherSubject> allTeacherSubjects;

	public ClassPl() {
	}

	public int getClassPlId() {
		return this.classPlId;
	}

	public void setClassPlId(int classPlId) {
		this.classPlId = classPlId;
	}

	public String getClassPlDesc() {
		return this.classPlDesc;
	}

	public void setClassPlDesc(String classPlDesc) {
		this.classPlDesc = classPlDesc;
	}

	public String getClassPlName() {
		return this.classPlName;
	}

	public void setClassPlName(String classPlName) {
		this.classPlName = classPlName;
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

	public List<AllParentChild> getAllParentChilds() {
		return this.allParentChilds;
	}

	public void setAllParentChilds(List<AllParentChild> allParentChilds) {
		this.allParentChilds = allParentChilds;
	}

	public AllParentChild addAllParentChild(AllParentChild allParentChild) {
		getAllParentChilds().add(allParentChild);
		allParentChild.setClassPl(this);

		return allParentChild;
	}

	public AllParentChild removeAllParentChild(AllParentChild allParentChild) {
		getAllParentChilds().remove(allParentChild);
		allParentChild.setClassPl(null);

		return allParentChild;
	}

	public List<AllStudentProfile> getAllStudentProfiles() {
		return this.allStudentProfiles;
	}

	public void setAllStudentProfiles(List<AllStudentProfile> allStudentProfiles) {
		this.allStudentProfiles = allStudentProfiles;
	}

	public AllStudentProfile addAllStudentProfile(AllStudentProfile allStudentProfile) {
		getAllStudentProfiles().add(allStudentProfile);
		allStudentProfile.setClassPl(this);

		return allStudentProfile;
	}

	public AllStudentProfile removeAllStudentProfile(AllStudentProfile allStudentProfile) {
		getAllStudentProfiles().remove(allStudentProfile);
		allStudentProfile.setClassPl(null);

		return allStudentProfile;
	}

	public List<AllTeacherSubject> getAllTeacherSubjects() {
		return this.allTeacherSubjects;
	}

	public void setAllTeacherSubjects(List<AllTeacherSubject> allTeacherSubjects) {
		this.allTeacherSubjects = allTeacherSubjects;
	}

	public AllTeacherSubject addAllTeacherSubject(AllTeacherSubject allTeacherSubject) {
		getAllTeacherSubjects().add(allTeacherSubject);
		allTeacherSubject.setClassPl(this);

		return allTeacherSubject;
	}

	public AllTeacherSubject removeAllTeacherSubject(AllTeacherSubject allTeacherSubject) {
		getAllTeacherSubjects().remove(allTeacherSubject);
		allTeacherSubject.setClassPl(null);

		return allTeacherSubject;
	}

}