package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the subject_pl database table.
 * 
 */
@Entity
@Table(name="subject_pl")
@NamedQuery(name="SubjectPl.findAll", query="SELECT s FROM SubjectPl s")
public class SubjectPl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="subject_pl_id")
	private int subjectPlId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="subject_pl_desc")
	private String subjectPlDesc;

	@Column(name="subject_pl_name")
	private String subjectPlName;

	//bi-directional many-to-one association to AllTeacherSubject
	@OneToMany(mappedBy="subjectPl")
	private List<AllTeacherSubject> allTeacherSubjects;

	public SubjectPl() {
	}

	public int getSubjectPlId() {
		return this.subjectPlId;
	}

	public void setSubjectPlId(int subjectPlId) {
		this.subjectPlId = subjectPlId;
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

	public String getSubjectPlDesc() {
		return this.subjectPlDesc;
	}

	public void setSubjectPlDesc(String subjectPlDesc) {
		this.subjectPlDesc = subjectPlDesc;
	}

	public String getSubjectPlName() {
		return this.subjectPlName;
	}

	public void setSubjectPlName(String subjectPlName) {
		this.subjectPlName = subjectPlName;
	}

	public List<AllTeacherSubject> getAllTeacherSubjects() {
		return this.allTeacherSubjects;
	}

	public void setAllTeacherSubjects(List<AllTeacherSubject> allTeacherSubjects) {
		this.allTeacherSubjects = allTeacherSubjects;
	}

	public AllTeacherSubject addAllTeacherSubject(AllTeacherSubject allTeacherSubject) {
		getAllTeacherSubjects().add(allTeacherSubject);
		allTeacherSubject.setSubjectPl(this);

		return allTeacherSubject;
	}

	public AllTeacherSubject removeAllTeacherSubject(AllTeacherSubject allTeacherSubject) {
		getAllTeacherSubjects().remove(allTeacherSubject);
		allTeacherSubject.setSubjectPl(null);

		return allTeacherSubject;
	}

}