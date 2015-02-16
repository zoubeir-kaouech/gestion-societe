package tn.esprit.services.gestion.competence;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.domain.Competence;
import tn.esprit.domain.Employee;

@Remote
public interface GestionCompetenceRemote {
	Boolean addCompetence(Competence competence );
	Boolean updateCompetence(Competence competence);

	Boolean deleteCompetence(Competence competence);
	Competence findCompetenceById(Integer idCompetence);
	
	List<Competence> findAllCompetences();
	List<Competence> findAllCompetencesByEmployee(Employee employee);
}
