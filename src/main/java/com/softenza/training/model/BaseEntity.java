package com.softenza.training.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BaseEntity {


	@Column(name = "CREATE_DATE")
	private Date createDate = new Date();
	
	@Column(name = "MOD_DATE")
	private Date modDate = new Date();

	@Column(name = "MOD_BY")
	private Long modifiedBy;
	
	@Transient
	private String error;

	public abstract Long getId() ;

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "BaseEntity [createDate=" + createDate + ", modDate=" + modDate
				+ ", modifiedBy=" + modifiedBy + "]";
	}

	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
}
