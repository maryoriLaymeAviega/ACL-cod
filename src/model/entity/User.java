package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable(identityType = IdentityType.APPLICATION)

public class User {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String mail;
	@Persistent
	private long roleId;
	@Persistent
	private boolean status;

	public User(String a, long b) {
		setMail(a);
		setRoleId(b);
		setStatus(true);
	}

	public Long getId() {
		return id;
	}

	public String getMail() {
		return mail;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


}