package com.yufeng.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.yufeng.model.Book;

/**
 * Session Bean implementation class BookEJB
 */
@Stateful
@Remote(BookEJBRemote.class)
public class BookEJB implements BookEJBRemote,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1869733304095319512L;
	@PersistenceUnit(unitName = "BookDao")
	private EntityManagerFactory factory;
	private EntityManager manager;
	List<Book> books = new ArrayList<>();
	
	@PostConstruct
	public void init(){
		manager = factory.createEntityManager();
	}
	@Remove
	public void destory(){
		manager.close();
	}
	/**
	 * 添加到图书列表
	 * @param book
	 */
	public void addBook(Book book){
		books.add(book);
	}
	/**
	 * 获得列表中的一条数据
	 * @param index
	 * @return
	 */
	public Book getBook(int index){
		return books.get(index);
	}
	/**
	 * 将列表中的数据添加到数据库
	 */
	public void persist(){
		manager.joinTransaction();
		for(Book b : books){
			manager.persist(b);
		}
		manager.flush();
		manager.clear();
		books.clear();
	}
	/**
	 * 返回数据库中全部书籍
	 */
	public List<Book> listAll(){
		return manager.createQuery("from Book b",Book.class).getResultList();
	}
	/**
	 * 显示当前缓冲
	 * @return
	 */
	public List<Book> listCache(){
		return books;
	}
}
