package com.yufeng.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@ManagedBean
@RequestScoped
@Entity
@Table(name="book")
public class Book implements Serializable {
	private static final long serialVersionUID = 7386705186582558107L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
	protected Integer id;
	protected String name;//图书名称
	protected String isbn;//图书书号
	protected Integer classifyId;
	protected Double price;//价格
	@ElementCollection(fetch=FetchType.EAGER)
	protected List<String> author;//作者
	@Temporal(TemporalType.DATE)
	protected Date outputDate;//出版日期
	@Transient
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<String> getAuthor() {
		return author;
	}
	public void setAuthor(List<String> author) {
		this.author = author;
	}
	public Date getOutputDate() {
		return outputDate;
	}
	public void setOutputDate(Date outputDate) {
		this.outputDate = outputDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", isbn=" + isbn + ", author=" + author + ", classifyId=" + classifyId
				+ ", outputDate=" + outputDate + ", price=" + price + "]";
	}
	public String onSubmit(){
		System.out.println(this);
		return "confirm.xhtml";
	}
	public String add(){
		System.out.println(this);
		return "success.xhtml";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
