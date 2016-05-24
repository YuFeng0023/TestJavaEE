package com.yufeng.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yufeng.model.User;

/**
 * Session Bean implementation class EJBCallJPA
 */
@Stateless
@Remote(UserDaoRemote.class)
public class UserDao implements UserDaoRemote {
	/**
	 * 执行后的状态
	 */
	protected int state;
	/**
	 * 执行后的（错误）信息
	 */
	protected String message;
	@PersistenceContext(unitName = "UserDao")
	private EntityManager manager;
	public UserDao() {
	}
	@Override
	public List<User> showAll() {
		Query q = manager.createQuery("from User u");
		return q.getResultList();
	}
	@Override
	public void addUser(User user) {
		manager.persist(user);
	}
	protected <T> List<T> queryList(String sql,Class T){
		return manager.createQuery(sql,T).getResultList();
	}
	public User login(String username, String password) {
		List<User> result = queryList(" from User u where u.username='" + username + "'", User.class);
		if (result.size() == 0) {
			state = USERNOTEXIST;
			message = "用户名不存在";
			return null;
		} else {
			User user = result.get(0);
			if (user.getPassword().equals(password)) {
				state = SUCCESS;
				return user;
			} else {
				state = WRONGPASSWORD;
				message = "密码错误！";
				return null;
			}
		}
	}

	public void add(User user) {
		if (exist(user.getUsername())) {
			state = USEREXISTS;
			message = "用户名已存在！";
		} else {
			manager.persist(user);
			state = SUCCESS;
		}
	}
	public boolean exist(String username) {
		String hql = "from User u where u.username='" + username + "'";
		return queryList(hql, User.class).size() > 0;
	}
	public List<User> listAll() {
		return queryList("from User u", User.class);
	}
	public int getState() {
		return state;
	}
	public String getMessage() {
		return message;
	}
}
