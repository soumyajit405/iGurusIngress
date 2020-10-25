package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_communication database table.
 * 
 */
@Entity
@Table(name="user_communication")
@NamedQuery(name="UserCommunication.findAll", query="SELECT u FROM UserCommunication u")
public class UserCommunication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int balance;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="is_free")
	private String isFree;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private AllUser allUser;

	//bi-directional many-to-one association to CommunicationTypePl
	@ManyToOne
	@JoinColumn(name="communication_type_pl_id")
	private CommunicationTypePl communicationTypePl;

	public UserCommunication() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
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

	public String getIsFree() {
		return this.isFree;
	}

	public void setIsFree(String isFree) {
		this.isFree = isFree;
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

	public CommunicationTypePl getCommunicationTypePl() {
		return this.communicationTypePl;
	}

	public void setCommunicationTypePl(CommunicationTypePl communicationTypePl) {
		this.communicationTypePl = communicationTypePl;
	}

}