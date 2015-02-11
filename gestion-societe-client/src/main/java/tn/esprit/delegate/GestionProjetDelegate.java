package tn.esprit.delegate;

import java.util.Date;
import java.util.List;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Projet;
import tn.esprit.locator.ServiceLocator;
import tn.esprit.services.gestion.departement.GestionDepartementRemote;
import tn.esprit.services.gestion.projet.GestionProjetRemote;

public class GestionProjetDelegate {
	private static final String jndi = "gestion-societe-ejb/GestionProjet!tn.esprit.services.gestion.projet.GestionProjetRemote";

	private static GestionProjetRemote getProxy() {
		return (GestionProjetRemote) ServiceLocator.getInstance()
				.getProxy(jndi);
	}
public static	Boolean doAddProjet(Projet projet ){
		return getProxy().addProjet(projet);
	}
public static Boolean doUpdateProjet(Projet projet){
	return getProxy().updateProjet(projet);
	}
public static	Boolean doDeleteProjet(Projet projet){
	return getProxy().deleteProjet(projet);
	}
public static	Projet doFindProjetById(Integer idProjet){
	return getProxy().findProjetById(idProjet);
	}
public static	List<Projet>doFindAllProjets(){
	return getProxy().findAllProjets();
	}
public static	Boolean doAssignProjetToDeveloppeur(Developpeur developpeur,Projet projet,String role,Date date){
	return getProxy().assignProjetToDeveloppeur(developpeur, projet, role, date);
	}
public static List<Projet> doFindAllProjetByDeveloppeur(Developpeur developpeur) {
	return getProxy().findAllProjetByDeveloppeur(developpeur);
}
}
