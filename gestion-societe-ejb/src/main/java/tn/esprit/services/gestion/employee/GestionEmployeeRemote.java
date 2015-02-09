package tn.esprit.services.gestion.employee;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.domain.Employee;

@Remote
public interface GestionEmployeeRemote {
Boolean addEmployee(Employee employee );
Boolean updateEmployee(Employee employee);
Boolean deleteEmployee(Employee employee);
Employee findEmployeeById(Integer idEmployee);
List<Employee>findAllEmployees();

}
