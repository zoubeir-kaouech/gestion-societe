package tn.esprit.services.gestion.projet;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.domain.Developpeur;
import tn.esprit.domain.Projet;
import tn.esprit.domain.Role;

/**
 * Session Bean implementation class GestionProjet
 */
@Stateless
public class GestionProjet implements GestionProjetRemote, GestionProjetLocal {
	@PersistenceContext(unitName="gestion-societe-ejb")
	   EntityManager entityManager;
	    public GestionProjet() {
	        // TODO Auto-generated constructor stub
	    }

		@Override
		public Boolean addProjet(Projet projet) {
			try {
				entityManager.persist(projet);
				
				return true;
			} catch (Exception e) {
				return false;
			}
			
		}

		@Override
		public Boolean updateProjet(Projet projet) {
			try {
				entityManager.merge(projet);
				projet.setName("BBB");
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		@Override
		public Boolean deleteProjet(Projet projet) {
			try {
				//projet=entityManager.find(Projet.class, projet.getId())
				
				entityManager.remove(entityManager.merge(projet));
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public Projet findProjetById(Integer idProjet) {
			Projet projet=null;
			try {
				projet=entityManager.find(Projet.class, idProjet);
			} catch (Exception e) {
				
			}
			return projet;
		}

		@Override
		public List<Projet> findAllProjets() {
			Query query=entityManager.createQuery("select e from Projet e ");
			return query.getResultList();
		}

		@Override
		public Boolean assignProjetToDeveloppeur(Developpeur developpeur,
				Projet projet, String role, Date date) {
			Role role2=new Role(role, developpeur, projet, date);
			entityManager.persist(role2);
			return true;
		}

		@Override
		public List<Projet> findAllProjetByDeveloppeur(Developpeur developpeur) {
			Query query=entityManager.createQuery("select distinct p from Projet p join p.roles r where r.developpeur=:dev");
			query.setParameter("dev", developpeur);
			Query query2=entityManager.createQuery("select r.projet from Role r where r.developpeur=:dev");
			return query.getResultList();
		}

		

}
