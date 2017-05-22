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
	//�����µ�ͨѶ¼
	}
	public void loadDirectory(File bookFile){//¼�룺�������һ���µļ�¼��
		
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
		this.add(p);//������ϵ��
	}
	public void removePerson(Person p){
		this.remove(this.indexOf(p));//ɾ��һ���Ѵ��ڵļ�¼��
	}
	public void modifiedPerson(Person p1,Person p2){
		this.add(this.indexOf(p1),p2);//�޸ģ��ı��¼�������
	}
	public Person[] findPerson(String name){
		Iterator<Person> itor = this.iterator();//������ (��Դ
		Person p;
		ArrayList<Person> finds = new ArrayList<Person>(0);
		while(itor.hasNext()){
			p=itor.next();
			String pName = p.getName();
			boolean b = name.matches("["+pName+"]*");//ƥ������
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
