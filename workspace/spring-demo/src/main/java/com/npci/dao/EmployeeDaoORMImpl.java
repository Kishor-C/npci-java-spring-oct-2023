package com.npci.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.npci.beans.Employee;

/*  
 
 * DriverManagerDataSource >> LocalSessionFactoryBean >> HibernateTemplate >> EmployeeDaoORMImpl
 
 * Spring container must create this Dao object & supply the HibernateTemplate
 * <bean id = "dao" class = "com.npci.dao.EmployeeDaoORMImpl> 
 * 	<property name = "template" ref = "hibernateTemplateBean" />
 */
public class EmployeeDaoORMImpl implements EmployeeDao {

	private HibernateTemplate template; // generate setter

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	
	public Employee save(Employee employee) {
		// save method returns a Serializable id that is generated
		int id = (int)template.save(employee); // generates insert query
		// now using the id you can get the employee object
		return findById(id); 
	}

	@Override
	public Employee findById(int id) {
		// internally query is select * from employee where primaryKey = idValue
		return template.get(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		// loadAll() -> select * from employee -> each record is added as an employee in the List<T>
		return template.loadAll(Employee.class);
	}

	@Override
	public void delete(int id) {
		Employee employee = findById(id);
		if(employee != null) {
			// delete(T t) -> delete from employee where id = employee.getId();
			template.delete(employee);
		}
	}
	
}
