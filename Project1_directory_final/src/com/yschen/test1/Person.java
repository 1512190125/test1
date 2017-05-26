package com.yschen.test1;

import java.io.BufferedWriter;
import java.io.IOException;

public class Person {
	private String name;
	private String tel;
	private String address;
	private String sex;
	private String mail;
	public Person(String name,String sex,String Address,String Tel,String mail){
		this.setName(name);
		this.setAddress(Address);
		this.setTel(Tel);
		this.setSex(sex);
		this.setMail(mail);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public void saveme(BufferedWriter out){
		try{
			out.write(this.name+"|"+this.sex+"|"+this.address+"|"+this.tel+"|"+this.mail);/**保存联系人**/
			out.newLine();/**换行**/
		}catch(IOException e){
			System.out.println("Error Input!");
			e.printStackTrace();
		}
	}
	public Person getUpdatePerson(){
		return new Person(this.name,this.sex,this.address,this.tel,this.mail);
	}
	

}
