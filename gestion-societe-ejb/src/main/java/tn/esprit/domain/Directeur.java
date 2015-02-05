package tn.esprit.domain;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.domain.Employee;

/**
 * Entity implementation class for Entity: Directeur
 *
 */
@Entity
@Table(name="t_directeur")
public class Directeur extends Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Directeur() {
		super();
	}
   
}
