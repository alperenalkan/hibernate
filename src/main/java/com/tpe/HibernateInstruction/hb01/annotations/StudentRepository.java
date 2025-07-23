package com.tpe.HibernateInstruction.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class StudentRepository {
    private SessionFactory sessionFactory;

    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Student01 student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
    }
    public void delete(Student01 student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(student);
        tx.commit();
        session.close();
    }
    public void deleteStudentById(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.get(Student01.class, id));
        tx.commit();
        session.close();

    }
    public void update(Student01 student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(student);
        tx.commit();
        session.close();
    }

    public Student01 findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student01 student = (Student01) session.get(Student01.class, id);
        tx.commit();
        session.close();
        return student;
    }
    public List<Student01> findAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Student01> list = session.createQuery("FROM Student01", Student01.class).getResultList();
        tx.commit();
        session.close();
        return list;
    }
    public Student01 findByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student01 student = (Student01) session.get(Student01.class, name);
        tx.commit();
        session.close();
        return student;
    }



}
