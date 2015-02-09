package tn.esprit.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Employee;
import tn.esprit.services.gestion.employee.GestionEmployeeRemote;

public class TestGestionEmployee {
	static GestionEmployeeRemote remote;
	public static void doAddEmployee(GestionEmployeeRemote remote){

		Employee employee=new Employee();
		employee.setName("foulen");
		if(remote.addEmployee(employee)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void doUpdateEmployee(GestionEmployeeRemote remote){

		Employee employee=remote.findEmployeeById(1);
		employee.setName("foulen1");
		if(remote.updateEmployee(employee)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void doDeleteEmployee(GestionEmployeeRemote remote){

		Employee employee=remote.findEmployeeById(1);
		
		if(remote.deleteEmployee(employee)){
			System.out.println("OK");
		}
		else
			System.out.println("Erreur ...");

	}
	public static void main(String[] args) {
		
		
		try {
			Context context=new InitialContext();
			remote=(GestionEmployeeRemote) context.lookup("gestion-societe-ejb/GestionEmployee!tn.esprit.services.gestion.employee.GestionEmployeeRemote");
				} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//doAddEmployee(remote);
		//doUpdateEmployee(remote);
		doDeleteEmployee(remote);
	}

}
