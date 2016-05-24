package com.yufeng.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ClassifyManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7333503269821478639L;
	protected Integer curID ;
	protected  Classify[] first = { new Classify(1, "计算机"), new Classify(2, "文学"), new Classify(3, "管理"),
			new Classify(4, "其他") };
	protected  Classify[] backup = { 
			new Classify(5, "软件工程", 1), new Classify(6, "计算机网络", 1),
			new Classify(7, "编程语言", 1), new Classify(8, "其他", 1), 
			new Classify(9, "小说", 2),new Classify(10, "散文",2),
			new Classify(11, "诗词",2),new Classify(12, "其他",2),
			new Classify(13, "行政管理",3),new Classify(14, "工商管理",3),
			new Classify(15, "金融管理",3),new Classify(16, "其他",3),
			new Classify(17, "无",4)};
	List<Classify> second = new ArrayList<>();
	
	public ClassifyManager(){
		curID=1;
		setSecond();
	}
	public  Classify[] getFirst() {
		return first;
	}
	public  Classify[] getSecond() {
		System.out.println(curID+"\t\t"+second);
		Classify [] result = new Classify[second.size()];
		return second.toArray(result);
	}
	protected void setSecond() {
		System.out.println("setting");
		second.clear();
		for(Classify clsf : backup){
			if(clsf.fid==curID){
				second.add(clsf);
			}
		}
	}
	public Integer getCurID() {
		return curID;
	}
	public void setCurID(Integer curID) {
		this.curID = curID;
		setSecond();//更新
	}
	public void update(){
		getSecond();
	}
	public String getMessage(int id){
		System.out.println(id);
		Classify se = find(id,backup);
		if(se == null){
			Classify fr = find(id,first);
			return fr==null?"分类信息为空":fr.getDesc();
		}
		return find(se.getFid(),first).getDesc()+"-->"+se.getDesc();
	}
	public Classify find(int id,Classify[] src){
		for(Classify c: src){
			if(c.cid==id) return c;
		}
		return null;
	}
}
