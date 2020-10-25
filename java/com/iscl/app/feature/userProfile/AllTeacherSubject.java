package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the all_teacher_subject database table.
 * 
 */
@Entity
@Table(name="all_teacher_subject")
@NamedQuery(name="AllTeacherSubject.findAll", query="SELECT a FROM AllTeacherSubject a")
public class AllTeacherSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="all_teacher_subject_id")
	private int allTeacherSubjectId;

	@Column(name="active_status")
	private String activeStatus;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private AllUser allUser;

	//bi-directional many-to-one association to ClassPl
	@ManyToOne
	@JoinColumn(name="class_pl_id")
	private ClassPl classPl;

	//bi-directional many-to-one association to SubjectPl
	@ManyToOne
	@JoinColumn(name="subject_pl_id")
	private SubjectPl subjectPl;

	public AllTeacherSubject() {
	}

	public int getAllTeacherSubjectId() {
		return this.allTeacherSubjectId;
	}

	public void setAllTeacherSubjectId(int allTeacherSubjectId) {
		this.allTeacherSubjectId = allTeacherSubjectId;
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

	public AllUser getAllUser() {
		return this.allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
	}

	public ClassPl getClassPl() {
		return this.classPl;
	}

	public void setClassPl(ClassPl classPl) {
		this.classPl = classPl;
	}

	public SubjectPl getSubjectPl() {
		return this.subjectPl;
	}

	public void setSubjectPl(SubjectPl subjectPl) {
		this.subjectPl = subjectPl;
	}

}