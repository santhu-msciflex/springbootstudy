package com.example.demo.userservice;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="User")
public class UserEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2, max=10, message="send vailid data for name field..")
	private String name;
	@JsonIgnore
	private Date birthDate;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<PostsEntity> posts;
	
	public List<PostsEntity> getPosts() {
		return posts;
	}
	public void setPosts(List<PostsEntity> posts) {
		this.posts = posts;
	}
	public UserEntity() {
		super();
	}
	public UserEntity(String name, Date birthDate) {
		super();
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void addPost(PostsEntity post) {
		posts.add(post);
	}
}
