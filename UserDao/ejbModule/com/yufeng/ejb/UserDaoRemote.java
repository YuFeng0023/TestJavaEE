package com.yufeng.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.Query;

import com.yufeng.model.User;

@Remote
public interface UserDaoRemote {
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;
	public static final int USERNOTEXIST = 2;
	public static final int USEREXISTS = 3;
	public static final int WRONGPASSWORD = 4;
	public List<User> showAll();
	public void addUser(User user);
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password) ;
	/**
	 * 判断用户是否存在
	 * @param username
	 * @return
	 */
	public boolean exist(String username) ;
	/**
	 * 显示所有
	 * @return
	 */
	public List<User> listAll() ;
	/**
	 * 获取执行状态
	 * @return
	 */
	public int getState() ;
	/**
	 * 获取执行信息
	 * @return
	 */
	public String getMessage();
}
