package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the all_otp database table.
 * 
 */
@Entity
@Table(name="all_otp")
@NamedQuery(name="AllOtp.findAll", query="SELECT a FROM AllOtp a")
public class AllOtp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="all_otp_id")
	private int allOtpId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	private String otp;

	private String status;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="all_users_id")
	private AllUser allUser;

	public AllOtp() {
	}

	public int getAllOtpId() {
		return this.allOtpId;
	}

	public void setAllOtpId(int allOtpId) {
		this.allOtpId = allOtpId;
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

	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AllUser getAllUser() {
		return this.allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
	}

}