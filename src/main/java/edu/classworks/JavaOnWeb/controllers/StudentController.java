package edu.classworks.JavaOnWeb.controllers;

import edu.classworks.JavaOnWeb.dao.StudentDAOHibernate;
import edu.classworks.JavaOnWeb.models.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    private final StudentDAOHibernate daoHibernate;

    public StudentController() throws SQLException {
        daoHibernate = new StudentDAOHibernate();
    }

    public List<Student> getStudents() throws SQLException {
        return daoHibernate.getAllStudent();
    }

    public Student getById(int id) throws SQLException {
        return daoHibernate.getStudent(id);
    }

    public int create(String firstName, String lastName, String gender, String email, String year, String className) throws SQLException {
        daoHibernate.saveStudent(new Student(firstName, lastName, gender, email, year, className));
        return 1;
    }

    public int update(int id, String firstName, String lastName, String gender, String email, String year, String className) throws SQLException {
        Student student = new Student(firstName, lastName, gender, email, year, className);
        student.setId(id);
        daoHibernate.updateStudent(student);
        return 1;
    }

    public boolean delete(int id) throws SQLException {
        daoHibernate.deleteStudent(id);

        return true;
    }
}
