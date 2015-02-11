package tn.esprit.services.gestion.employee;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.domain.Departement;
import tn.esprit.domain.Employee;

/**
 * Session Bean implementation class GestionEmployee
 */
@Stateless
public class GestionEmployee implements GestionEmployeeRemote, GestionEmployeeLocal {
@PersistenceContext(unitName="gestion-societe-ejb")
   EntityManager entityManager;
    


public GestionEmployee() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addEmployee(Employee employee) {
		try {
			entityManager.persist(employee);
			employee.setName("AAA");
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		try {
			entityManager.merge(employee);
			employee.setName("BBB");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteEmployee(Employee employee) {
		try {
			//employee=entityManager.find(Employee.class, employee.getId())
			
			entityManager.remove(entityManager.merge(employee));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee findEmployeeById(Integer idEmployee) {
		Employee employee=null;
		try {
			employee=entityManager.find(Employee.class, idEmployee);
			employee.setPhoto(employee.getPhoto());
		} catch (Exception e) {
			
		}
		return employee;
	}

	@Override
	public List<Employee> findAllEmployees() {
		Query query=entityManager.createQuery("select e from Employee e ");
		return query.getResultList();
	}

	@Override
	public Employee authentificate(String login, String pwd) {
		Employee employee=null;

		try {
			Query query=entityManager.createQuery("select e from Employee e where e.login=:l and e.pwd=:p");	
		query.setParameter("l", login).setParameter("p",pwd);
		employee=(Employee) query.getSingleResult();
		} catch (Exception e) {
			employee=null;
		}
		return employee;
	}

	@Override
	public List<Employee> findAllEmployeesByDepartement(Departement departement) {
		Query query=entityManager.createQuery("select e from Employee e where e.departement=:dep");
		query.setParameter("dep", departement);
		return query.getResultList();
	}

}
