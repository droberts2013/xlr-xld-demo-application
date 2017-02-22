package com.xebialabs.demo;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.xebialabs.demo.Member;

@ManagedBean
@SessionScoped
public class MemberRegistration implements Serializable {

	static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(MemberRegistration.class.getName());
	private String name;
	private String email;
	private String phoneNumber;
	private Member newMember;
	private MemberListProducer mlp;

   public String getName() {
	return name;
}


   public void setName(String name) {
	   this.name = name;
   }


   public String getEmail() {
	   return email;
   }


   public void setEmail(String email) {
	   this.email = email;
   }


   public String getPhoneNumber() {
	   return phoneNumber;
   }


   public void setPhoneNumber(String phoneNumber) {
	   this.phoneNumber = phoneNumber;
   }

   public Member getNewMember() {
	   return newMember;
   }
   
   public MemberListProducer getMlp() {
		return new MemberListProducer();
	}

   public void register() throws Exception {
	   newMember = new Member(this.name, this.email, this.phoneNumber);
	   log.info("Registering " + newMember.getName());
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("xl-demo");
	   EntityManager em = emf.createEntityManager();
	   em.getTransaction().begin();
	   em.persist(newMember);
	   em.getTransaction().commit();
	   em.close();
	   emf.close();
	   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, newMember.getName() + " has registered!", "Registration successful"));
	   initFormData();
   }

   private void initFormData() {
	   this.name = null;
	   this.email = null;
	   this.phoneNumber = null;
   }


}
