package com.yschen.test1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetName() {
		Person test=new Person("name", "sex", "Address", "Tel", "mail");
		assertEquals("name", test.getName());
	}

	@Test
	public void testGetSex() {
		Person test=new Person("name", "sex", "Address", "Tel", "mail");
		assertEquals("sex", test.getSex());
	}

	@Test
	public void testGetMail() {
		Person test=new Person("name", "sex", "Address", "Tel", "mail");
		assertEquals("mail", test.getMail());
	}

	@Test
	public void testGetTel() {
		Person test=new Person("name", "sex", "Address", "Tel", "mail");
		assertEquals("Tel", test.getTel());
	}

	@Test
	public void testGetAddress() {
		Person test=new Person("name", "sex", "Address", "Tel", "mail");
		assertEquals("Address", test.getAddress());
	}

}
