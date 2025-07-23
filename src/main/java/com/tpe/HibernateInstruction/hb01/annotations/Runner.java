package com.tpe.HibernateInstruction.hb01.annotations;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        //katmanli mimari
        StudentRepository studentRepository = new StudentRepository(sessionFactory);
        StudentService studentService = new StudentService(studentRepository);
        ServiceController serviceController = new ServiceController(studentService);

        Student01 student01 = new Student01();
        student01.setId(1005);
        student01.setName("Alice Wonderland");
        student01.setGrade(80);
        serviceController.addStudent(student01);

        serviceController.showAllStudents();
        serviceController.showStudentById(1005);

        //güncelle
        student01.setGrade(70);
        serviceController.updateStudent(student01);

        //sil
        serviceController.deleteStudent(student01);

        sessionFactory.close();




    }

}
