package edu.classworks.JavaOnWeb.controllers;

import edu.classworks.JavaOnWeb.dao.StudentDAOHibernate;
import edu.classworks.JavaOnWeb.enums.BedType;
import edu.classworks.JavaOnWeb.models.Bed;
import edu.classworks.JavaOnWeb.models.Student;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentController {
    private final StudentDAOHibernate daoHibernate;

    public StudentController() throws SQLException {
        daoHibernate = new StudentDAOHibernate();
    }

    public List<Student> getStudents() throws SQLException {
        return daoHibernate.getAllStudent();
    }

    public Student getById(long id) throws SQLException {
        return daoHibernate.getStudent(id);
    }

    public int create(String firstName, String lastName, String gender, String email, String year, String className) throws SQLException {
        Student student = new Student(firstName, lastName, gender, email, year, className);

        Set<Bed> beds = new HashSet<>();
        Bed bed = new Bed("001", BedType.NORMAL);
        StudentDAOHibernate studentDAOHibernate = new StudentDAOHibernate();
        studentDAOHibernate.saveBed(bed);
        beds.add(bed);

        student.setBeds(beds);
        daoHibernate.saveStudent(student);
        return 1;
    }

    public int update(long id, String firstName, String lastName, String gender, String email, String year, String className) throws SQLException {
        Student student = new Student(firstName, lastName, gender, email, year, className);
        student.setId(id);
        daoHibernate.updateStudent(student);
        return 1;
    }

    public boolean delete(long id) throws SQLException {
        daoHibernate.deleteStudent(id);

        return true;
    }
}
