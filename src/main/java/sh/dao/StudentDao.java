package sh.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sh.dto.Student;

public class StudentDao {

	public Student saveStudent(Student student) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pooji");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		
		return student;
	}
	
}
