/**
 * 
 */
package com.restful.webservice.restfulwebservice.users;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * @author Balaji
 *
 */
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2, message="Name should be atlease 2 character")
	private String name;
	@Past
	private Date dob;
	
	@OneToMany(mappedBy="user")
	private List<Posts>	 posts;

	public User() {
		super();
	}


	/**
	 * 
	 */
	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}


	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	

	/**
	 * @return the posts
	 */
	public List<Posts> getPosts() {
		return posts;
	}


	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	

}
