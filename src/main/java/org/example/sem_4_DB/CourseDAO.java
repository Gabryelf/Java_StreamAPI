package org.example.sem_4_DB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CourseDAO {
    private static SessionFactory sessionFactory;


    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        Course course1 = new Course();
        course1.setTitle("Java");
        course1.setDuration(30);
        int courseId = saveCourse(course1);

        Course retrievedCourse = getCourse(courseId);
        System.out.println("Title: " + retrievedCourse.getTitle() + ", Duration: " + retrievedCourse.getDuration());

        retrievedCourse.setDuration(45);
        updateCourse(retrievedCourse);

        Course updatedCourse = getCourse(courseId);
        System.out.println("Updated duration: " + updatedCourse.getDuration());


        deleteCourse(updatedCourse);
    }

    public static int saveCourse(Course course) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(course);
        transaction.commit();
        session.close();
        return id;
    }

    public static Course getCourse(int id) {
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }

    public static void updateCourse(Course course) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(course);
        transaction.commit();
        session.close();
    }

    public static void deleteCourse(Course course) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(course);
        transaction.commit();
        session.close();
    }


}
