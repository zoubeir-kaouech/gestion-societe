package tn.esprit.services.gestion.projet;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.domain.Projet;

@Local
public interface GestionProjetLocal {
	Boolean addProjet(Projet projet );
	Boolean updateProjet(Projet projet);
	Boolean deleteProjet(Projet projet);
	Projet findProjetById(Integer idProjet);
	List<Projet>findAllProjets();
}
