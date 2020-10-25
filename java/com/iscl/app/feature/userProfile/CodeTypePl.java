package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the code_type_pl database table.
 * 
 */
@Entity
@Table(name="code_type_pl")
@NamedQuery(name="CodeTypePl.findAll", query="SELECT c FROM CodeTypePl c")
public class CodeTypePl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="code_type_id")
	private int codeTypeId;

	@Column(name="code_type_desc")
	private String codeTypeDesc;

	@Column(name="code_type_name")
	private String codeTypeName;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	//bi-directional many-to-one association to AllAdminCode
	@OneToMany(mappedBy="codeTypePl")
	private List<AllAdminCode> allAdminCodes;

	public CodeTypePl() {
	}

	public int getCodeTypeId() {
		return this.codeTypeId;
	}

	public void setCodeTypeId(int codeTypeId) {
		this.codeTypeId = codeTypeId;
	}

	public String getCodeTypeDesc() {
		return this.codeTypeDesc;
	}

	public void setCodeTypeDesc(String codeTypeDesc) {
		this.codeTypeDesc = codeTypeDesc;
	}

	public String getCodeTypeName() {
		return this.codeTypeName;
	}

	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
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

	public List<AllAdminCode> getAllAdminCodes() {
		return this.allAdminCodes;
	}

	public void setAllAdminCodes(List<AllAdminCode> allAdminCodes) {
		this.allAdminCodes = allAdminCodes;
	}

	public AllAdminCode addAllAdminCode(AllAdminCode allAdminCode) {
		getAllAdminCodes().add(allAdminCode);
		allAdminCode.setCodeTypePl(this);

		return allAdminCode;
	}

	public AllAdminCode removeAllAdminCode(AllAdminCode allAdminCode) {
		getAllAdminCodes().remove(allAdminCode);
		allAdminCode.setCodeTypePl(null);

		return allAdminCode;
	}

}