package tn.esprit.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tn.esprit.delegate.GestionDepartementDelegate;
import tn.esprit.delegate.GestionEmployeeDelagate;
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
}
