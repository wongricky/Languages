package com.rickywong.languages.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, max = 20)
	private String name;
	@Size(min = 2, max = 20)
	private String creator;
	@Column(nullable=false)
	private float currentVersion;
	
	public Language() {
	}
	
	public Language(Long id, String name, String creator, float currentVersion) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public float getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(float currentVersion) {
		this.currentVersion = currentVersion;
	}
	
	
	
	
}