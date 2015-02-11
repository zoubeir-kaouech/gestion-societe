package tn.esprit.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import tn.esprit.delegate.GestionEmployeeDelagate;
import tn.esprit.delegate.GestionProjetDelegate;
import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Projet;

public class TestGestionProjet {
	@Test 
public void _1doAddProjet(){
	Projet projet=new Projet();
	projet.setName("Gestion societe");
	projet.setDateCreation(new Date());
	Assert.assertEquals(GestionProjetDelegate.doAddProjet(projet), true);
}
	@Test
	public void _2affectProjetToDeveloppeur(){
		Projet projet=GestionProjetDelegate.doFindProjetById(1);
		Developpeur developpeur=(Developpeur) GestionEmployeeDelagate.doFindEmployeeById(1);
		Assert.assertEquals(GestionProjetDelegate.doAssignProjetToDeveloppeur(developpeur, projet, "Testeur",new Date()), true);
	}
	@Test
	public void _3doFindAllProjetByDeveloppeur(){
		Developpeur developpeur=(Developpeur) GestionEmployeeDelagate.doFindEmployeeById(1);
	Assert.assertEquals(GestionProjetDelegate.doFindAllProjetByDeveloppeur(developpeur).size(),1);
	}
}
