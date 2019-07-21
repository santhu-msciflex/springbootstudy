package com.example.demo.userservice;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Post")
public class PostsEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String description; 
	
	@JsonIgnore
	@ManyToOne
	private UserEntity user;
	
	public PostsEntity() {
		
	}

	public PostsEntity(Integer id, String description, UserEntity user) {
		super();
		this.id = id;
		this.description = description;
		this.user = user;
	}

	@Override
	public String toString() {
		return "PostsEntity [id=" + id + ", description=" + description + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
