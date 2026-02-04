package com.bpi;

import java.util.List;

import com.bpi.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class App {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

        try {
            prinStudentNames(em);
            countCourseByStudentID(em, 1L);
            countStudentsByAgeGreaterThan(em, 20);
        } finally {
            EntityManagerUtil.getInstance().closeEntityManager(em);
            EntityManagerUtil.getInstance().shutdownFactory();
        }
    }

    static void prinStudentNames(EntityManager em) {
        em.getTransaction().begin();

        String jpql = "SELECT s.name FROM Student s";
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        List<String> students = query.getResultList();

        // print student names
        students.forEach(name -> System.out.println(name));

        em.getTransaction().commit();
    }

    static void countCourseByStudentID(EntityManager em, Long id) {
        em.getTransaction().begin();

        String jpql = "SELECT COUNT(c) FROM Courses c JOIN c.student s WHERE s.id = :id";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("id", id);
        List<Long> courses = query.getResultList();

        courses.forEach(c -> System.out.println("Count of courses by student ID: " + id + " = " + c));

        em.getTransaction().commit();
    }

    static Long countStudentsByAgeGreaterThan(EntityManager em, int age) {
        em.getTransaction().begin();

        Long studentAge = em.createQuery(
                "SELECT COUNT(DISTINCT s) FROM Student s WHERE s.age > :age", Long.class).setParameter("age", age)
                .getSingleResult();

        System.out.println("student with age greaterthan 20 = " + studentAge);

        em.getTransaction().commit();

        return studentAge;

    }

}
