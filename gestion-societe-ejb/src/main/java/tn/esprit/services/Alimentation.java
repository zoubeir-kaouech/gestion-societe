package tn.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Employee;

/**
 * Session Bean implementation class Alimentation
 */
@Singleton
@LocalBean
@Startup
public class Alimentation {
	@PersistenceContext
	EntityManager em;

	public Alimentation() {
		// TODO Auto-generated constructor stub
	}

	// @PostConstruct
	public void addEmployee() {
		Employee employee = new Employee();
		employee.setName("foulen");
		em.persist(employee);
		Developpeur developpeur = new Developpeur();
		developpeur.setName("dev");
		developpeur.setMatricule("123");
		em.persist(developpeur);
	}

}
