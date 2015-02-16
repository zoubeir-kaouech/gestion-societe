package tn.esprit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import tn.esprit.delegate.GestionCompetenceDelegate;
import tn.esprit.delegate.GestionEmployeeDelagate;
import tn.esprit.domain.Competence;
import tn.esprit.domain.Employee;

public class TestGestionCompetence {

	@Test
	public void _1doAddCompetence() {
		Competence competence=new Competence();
		competence.setLabel("Java EE");
		assertEquals(GestionCompetenceDelegate.doAddCompetence(competence), true);
		competence.setLabel(".Net");
		assertEquals(GestionCompetenceDelegate.doAddCompetence(competence), true);
		competence.setLabel("PHP");
		assertEquals(GestionCompetenceDelegate.doAddCompetence(competence), true);
		
	}
	@Test
	public void _2doDeleteCompetence(){
		Competence competence=GestionCompetenceDelegate.doFindCompetenceById(1);
	List<Employee> employees=GestionEmployeeDelagate.doFindAllEmployeesByCompetence(competence);
	for (Employee employee : employees) {
		List<Competence> competences=GestionCompetenceDelegate.doFindAllCompetencesByEmployee(employee);
		competences.remove(competence);
		employee.setCompetences(competences);
		GestionEmployeeDelagate.doUpdateEmployee(employee);
	}
		assertEquals(GestionCompetenceDelegate.doDeleteCompetence(competence), true);
	}

}
