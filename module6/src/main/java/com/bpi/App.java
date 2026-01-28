package com.bpi;

import com.bpi.model.Student;
import com.bpi.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

        try {
            runM6Activity2(em);
        } finally {
            EntityManagerUtil.getInstance().closeEntityManager(em);
            EntityManagerUtil.getInstance().shutdownFactory();
        }
    }

    static void runM6Activity2(EntityManager em) {

        try {
            em.getTransaction().begin();

            Student newStudent = new Student();
            newStudent.setName("Kaga Nazuna");
            newStudent.setAge(22);
            newStudent.setEmail("nazupi@example.com");

            em.persist(newStudent);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

}
