package com.xebialabs.demo;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.xebialabs.demo.Member;

/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the members table.
 */
@Path("/members")
@RequestScoped
public class MemberResourceRestService {

   @GET
   @Produces("text/xml")
   public List<Member> listAllMembers() {
      // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
      // this query
      @SuppressWarnings("unchecked")
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("xl-demo");
      EntityManager em = emf.createEntityManager();
      final List<Member> results = em.createQuery("select m from Member m order by m.id").getResultList();
      em.close();
      emf.close();
      return results;
   }

   @GET
   @Path("/{id:[0-9][0-9]*}")
   @Produces("text/xml")
   public Member lookupMemberById(@PathParam("id") long id) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("xl-demo");
      EntityManager em = emf.createEntityManager();
      Member member = em.find(Member.class, id);
      em.close();
      emf.close();
	  return member;
   }
}

