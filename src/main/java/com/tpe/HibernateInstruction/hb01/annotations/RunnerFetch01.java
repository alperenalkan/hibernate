package com.tpe.HibernateInstruction.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {
        Configuration config = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction(); //Fetch yapildiginda buna ihtiyac yok.

        //Bilgi cekmek icin genel anlamda 3 yol var...
        //1 - get() metodu - TAVISYE EDILEN
        //2 - HQL (Hibernate Query Language)
        //3 - SQL - TAVSIYE EDILMEYEN

        //****************** get() metodu ******************
        //Parametreler:
        //1- Ne getirilecek?
        //2- PK'si ne?
        /*
        Student01 std1 = session.get(Student01.class, 1001);
        System.out.println(std1);

        Student01 std2 = session.get(Student01.class, 1002);
        System.out.println(std2);
        */

        //****************** SQL query ******************
        /*
        String sql = "SELECT * FROM t_student01";
        List<Object[]> resultList1 = session.createNativeQuery(sql).getResultList();
        for (Object[] oa : resultList1){
            System.out.println(Arrays.toString(oa));
        }
        */
        //! Asagidaki yol SQL kullanarak yapilabilir, ancak beklenen kulanim degildir.
        //* Hibernate 5.2'den itibaren asagidaki yontem mevcut, ancak yine de tavisye edilmez.
        /*
        String sql = "SELECT * FROM t_student01";
        List<Student01> resultList1 = session.createNativeQuery(sql, Student01.class).getResultList();
        for (Student01 std : resultList1){
            System.out.println(std);
        }
        */

        //****************** HQL query ******************
        /*
        String hql = "FROM Student01";
        List<Student01> resultList2 = session.createQuery(hql, Student01.class).getResultList();
        for (Student01 std : resultList2){
            System.out.println(std);
        }
        */

        //TASK: SQL kullanarak ismi "Bob Smith" olan ogrenciyi getirelim

      /*  String sql = "SELECT * FROM t_student01 WHERE std_name = 'Bob Smith'";
        //HQL olsaydi: FROM Student01 WHERE name = 'Bob Smith'
        Object[] oa = (Object[]) session.createNativeQuery(sql).uniqueResult();
        System.out.println(Arrays.toString(oa));*/

        //TASK: Yukaridaki islemi HQL ile yapin.
        String hql = "FROM Student01 WHERE name = 'Bob Smith'";
        Student01 std = session.createQuery(hql, Student01.class).uniqueResult();
        System.out.println(std.toString());




        tx.commit();
        session.close();
        sf.close();
    }
}