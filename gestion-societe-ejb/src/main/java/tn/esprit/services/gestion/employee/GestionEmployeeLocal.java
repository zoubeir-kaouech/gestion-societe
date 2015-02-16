package tn.esprit.services.gestion.employee;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.domain.Competence;
import tn.esprit.domain.Departement;
import tn.esprit.domain.Employee;

@Local
public interface GestionEmployeeLocal {
	Boolean addEmployee(Employee employee);

	Boolean updateEmployee(Employee employee);

	Boolean deleteEmployee(Employee employee);

	Employee findEmployeeById(Integer idEmployee);

	List<Employee> findAllEmployees();

	Employee authentificate(String login, String pwd);

	List<Employee> findAllEmployeesByDepartement(Departement departement);

List<Employee> findAllEmployeesByCompetence(Competence  competence);
}
