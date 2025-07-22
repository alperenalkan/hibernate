package com.tpe.HibernateInstruction.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {
        Student01 std1 = new Student01();
        std1.setId(1001);
        std1.setName("Bob Smith");
        std1.setGrade(90);

        Student01 std2 = new Student01();
        std2.setId(1002);
        std2.setName("Mike Olsen");
        std2.setGrade(85);

        Student01 std3 = new Student01();
        std3.setId(1003);
        std3.setName("Jack Jackson");
        std3.setGrade(85);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student01.class);

        SessionFactory sf = configuration.buildSessionFactory(); //!Köprü database ile entity baglar. <session-factory> hibernate.xml icine bakinca görüyorsun.

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //! Hibernate tam olarak burayi kolaylastirdi...
        //JDBC'de olsak Connection ve PreparedStatement olusturulur
        //String query yazilir
        //String sql = "INSERT INTO t_student01 VALUES()";
        //prst.set metodlari ile bilgier setlenir
        //prst.execute() diyerek query execute edilir.
        //Yaklasik 10-12 satir kod yazilir.

        //Hibernate'te ise:
        session.save(std1);
        session.save(std2);
        session.save(std3);
        //Unique key violation almamak icin, ya her save isleminde bir oncekini yoruma alacaktik,
        //ki bu, guzel bir yol degil, ya da hbm2ddl.auto property'si create olarak belirlenmeli.
        //Bu sayede uygulama her calistiginda tablo droplanacagindan, gonul rahatligi ile save islemleri
        //yapilabilir.


        tx.commit(); //* Yapilan islemler tamam, DB'ye git
        session.close(); //* Su anlik isim bitti, sonra geri acabilirim
        sf.close(); //* Uygulama ile isim bitti

    }
}
