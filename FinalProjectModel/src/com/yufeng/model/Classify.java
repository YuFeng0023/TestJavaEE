package com.yufeng.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Classify implements Serializable{
	private static final long serialVersionUID = 2539273878556468699L;
	protected Integer cid;//ID
	protected String desc;//描述
	protected Integer fid;//父类ID
	public Classify(Integer cid, String desc, Integer fid) {
		super();
		this.cid = cid;
		this.desc = desc;
		this.fid = fid;
	}
	public Classify(Integer cid, String desc) {
		super();
		this.cid = cid;
		this.desc = desc;
	}
	public Classify() {
		super();
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	@Override
	public String toString() {
		return "Classify [cid=" + cid + ", desc=" + desc + ", fid=" + fid + "]";
	}
}
