package com.yufeng.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

@ManagedBean
@RequestScoped
@Entity
@Table(name="user")
public class User implements Serializable{
	private static final long serialVersionUID = -7067474280515536584L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
	protected Integer id;
	protected String username;
	protected String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
