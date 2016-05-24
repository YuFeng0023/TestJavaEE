package com.yufeng.ejb;

import javax.ejb.Remote;

@Remote
public interface LoginCountRemote {
	/**
	 * 统计
	 */
	public void statistic();
	/**
	 * 获取统计结果
	 * @return
	 */
	public int getCount();
}
