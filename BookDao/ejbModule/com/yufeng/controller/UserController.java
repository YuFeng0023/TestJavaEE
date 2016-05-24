package com.yufeng.controller;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class UserController {
	public String login(){
		return "/LoginServlet";
	}
}
