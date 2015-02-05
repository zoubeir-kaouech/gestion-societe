package tn.esprit.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

import tn.esprit.domain.RolePK;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@Table(name="t_role")

public class Role implements Serializable {

	
	private String role;
	private RolePK rolePK;
	private static final long serialVersionUID = 1L;
	private Developpeur developpeur;
	private Projet projet;

	public Role() {
		super();
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}   
	@EmbeddedId
	public RolePK getRolePK() {
		return this.rolePK;
	}

	public void setRolePK(RolePK rolePK) {
		this.rolePK = rolePK;
	}
	@ManyToOne
	@JoinColumn(name="id_developpeur",referencedColumnName="id",insertable=false,updatable=false)
	public Developpeur getDeveloppeur() {
		return developpeur;
	}
	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}
	@ManyToOne
	@JoinColumn(name="id_projet",referencedColumnName="id",insertable=false,updatable=false)
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Role(String role, Developpeur developpeur, Projet projet,Date date) {
		super();
		this.role = role;
		this.developpeur = developpeur;
		this.projet = projet;
		
		
		rolePK=new RolePK(projet.getId(), developpeur.getId(), date);
	}
   
}
