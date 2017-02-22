package com.xebialabs.demo;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MemberListProducer {

	private Logger log = Logger.getLogger(MemberListProducer.class.getName());
	private List<Member> members;

	public List<Member> getMembers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("xl-demo");
		EntityManager em = emf.createEntityManager();
		final List<Member> results = em.createQuery("select m from Member m order by m.id").getResultList();
		em.close();
		emf.close();
		return results;
	}
}
