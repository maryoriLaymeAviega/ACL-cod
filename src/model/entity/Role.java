package model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Role {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long	id;
	@Persistent private String type;
	@Persistent private boolean status = true;
	@Persistent private Date date = new Date();	
	public Long getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public boolean isStatus() {
		return status;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return  dateFormat.format(date);
	}
	public Role(String a, boolean b) {
		setType(a);
		setStatus(b);
	}
}