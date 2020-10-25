package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the all_parent_child database table.
 * 
 */
@Entity
@Table(name="all_parent_child")
@NamedQuery(name="AllParentChild.findAll", query="SELECT a FROM AllParentChild a")
public class AllParentChild implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="all_parent_child_id")
	private int allParentChildId;

	@Column(name="child_name")
	private String childName;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="admin_id")
	private AllUser allUser1;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="parent_id")
	private AllUser allUser2;

	//bi-directional many-to-one association to ClassPl
	@ManyToOne
	@JoinColumn(name="class_id")
	private ClassPl classPl;

	public AllParentChild() {
	}

	public int getAllParentChildId() {
		return this.allParentChildId;
	}

	public void setAllParentChildId(int allParentChildId) {
		this.allParentChildId = allParentChildId;
	}

	public String getChildName() {
		return this.childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
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