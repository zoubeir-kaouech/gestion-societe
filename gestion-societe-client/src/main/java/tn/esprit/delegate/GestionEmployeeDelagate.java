package tn.esprit.delegate;

import java.util.List;

import tn.esprit.domain.Competence;
import tn.esprit.domain.Employee;
import tn.esprit.locator.ServiceLocator;
import tn.esprit.services.gestion.employee.GestionEmployeeRemote;

public class GestionEmployeeDelagate {
	static GestionEmployeeRemote remote;
	private static final String jndi="gestion-societe-ejb/GestionEmployee!tn.esprit.services.gestion.employee.GestionEmployeeRemote"; 

	private static GestionEmployeeRemote getProxy(){
		return (GestionEmployeeRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	
	public  static Boolean doAddEmployee(Employee employee){
	return getProxy().addEmployee(employee);
	
}
	public static Employee doAuthentificate(String login,String pwd){
		return getProxy().authentificate(login, pwd);
	}
	public static Employee doFindEmployeeById(Integer idEmployee){
		return getProxy().findEmployeeById(idEmployee);
	}
	public static Boolean doUpdateEmployee(Employee employee){
		return getProxy().updateEmployee(employee);
	}
	public static List<Employee> doFindAllEmployeesByCompetence(Competence competence) {
		return getProxy().findAllEmployeesByCompetence(competence);
	}
	public static Boolean doDeleteEmployee(Employee employee){
		return getProxy().deleteEmployee(employee);
	}
}
