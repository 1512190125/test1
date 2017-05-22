package com.yschen.test1;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class MainTest {
	private static Directory myDir = new Directory();
	private static File f = new File("Directory.txt");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display();

	}
	public static void display(){
		show("---------------------Directory---------------------");
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
		case 4:break;
		case 5:break;
		case 6:saveDirectory();break;
		case 7:System.exit(0);break;
		default:display();
		}
	}
	private static void saveDirectory() {
		// TODO Auto-generated method stub
		myDir.saveDirectory(f);
		show("Successful Save!'enter' to back");
		enter();
		display();
	}
	@SuppressWarnings("resource")
	private static void addNewPerson() {
		// TODO Auto-generated method stub
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
		Person p = new Person(name, sex, address, tel, mail);
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		show("������"+p.getName()+"�Ա�"+p.getSex()+"סַ��"+p.getAddress()+"��ϵ�绰��"+p.getTel()+"���䣺"+p.getMail());
	}
	private static void enter() {
		// TODO Auto-generated method stub
		new Scanner(System.in).nextLine();
		
	}
	private static void show(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		
	}

}