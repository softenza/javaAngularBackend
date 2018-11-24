package com.softenza.training.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnTransformer;

public class Configuration extends BaseEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "CONFIGURATION_ID")
	private Long id;


	@Column(name = "NAME")
	private String name;

	@ColumnTransformer(
			   read="AES_DECRYPT(UNHEX(value), UNHEX(SHA2('Un secret', 512)))",
			   write="HEX(AES_ENCRYPT(?, UNHEX(SHA2('Un secret', 512))))"
			)
	@Column(name = "VALUE")
	private String value; 
	
	@Column(name = "DESCRIPTION")
	private String description;
 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Configuration [id=" + id + ", name=" + name + ", value=" + value + ", description=" + description + "]";
	}	
	
 

}
