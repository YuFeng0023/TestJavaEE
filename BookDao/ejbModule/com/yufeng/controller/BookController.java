package com.yufeng.controller;

import java.util.Hashtable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.yufeng.ejb.BookEJBRemote;
import com.yufeng.model.Book;

@javax.faces.bean.ManagedBean
@SessionScoped
public class BookController {
	protected static Context context;
	protected BookEJBRemote bookdao;
	public BookController(){
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		try {
			context = new InitialContext(jndiProperties);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bookdao = (BookEJBRemote) context.lookup("ejb:/BookDao//BookEJB!com.yufeng.ejb.BookEJBRemote?stateful");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Book> getBooksFromDB(){
		List<Book> result = null ;
		result = bookdao.listAll();
		return result;
	}
	public List<Book> getBooksFromCache(){
		return bookdao.listCache();
	}
	public String addBook(Book book){
		System.out.println(book);
		bookdao.addBook(book);
		return "";
	}
	public BookEJBRemote getBookdao() {
		return bookdao;
	}
}
