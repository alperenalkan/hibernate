package com.tpe.HibernateInstruction.hb01.annotations;

public class ServiceController {
    private StudentService studentService;

    public ServiceController(StudentService studentService) {
        this.studentService = studentService;
    }
    public void addStudent(Student01 student) {
        studentService.saveStudent(student);
        System.out.println("Student added: "+student);
    }
    public void updateStudent(Student01 student) {
        studentService.updateStudent(student);
        System.out.println("Student updated: "+student);
    }
    public void deleteStudent(Student01 student) {
        studentService.deleteStudent(student);
        System.out.println("Student deleted: "+student);
    }
    public void showAllStudents() {
        studentService.getAllStudents().forEach(System.out::println);
    }
    public void showStudentById(int id) {
        studentService.getStudentById(id);
    }
    public void showStudentByName(String name) {
        studentService.getStudentByName(name);
    }

}
