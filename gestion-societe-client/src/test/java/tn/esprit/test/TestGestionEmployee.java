package tn.esprit.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tn.esprit.delegate.GestionCompetenceDelegate;
import tn.esprit.delegate.GestionDepartementDelegate;
import tn.esprit.delegate.GestionEmployeeDelagate;
import tn.esprit.domain.Competence;
import tn.esprit.domain.Departement;
import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Directeur;
import tn.esprit.domain.Employee;

public class TestGestionEmployee {

	@Test
	public void doAuthentificate() {
		assertTrue(GestionEmployeeDelagate.doAuthentificate("dev", "dev")!=null);
	}
	@Test
	public void _1doAddEmployee() {
		Employee employee=new Developpeur();
		employee.setName("directeur");
		employee.setLogin("directeur");
		employee.setPwd("directeur");
	assertEquals(GestionEmployeeDelagate.doAddEmployee(employee),true);
	}
	 @Test
	public void _2doAddDepratement(){
		Departement departement=new Departement();
		departement.setName("Informatique");
		assertEquals(GestionDepartementDelegate.doAddDepartement(departement),true);
		
	}
	 @Test
	 public void _3affectDepartementToEmployee(){
		 Departement departement=GestionDepartementDelegate.doFindDepartementById(1);
		 Employee employee=GestionEmployeeDelagate.doFindEmployeeById(1);
		 employee.setDepartement(departement);
		 assertEquals(GestionEmployeeDelagate.doUpdateEmployee(employee),true);
		 
	 }
	 @Test
	 public void _4affectNewDepartementToNewEmployee(){
		
		 Departement departement=new Departement();
departement.setName("Dep");
		 Employee employee=new Developpeur();
		 employee.setName("Foulen");
		 employee.setDepartement(departement);
		 assertEquals(GestionEmployeeDelagate.doUpdateEmployee(employee),true);
		 
	 }
	 @Test
	 public void _5affectNewEmployeesToNewDepartement(){
		 Departement departement=new Departement();
		 departement.setName("Dep");
		 List<Employee> employees=new ArrayList<Employee>();
		 Employee  directeur=new Directeur();
		 directeur.setName("directeur");
		 Employee developpeur =new Developpeur();
		 developpeur.setName("developpeur");
		 employees.add(developpeur);
		 employees.add(directeur);
		 //departement.setEmployees(employees);
		 departement.asseignEmployeesToDepartement(employees);
		 assertEquals(GestionDepartementDelegate.doAddDepartement(departement),true);
		 
	 }
	 @Test
	 public void _6affectCompetencesToEmployee(){
		 Employee employee=GestionEmployeeDelagate.doFindEmployeeById(1);
		 List<Competence> competences=GestionCompetenceDelegate.doFindAllCompetences();
		 employee.setCompetences(competences);
		 assertEquals(GestionEmployeeDelagate.doUpdateEmployee(employee), true);
	 }
	 @Test
	 public void _7affectNewCompetencesToEmployee(){
		 Employee employee=GestionEmployeeDelagate.doFindEmployeeById(1);
		List<Competence> competences=new ArrayList<Competence>();
		Competence competence=new Competence();
		competence.setLabel("Java");
		competences.add(competence);
		
		Competence competence2=new Competence();
		competence2.setLabel("NoSql");
		competences.add(competence2);
		List<Competence> competences2=GestionCompetenceDelegate.doFindAllCompetencesByEmployee(employee);
		competences2.addAll(competences);
		employee.setCompetences(competences2);
		assertEquals(GestionEmployeeDelagate.doUpdateEmployee(employee), true);
	 }
	 @Test
	 public void _8affectCompetencesToNewEmployee(){
		 Employee employee=new Directeur();
		 employee.setName("directeur");
		
		List<Competence> competences2=GestionCompetenceDelegate.doFindAllCompetences();
	
		employee.setCompetences(competences2);
		assertEquals(GestionEmployeeDelagate.doUpdateEmployee(employee), true);
	 }	 
	 @Test
	 public void _9deleteEmployee(){
		 Employee employee=GestionEmployeeDelagate.doFindEmployeeById(1);
		 assertEquals(GestionEmployeeDelagate.doDeleteEmployee(employee), true);
	 }
}
