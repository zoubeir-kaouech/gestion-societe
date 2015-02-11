package tn.esprit.delegate;

import tn.esprit.domain.Departement;
import tn.esprit.locator.ServiceLocator;
import tn.esprit.services.gestion.departement.GestionDepartementRemote;

public class GestionDepartementDelegate {
	GestionDepartementRemote departementRemote;
	private static final String jndi = "gestion-societe-ejb/GestionDepartement!tn.esprit.services.gestion.departement.GestionDepartementRemote";

	private static GestionDepartementRemote getProxy() {
		return (GestionDepartementRemote) ServiceLocator.getInstance()
				.getProxy(jndi);
	}
public static	Boolean doAddDepartement(Departement departement ){
		return getProxy().addDepartement(departement);
	}
public static	Departement doFindDepartementById(Integer idDepartement){
		return getProxy().findDepartementById(idDepartement);
	}
}
