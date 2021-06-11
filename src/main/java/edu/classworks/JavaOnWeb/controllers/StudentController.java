package edu.classworks.JavaOnWeb.controllers;

import edu.classworks.JavaOnWeb.dao.StudentDAOHibernate;
import edu.classworks.JavaOnWeb.enums.AssignmentStatus;
import edu.classworks.JavaOnWeb.enums.BedType;
import edu.classworks.JavaOnWeb.models.Bed;
import edu.classworks.JavaOnWeb.models.BedAssignment;
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

    public Student getById(long id) throws SQLException {
        return daoHibernate.getStudent(id);
    }

    public int create(String firstName, String lastName, String gender, String email, String year, String className) throws SQLException {
        Student student = new Student(firstName, lastName, gender, email, year, className);

        Bed bed = new Bed("001", BedType.NORMAL);
        StudentDAOHibernate studentDAOHibernate = new StudentDAOHibernate();
        long bedId = studentDAOHibernate.saveBed(bed);
        bed.setId(bedId);

        BedAssignment bedAssignment;

        long studentId = daoHibernate.saveStudent(student);
        student.setId(studentId);

        bedAssignment = new BedAssignment(student, bed, AssignmentStatus.ASSIGNED , "anselme", "No comment");

        studentDAOHibernate.saveBedAssignment(bedAssignment);


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
