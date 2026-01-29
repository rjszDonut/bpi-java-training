package com.bpi;

import com.bpi.model.Courses;
import com.bpi.model.Student;
import com.bpi.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

        try {
            persistOneToMany(em);
        } finally {
            EntityManagerUtil.getInstance().closeEntityManager(em);
            EntityManagerUtil.getInstance().shutdownFactory();
        }
    }

    static void persistOneToMany(EntityManager em) {
		em.getTransaction().begin();
		
		Student student1 = em.find(Student.class, 9L);
		
		Courses newCourse = new Courses();
		newCourse.setCourse_name("Mathematics");
		newCourse.setGrade(85);
		newCourse.setStudent(student1);
		em.persist(newCourse);

        Courses newCourse1 = new Courses();
        newCourse1.setCourse_name("English");
		newCourse1.setGrade(92);
		newCourse1.setStudent(student1);
		em.persist(newCourse1);

		em.getTransaction().commit();
	}


}
