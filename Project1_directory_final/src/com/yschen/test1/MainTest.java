package com.yschen.test1;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class MainTest {
	
	private static File f = new File("Directory.txt");
	
	private static Directory myDir = new Directory();

	public static void main(String[] args) {
		myDir.loadDirectory(f);/**导入已有的信息**/
		display();

	}
	public static void display(){
		
		show("menu");
		show("1.\t\tShow The Dir");
		show("2.\t\tSearch");
		show("3.\t\tNew...");
		show("4.\t\tModify");
		show("5.\t\tDelect");
		show("6.\t\tSave");
		show("7.\t\tExit");
		System.out.println("Please enter the number to operate:");
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		switch(in){
		case 1:showDirectory();break;
		case 2:findPerson();break;
		case 3:addNewPerson();break;
		case 4:modifyPerson();break;
		case 5:removePerson();break;
		case 6:saveDirectory();break;
		case 7:System.exit(0);break;
		default:display();
		}
	}
	private static void modifyPerson() {
		// TODO Auto-generated method stub
		System.out.println("name:");
		String name = new Scanner(System.in).next();
		Person person[] = myDir.findPerson(name);
		if(person.length == 0){
			show(" Error Name !'enter' to back");
			enter();
			display();
			return;
		}
		for(Person p:person){
			showPerson(p);
		}
		System.out.println();
		System.out.println("please update your information:");
		System.out.print("name:");
		String name2 = new Scanner(System.in).next();
		
		System.out.print("sex:");
		String sex = new Scanner(System.in).next();
		
		System.out.print("address:");
		String address = new Scanner(System.in).next();
		
		System.out.print("telephone number:");
		String tel = new Scanner(System.in).next();
		
		System.out.print("E-mail:");
		String mail = new Scanner(System.in).next();
		
		Person p = new Person(name2, sex, address, tel, mail);
		System.out.println("y/n");
		String x = new Scanner(System.in).next();
		if("y".endsWith(x)||"Y".equals(x)){
			myDir.addPerson(p);
			myDir.removePerson(person[person.length-1]);
			show("Succeed!'enter' to back");
			enter();
			display();
		}
		else{
			show("You aborted the operation.'enter' to back");
			enter();
			display();
		}
	}

	private static void removePerson(){
		// TODO Auto-generated method stub
		System.out.println("name:");
		String name = new Scanner(System.in).next();
		Person person[] = myDir.findPerson(name);
		if(person.length == 0){
			show(" Error Name !'enter' to back");
			enter();
			display();
			return;
		}
		for(Person p:person){
			showPerson(p);
		}
		System.out.println();
		System.out.println("y/n");
		String x = new Scanner(System.in).next();
		if("y".endsWith(x)||"Y".equals(x)){

			myDir.removePerson(person[person.length-1]);
			show("Succeed!'enter' to back");
			enter();
			display();
		}
		else{
			show("You aborted the operation.'enter' to back");
			enter();
			display();
		}
	}
	private static void saveDirectory() {
		
		myDir.saveDirectory(f);
		show("Successful Save!'enter' to back");
		enter();
		display();
	}

	private static void addNewPerson() {
		
		show("-----------New......-----------");
		System.out.print("name:");
		String name = new Scanner(System.in).next();
		
		System.out.print("sex:");
		String sex = new Scanner(System.in).next();
		
		System.out.print("address:");
		String address = new Scanner(System.in).next();
		
		System.out.print("telephone number:");
		String tel = new Scanner(System.in).next();
		
		System.out.print("E-mail:");
		String mail = new Scanner(System.in).next();
		
		Person p = new Person(name, sex, address, tel, mail);/**录入一条个人信息**/
		System.out.println("New this person?(Y/N)");
		showPerson(p);
		String x = new Scanner(System.in).next();
		if("y".endsWith(x)||"Y".equals(x)){
			myDir.addPerson(p);
			show("Succeed!'enter' to back");
			enter();
			display();
		}
		else{
			show("You aborted the operation.'enter' to back");
			enter();
			display();
		}
	}
	private static void findPerson() {
		
		show("-----------Searching-----------");
		System.out.print("Please enter the name:");
		@SuppressWarnings("resource")
		String search = new Scanner(System.in).next();
		Person person[] = myDir.findPerson(search);
		if(person.length == 0){
			show(" Error Name to search ! 'enter' to back");
			enter();
			display();
			return;
		}
		for(Person p:person){
			showPerson(p);
		}
		show("----get the all----");
		show("'enter' to back");
		enter();
		display();
	}
	
	private static void showDirectory() {
		
		Iterator<Person> itor = myDir.iterator();
		Person p;
		if(myDir.size() == 0){
			show("Empty Directory! 'enter' to back...");
			enter();
			display();
			return;
		}
		int i = 1;
		while(itor.hasNext()){
			p=itor.next();
			showPerson(p);
			if(i++%5==0)
				enter();
		}
		show("----get the all----");
		show("'enter' to back");
		enter();
		display();
	}
	private static void showPerson(Person p) {
		
		show("姓名："+p.getName()+"性别："+p.getSex()+"住址："+p.getAddress()+"联系电话："+p.getTel()+"邮箱："+p.getMail());
	}

	private static void enter() {

		new Scanner(System.in).nextLine();
		
	}
	private static void show(String string) {

		System.out.println(string);
		
	}

}
