package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;

import com.iscl.app.feature.common.UserRolesPl;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the all_users database table.
 * 
 */
@Entity
@Table(name="all_users")
@NamedQuery(name="AllUser.findAll", query="SELECT a FROM AllUser a")
public class AllUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="all_users_id")
	private int allUsersId;

	@Column(name="active_status")
	private String activeStatus;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	private String email;

	private String imei;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	private String password;

	private String phone;

	@Column(name="soft_delete")
	private String softDelete;

	//bi-directional many-to-one association to AdminProfile
	@OneToMany(mappedBy="allUser")
	private List<AdminProfile> adminProfiles;

	//bi-directional many-to-one association to AllAdminCode
	@OneToMany(mappedBy="allUser")
	private List<AllAdminCode> allAdminCodes;

	//bi-directional many-to-one association to AllOtp
	@OneToMany(mappedBy="allUser")
	private List<AllOtp> allOtps;

	//bi-directional many-to-one association to AllParentChild
	@OneToMany(mappedBy="allUser1")
	private List<AllParentChild> allParentChilds1;

	//bi-directional many-to-one association to AllParentChild
	@OneToMany(mappedBy="allUser2")
	private List<AllParentChild> allParentChilds2;

	//bi-directional many-to-one association to AllParentProfile
	@OneToMany(mappedBy="allUser")
	private List<AllParentProfile> allParentProfiles;

	//bi-directional many-to-one association to AllStudentProfile
	@OneToMany(mappedBy="allUser1")
	private List<AllStudentProfile> allStudentProfiles1;

	//bi-directional many-to-one association to AllStudentProfile
	@OneToMany(mappedBy="allUser2")
	private List<AllStudentProfile> allStudentProfiles2;

	//bi-directional many-to-one association to AllTeacherProfile
	@OneToMany(mappedBy="allUser1")
	private List<AllTeacherProfile> allTeacherProfiles1;

	//bi-directional many-to-one association to AllTeacherProfile
	@OneToMany(mappedBy="allUser2")
	private List<AllTeacherProfile> allTeacherProfiles2;

	//bi-directional many-to-one association to AllTeacherSubject
	@OneToMany(mappedBy="allUser")
	private List<AllTeacherSubject> allTeacherSubjects;

	//bi-directional many-to-one association to UserRolesPl
	@ManyToOne
	@JoinColumn(name="user_role_id")
	private UserRolesPl userRolesPl;

	//bi-directional many-to-one association to Login
	@OneToMany(mappedBy="allUser")
	private List<Login> logins;

	//bi-directional many-to-one association to UserCommunication
	@OneToMany(mappedBy="allUser")
	private List<UserCommunication> userCommunications;

	//bi-directional many-to-one association to UserRecharge
	@OneToMany(mappedBy="allUser")
	private List<UserRecharge> userRecharges;

	public AllUser() {
	}

	public int getAllUsersId() {
		return this.allUsersId;
	}

	public void setAllUsersId(int allUsersId) {
		this.allUsersId = allUsersId;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSoftDelete() {
		return this.softDelete;
	}

	public void setSoftDelete(String softDelete) {
		this.softDelete = softDelete;
	}

	public List<AdminProfile> getAdminProfiles() {
		return this.adminProfiles;
	}

	public void setAdminProfiles(List<AdminProfile> adminProfiles) {
		this.adminProfiles = adminProfiles;
	}

	public AdminProfile addAdminProfile(AdminProfile adminProfile) {
		getAdminProfiles().add(adminProfile);
		adminProfile.setAllUser(this);

		return adminProfile;
	}

	public AdminProfile removeAdminProfile(AdminProfile adminProfile) {
		getAdminProfiles().remove(adminProfile);
		adminProfile.setAllUser(null);

		return adminProfile;
	}

	public List<AllAdminCode> getAllAdminCodes() {
		return this.allAdminCodes;
	}

	public void setAllAdminCodes(List<AllAdminCode> allAdminCodes) {
		this.allAdminCodes = allAdminCodes;
	}

	public AllAdminCode addAllAdminCode(AllAdminCode allAdminCode) {
		getAllAdminCodes().add(allAdminCode);
		allAdminCode.setAllUser(this);

		return allAdminCode;
	}

	public AllAdminCode removeAllAdminCode(AllAdminCode allAdminCode) {
		getAllAdminCodes().remove(allAdminCode);
		allAdminCode.setAllUser(null);

		return allAdminCode;
	}

	public List<AllOtp> getAllOtps() {
		return this.allOtps;
	}

	public void setAllOtps(List<AllOtp> allOtps) {
		this.allOtps = allOtps;
	}

	public AllOtp addAllOtp(AllOtp allOtp) {
		getAllOtps().add(allOtp);
		allOtp.setAllUser(this);

		return allOtp;
	}

	public AllOtp removeAllOtp(AllOtp allOtp) {
		getAllOtps().remove(allOtp);
		allOtp.setAllUser(null);

		return allOtp;
	}

	public List<AllParentChild> getAllParentChilds1() {
		return this.allParentChilds1;
	}

	public void setAllParentChilds1(List<AllParentChild> allParentChilds1) {
		this.allParentChilds1 = allParentChilds1;
	}

	public AllParentChild addAllParentChilds1(AllParentChild allParentChilds1) {
		getAllParentChilds1().add(allParentChilds1);
		allParentChilds1.setAllUser1(this);

		return allParentChilds1;
	}

	public AllParentChild removeAllParentChilds1(AllParentChild allParentChilds1) {
		getAllParentChilds1().remove(allParentChilds1);
		allParentChilds1.setAllUser1(null);

		return allParentChilds1;
	}

	public List<AllParentChild> getAllParentChilds2() {
		return this.allParentChilds2;
	}

	public void setAllParentChilds2(List<AllParentChild> allParentChilds2) {
		this.allParentChilds2 = allParentChilds2;
	}

	public AllParentChild addAllParentChilds2(AllParentChild allParentChilds2) {
		getAllParentChilds2().add(allParentChilds2);
		allParentChilds2.setAllUser2(this);

		return allParentChilds2;
	}

	public AllParentChild removeAllParentChilds2(AllParentChild allParentChilds2) {
		getAllParentChilds2().remove(allParentChilds2);
		allParentChilds2.setAllUser2(null);

		return allParentChilds2;
	}

	public List<AllParentProfile> getAllParentProfiles() {
		return this.allParentProfiles;
	}

	public void setAllParentProfiles(List<AllParentProfile> allParentProfiles) {
		this.allParentProfiles = allParentProfiles;
	}

	public AllParentProfile addAllParentProfile(AllParentProfile allParentProfile) {
		getAllParentProfiles().add(allParentProfile);
		allParentProfile.setAllUser(this);

		return allParentProfile;
	}

	public AllParentProfile removeAllParentProfile(AllParentProfile allParentProfile) {
		getAllParentProfiles().remove(allParentProfile);
		allParentProfile.setAllUser(null);

		return allParentProfile;
	}

	public List<AllStudentProfile> getAllStudentProfiles1() {
		return this.allStudentProfiles1;
	}

	public void setAllStudentProfiles1(List<AllStudentProfile> allStudentProfiles1) {
		this.allStudentProfiles1 = allStudentProfiles1;
	}

	public AllStudentProfile addAllStudentProfiles1(AllStudentProfile allStudentProfiles1) {
		getAllStudentProfiles1().add(allStudentProfiles1);
		allStudentProfiles1.setAllUser1(this);

		return allStudentProfiles1;
	}

	public AllStudentProfile removeAllStudentProfiles1(AllStudentProfile allStudentProfiles1) {
		getAllStudentProfiles1().remove(allStudentProfiles1);
		allStudentProfiles1.setAllUser1(null);

		return allStudentProfiles1;
	}

	public List<AllStudentProfile> getAllStudentProfiles2() {
		return this.allStudentProfiles2;
	}

	public void setAllStudentProfiles2(List<AllStudentProfile> allStudentProfiles2) {
		this.allStudentProfiles2 = allStudentProfiles2;
	}

	public AllStudentProfile addAllStudentProfiles2(AllStudentProfile allStudentProfiles2) {
		getAllStudentProfiles2().add(allStudentProfiles2);
		allStudentProfiles2.setAllUser2(this);

		return allStudentProfiles2;
	}

	public AllStudentProfile removeAllStudentProfiles2(AllStudentProfile allStudentProfiles2) {
		getAllStudentProfiles2().remove(allStudentProfiles2);
		allStudentProfiles2.setAllUser2(null);

		return allStudentProfiles2;
	}

	public List<AllTeacherProfile> getAllTeacherProfiles1() {
		return this.allTeacherProfiles1;
	}

	public void setAllTeacherProfiles1(List<AllTeacherProfile> allTeacherProfiles1) {
		this.allTeacherProfiles1 = allTeacherProfiles1;
	}

	public AllTeacherProfile addAllTeacherProfiles1(AllTeacherProfile allTeacherProfiles1) {
		getAllTeacherProfiles1().add(allTeacherProfiles1);
		allTeacherProfiles1.setAllUser1(this);

		return allTeacherProfiles1;
	}

	public AllTeacherProfile removeAllTeacherProfiles1(AllTeacherProfile allTeacherProfiles1) {
		getAllTeacherProfiles1().remove(allTeacherProfiles1);
		allTeacherProfiles1.setAllUser1(null);

		return allTeacherProfiles1;
	}

	public List<AllTeacherProfile> getAllTeacherProfiles2() {
		return this.allTeacherProfiles2;
	}

	public void setAllTeacherProfiles2(List<AllTeacherProfile> allTeacherProfiles2) {
		this.allTeacherProfiles2 = allTeacherProfiles2;
	}

	public AllTeacherProfile addAllTeacherProfiles2(AllTeacherProfile allTeacherProfiles2) {
		getAllTeacherProfiles2().add(allTeacherProfiles2);
		allTeacherProfiles2.setAllUser2(this);

		return allTeacherProfiles2;
	}

	public AllTeacherProfile removeAllTeacherProfiles2(AllTeacherProfile allTeacherProfiles2) {
		getAllTeacherProfiles2().remove(allTeacherProfiles2);
		allTeacherProfiles2.setAllUser2(null);

		return allTeacherProfiles2;
	}

	public List<AllTeacherSubject> getAllTeacherSubjects() {
		return this.allTeacherSubjects;
	}

	public void setAllTeacherSubjects(List<AllTeacherSubject> allTeacherSubjects) {
		this.allTeacherSubjects = allTeacherSubjects;
	}

	public AllTeacherSubject addAllTeacherSubject(AllTeacherSubject allTeacherSubject) {
		getAllTeacherSubjects().add(allTeacherSubject);
		allTeacherSubject.setAllUser(this);

		return allTeacherSubject;
	}

	public AllTeacherSubject removeAllTeacherSubject(AllTeacherSubject allTeacherSubject) {
		getAllTeacherSubjects().remove(allTeacherSubject);
		allTeacherSubject.setAllUser(null);

		return allTeacherSubject;
	}

	public UserRolesPl getUserRolesPl() {
		return this.userRolesPl;
	}

	public void setUserRolesPl(UserRolesPl userRolesPl) {
		this.userRolesPl = userRolesPl;
	}

	public List<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Login addLogin(Login login) {
		getLogins().add(login);
		login.setAllUser(this);

		return login;
	}

	public Login removeLogin(Login login) {
		getLogins().remove(login);
		login.setAllUser(null);

		return login;
	}

	public List<UserCommunication> getUserCommunications() {
		return this.userCommunications;
	}

	public void setUserCommunications(List<UserCommunication> userCommunications) {
		this.userCommunications = userCommunications;
	}

	public UserCommunication addUserCommunication(UserCommunication userCommunication) {
		getUserCommunications().add(userCommunication);
		userCommunication.setAllUser(this);

		return userCommunication;
	}

	public UserCommunication removeUserCommunication(UserCommunication userCommunication) {
		getUserCommunications().remove(userCommunication);
		userCommunication.setAllUser(null);

		return userCommunication;
	}

	public List<UserRecharge> getUserRecharges() {
		return this.userRecharges;
	}

	public void setUserRecharges(List<UserRecharge> userRecharges) {
		this.userRecharges = userRecharges;
	}

	public UserRecharge addUserRecharge(UserRecharge userRecharge) {
		getUserRecharges().add(userRecharge);
		userRecharge.setAllUser(this);

		return userRecharge;
	}

	public UserRecharge removeUserRecharge(UserRecharge userRecharge) {
		getUserRecharges().remove(userRecharge);
		userRecharge.setAllUser(null);

		return userRecharge;
	}

}