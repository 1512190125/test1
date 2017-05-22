package com.yschen.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends ArrayList<Person>{
	public Directory(){
	//创建新的通讯录
	}
	public void loadDirectory(File bookFile){//录入：操作添加一条新的记录项
		
		try{
			FileReader fl = new FileReader(bookFile);
			BufferedReader bf = new BufferedReader(fl);
			String temp;
			while((temp=bf.readLine()) != null){
				String a[]=temp.split("|");
				this.add(new Person(a[0],a[2],a[4],a[6],a[8]));//**//
			}
			bf.close();
			fl.close();
		}catch(Exception e){
			System.out.println(".......Error Loading!");
			e.printStackTrace();
		}
	}
	public void saveDirectory(File bookFile){
		Person p;
		try{
			Writer fs = new FileWriter(bookFile);
			BufferedWriter bf2 = new BufferedWriter(fs);
			Iterator<Person> itor = this.iterator();
			while(itor.hasNext()){
				p = itor.next();
				p.saveme(bf2);
				bf2.flush();	
			}
		}catch(IOException e){
		System.out.println(".......Error Saving!");
		e.printStackTrace();
		}
	}
	public void addPerson(Person p){
		this.add(p);//增加联系人
	}
	public void removePerson(Person p){
		this.remove(this.indexOf(p));//删除一条已存在的记录项
	}
	public void modifiedPerson(Person p1,Person p2){
		this.add(this.indexOf(p1),p2);//修改：改变记录项的属性
	}
	public Person[] findPerson(String name){
		Iterator<Person> itor = this.iterator();//迭代器 (网源
		Person p;
		ArrayList<Person> finds = new ArrayList<Person>(0);
		while(itor.hasNext()){
			p=itor.next();
			String pName = p.getName();
			boolean b = name.matches("["+pName+"]*");//匹配姓名
			if(b) 
				finds.add(p);
		}
		Person findp[] = new Person[finds.size()];
		return finds.toArray(findp);
		
	}
	public int getSize(){
		return this.size();
	}

}
