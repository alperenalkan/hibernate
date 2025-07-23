package com.tpe.HibernateInstruction.hb01.annotations;

import java.util.List;

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student01 student) {
        if (student.getGrade()<0){
            throw new IllegalArgumentException("Grade must be a positive number");
        }
        studentRepository.save(student);
    }
    public Student01 getStudentById(int id) {
        return studentRepository.findById(id);
    }
    public List<Student01> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student01 getStudentByName(String name) {
        return studentRepository.findByName(name);
    }
    public void deleteStudentById(int id) {
        studentRepository.deleteStudentById(id);
    }
    public void deleteStudent(Student01 student) {
        studentRepository.delete(student);
    }
    public void updateStudent(Student01 student) {
        studentRepository.update(student);
    }
}
