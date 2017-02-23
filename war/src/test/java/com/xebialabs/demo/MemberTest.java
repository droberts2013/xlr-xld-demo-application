package com.xebialabs.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemberTest {

	private String name = "Dave";
	private String email = "droberts@xebialabs.com";
	private String phoneNumber = "866-656-4408";
	private Member member;

	@Before
	public void create() {
		member = new Member(name, email, phoneNumber);
	}
	
	@Test
	public void checkName() {
		assertTrue(this.member.getName().equals(this.name));
	}

	@Test
	public void checkEmail() {
		assertTrue(this.member.getEmail().equals(this.name));
	}

	@Test
	public void checkPhone() {
		assertTrue(this.member.getPhoneNumber().equals(this.phoneNumber));
	}
}

