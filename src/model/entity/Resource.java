package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Resource {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long	id;
	@Persistent	private String src;
	@Persistent private boolean status=true;
	public Resource(String a) {
		setSrc(a);				
	}
	public Long getId() {
		return id;
	}
	public String getSrc() {
		return src;
	}
	public boolean isStatus() {
		return status;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}