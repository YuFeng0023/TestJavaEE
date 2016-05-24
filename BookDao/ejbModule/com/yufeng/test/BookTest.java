package com.yufeng.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yufeng.model.Book;
import com.yufeng.util.JPAUtil;

public class BookTest {
	public static void main(String[] args) {
		System.out.println(new JPAUtil().queryAll("from Book b", Book.class).get(0).getAuthor());
	}

	private static void addTest() {
		Book book = new Book();
		List<String> author = new ArrayList<>();
		author.add("12");
		author.add("34");
		book.setAuthor(author);
		book.setClassifyId(1);
		book.setIsbn("asdf");
		book.setName("name");
		book.setOutputDate(new Date());
		book.setPrice(12.22);
		new JPAUtil().addObject(book);
	}
}
