package com.covalense.apps;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.covalense.beans.Employee;

public class App10 {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();

		Session session = null;
		session = sessionFactory.openSession();

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("giri", 10));
		employees.add(new Employee("priya", 20));
		employees.add(new Employee("hari", 10));
		employees.add(new Employee("charan", 30));

		session.getTransaction().begin();

		for (Employee employee : employees) {
			session.save(employee);

		}
		session.getTransaction().commit();
		System.out.println("Employees saved");

		//Employee emp = session.get(Employee.class, 2);
		//System.out.println("Employee with id :" + emp);

	}
}
