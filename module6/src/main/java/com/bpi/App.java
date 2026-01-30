package com.bpi;

import com.bpi.model.Courses;
import com.bpi.model.Student;
import com.bpi.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class App {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

        try {
            crudOperations(em);
        } finally {
            EntityManagerUtil.getInstance().closeEntityManager(em);
            EntityManagerUtil.getInstance().shutdownFactory();
        }
    }

    static void crudOperations(EntityManager em) {
        EntityTransaction txn = em.getTransaction();

		txn.begin();
		
        Student newStudent = new Student();
        newStudent.setName("Komori Meto");
        newStudent.setAge(18);
        newStudent.setEmail("meto@example.com");
        
        // persist to context
        em.persist(newStudent);

        // calls flush
        em.flush();

        em.detach(newStudent);
        
        System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));
        
        Student student = em.find(Student.class, 16L);
        em.merge(student);

        student.setAge(21);
        student.setEmail("messan@example.com");

        em.flush();

        System.out.println("is newStudent inside the persistence context: " + em.contains(student));
        
        em.remove(student);

        em.flush();

        System.out.println("is newStudent inside the persistence context: " + em.contains(student));

		em.getTransaction().commit();
	}


}
