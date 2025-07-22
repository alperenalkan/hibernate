package com.tpe.HibernateInstruction.hb01.annotations;

import javax.persistence.*;

@Entity //* @Entity ile isaretlenen class'lar, veritabaninda bir tabloya karsilik gelecek.
@Table(name = "t_student01") //* Eger olusturulacak olan tablonun ismini degistireceksek @Table ve name kullanabiliriz.
//! Eger tablo ismi degistirilmezse, class isminin kucuk harfli hali tablo ismi olacaktir. (Mesela student01)
public class Student01 {
    @Id //* Primary key icin @Id kullanilir. Kullanildigi satirin altindaki en yakin field PK olur.
    @Column(name = "std_id") //* @Column anotasyonu sutunu modifiye etmek icin kullanilir.
    private int id;

    @Column(name = "std_name", length = 64, nullable = false, unique = false)
    private String name;

    //@Transient ----> Kod icinde kullanilmak uzere grade field'i bulunur. Ancak DB'de grade isminde bir sutun olusmaz.
    //Bu yontem, eger field hesaplama, ya da gecici olarak data tasima,
    //donusum gibi islemlerde kullanilacaksa son derece mantiklidir.
    private int grade;

    //!@Lob //! Large object demektir, gunumuzde resimler bu sekilde saklanmaz.
    //Genelde uzun yazilar icin String fieldin uzerinde gorulur. Ayrica
    //String field icin @Column icerisinde columnDefinition parametresi kullanilir.
    //private byte[] image;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student01{" +
                "grade=" + grade +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}