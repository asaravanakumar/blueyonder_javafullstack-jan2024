package com.examples.hibernate.jpa;

import java.util.Iterator;
import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.PersistenceException;

import com.examples.hibernate.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

import org.hibernate.HibernateException;

public class EmployeeManager {

	private static EntityManagerFactory factory;

	public static void main(String[] args) {

		// STEP 1: Create EntityManagerFactory
		factory = Persistence.createEntityManagerFactory("com.examples.hibernate.jpa");
		System.out.println("Connected to databased - " + factory);

		// STEP 2: Create EntityManager
		// STEP 3: Transaction Management
		// STEP 4: Perform CRUD Operations using Query/Criteria API

		Employee emp = new Employee("Mani", 25, "Developer", "IT", "India");

		listEmployees();

		Integer empId1 = createEmployee(emp);

		listEmployees();

		updateEmployee(empId1, "Admin", "Software Engineer");

		listEmployees();

		deleteEmployee(empId1);

		listEmployees();

	}

	// CREATE EMPLOYEE
	private static Integer createEmployee(Employee employee) {

		EntityManager entityManager = factory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			// Insert data into table by supplying the persistent object
			entityManager.persist(employee);

			System.out.println("\nEmployee inserted successfully with ID - " + employee.getId());

			entityManager.getTransaction().commit();
		} catch (PersistenceException pe) {
			entityManager.getTransaction().rollback();
			pe.printStackTrace();
		}

		return employee.getId();
	}

	// UPDATE EMPLOYEE DETAILS
	private static void updateEmployee(Integer empId, String dept, String designation) {
		EntityManager entityManager = factory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			// Update Employee Details
			Employee empForUpdate = entityManager.find(Employee.class, empId);
			empForUpdate.setDepartment(dept);
			empForUpdate.setDesignation(designation);
//			entityManager.persist();

			System.out.format("\nEmployee %s updated successfuly.\n", empId);

			entityManager.getTransaction().commit();

		} catch (PersistenceException pe) {
			entityManager.getTransaction().rollback();
			pe.printStackTrace();
		}
	}

	// DELETE EMPLOYEE DETAILS
	private static void deleteEmployee(Integer empId) {
		EntityManager entityManager = factory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			// Get Employee entity to delete
			Employee empForDelete = entityManager.find(Employee.class, empId);
			entityManager.remove(empForDelete);

			System.out.format("\nEmployee %s deleted successfuly.\n", empId);

			entityManager.getTransaction().commit();

		} catch (HibernateException he) {
			entityManager.getTransaction().rollback();
			he.printStackTrace();
		}
	}

	private static void listEmployees() {
		EntityManager entityManager = factory.createEntityManager();

		try {
			entityManager.getTransaction().begin();

			// List Employee Details
			List<Employee> employees = entityManager.createQuery("FROM Employee").getResultList();

			System.out.println("ID \tName \tAge \tDepartment \tDesignation \tCountry");
			for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();

				System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getAge() + "\t"
						+ "\t" + employee.getDepartment() + "\t" + employee.getDesignation() + "\t" + employee.getCountry());
			}

			entityManager.getTransaction().commit();

		} catch (PersistenceException pe) {
			entityManager.getTransaction().rollback();
			pe.printStackTrace();
		}
	}

}
