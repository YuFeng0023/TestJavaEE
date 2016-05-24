package com.yufeng.ejb;

import javax.ejb.Singleton;

/**
 * Session Bean implementation class LoginCount
 */
@Singleton
public class LoginCount implements LoginCountRemote {
	private Integer count = 0;
    public LoginCount() {
        // TODO Auto-generated constructor stub
    }
    public void statistic(){
    	count++;
    }
    public int getCount(){
    	return count;
    }
}
