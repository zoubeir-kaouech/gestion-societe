package tn.esprit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import tn.esprit.delegate.GestionEmployeeDelagate;
import tn.esprit.domain.Directeur;
import tn.esprit.domain.Employee;

public class TestGestionEmployee {

	@Test
	public void doAuthentificate() {
		assertTrue(GestionEmployeeDelagate.doAuthentificate("dev", "dev")!=null);
	}
	@Test
	public void doAddEmployee() {
		Employee employee=new Directeur();
		employee.setName("directeur");
		employee.setLogin("directeur");
		employee.setPwd("directeur");
	assertEquals(GestionEmployeeDelagate.doAddEmployee(employee),true);
	}
}
