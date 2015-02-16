package tn.esprit.delegate;

import java.util.Date;
import java.util.List;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Competence;
import tn.esprit.domain.Employee;
import tn.esprit.locator.ServiceLocator;
import tn.esprit.services.gestion.departement.GestionDepartementRemote;
import tn.esprit.services.gestion.competence.GestionCompetenceRemote;

public class GestionCompetenceDelegate {
	private static final String jndi = "gestion-societe-ejb/GestionCompetence!tn.esprit.services.gestion.competence.GestionCompetenceRemote";

	private static GestionCompetenceRemote getProxy() {
		return (GestionCompetenceRemote) ServiceLocator.getInstance()
				.getProxy(jndi);
	}
public static	Boolean doAddCompetence(Competence competence ){
		return getProxy().addCompetence(competence);
	}
public static Boolean doUpdateCompetence(Competence competence){
	return getProxy().updateCompetence(competence);
	}
public static	Boolean doDeleteCompetence(Competence competence){
	return getProxy().deleteCompetence(competence);
	}
public static	Competence doFindCompetenceById(Integer idCompetence){
	return getProxy().findCompetenceById(idCompetence);
	}
public static	List<Competence>doFindAllCompetences(){
	return getProxy().findAllCompetences();
	}
public static  List<Competence> doFindAllCompetencesByEmployee(Employee employee) {
	return getProxy().findAllCompetencesByEmployee(employee);
}
}
