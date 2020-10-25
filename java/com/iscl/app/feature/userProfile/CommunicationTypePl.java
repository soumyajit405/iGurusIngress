package com.iscl.app.feature.userProfile;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the communication_type_pl database table.
 * 
 */
@Entity
@Table(name="communication_type_pl")
@NamedQuery(name="CommunicationTypePl.findAll", query="SELECT c FROM CommunicationTypePl c")
public class CommunicationTypePl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="comm_name")
	private String commName;

	private String descr;

	//bi-directional many-to-one association to UserCommunication
	@OneToMany(mappedBy="communicationTypePl")
	private List<UserCommunication> userCommunications;

	public CommunicationTypePl() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommName() {
		return this.commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public List<UserCommunication> getUserCommunications() {
		return this.userCommunications;
	}

	public void setUserCommunications(List<UserCommunication> userCommunications) {
		this.userCommunications = userCommunications;
	}

	public UserCommunication addUserCommunication(UserCommunication userCommunication) {
		getUserCommunications().add(userCommunication);
		userCommunication.setCommunicationTypePl(this);

		return userCommunication;
	}

	public UserCommunication removeUserCommunication(UserCommunication userCommunication) {
		getUserCommunications().remove(userCommunication);
		userCommunication.setCommunicationTypePl(null);

		return userCommunication;
	}

}