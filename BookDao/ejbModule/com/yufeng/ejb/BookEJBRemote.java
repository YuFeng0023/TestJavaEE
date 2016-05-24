package com.yufeng.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.yufeng.model.Book;


public interface BookEJBRemote {
	/**
	 * 添加到图书列表
	 * @param book
	 */
	public void addBook(Book book);
	/**
	 * 获得列表中的一条数据
	 * @param index
	 * @return
	 */
	public Book getBook(int index);
	/**
	 * 将列表中的数据添加到数据库
	 */
	public void persist();
	/**
	 * 返回所有图书
	 * @return
	 */
	public List<Book> listAll();
	/**
	 * 显示当前缓冲
	 * @return
	 */
	public List<Book> listCache();
	
}
