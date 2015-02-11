package tn.esprit.services.gestion.projet;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Projet;

@Remote
public interface GestionProjetRemote {
	Boolean addProjet(Projet projet );
	Boolean updateProjet(Projet projet);
	Boolean deleteProjet(Projet projet);
	Projet findProjetById(Integer idProjet);
	List<Projet>findAllProjets();
	Boolean assignProjetToDeveloppeur(Developpeur developpeur,Projet projet,String role,Date date);
List<Projet> findAllProjetByDeveloppeur(Developpeur developpeur);
}
