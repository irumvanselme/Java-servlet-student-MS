package edu.classworks.JavaOnWeb.dao;

import java.util.List;

import edu.classworks.JavaOnWeb.models.Bed;
import edu.classworks.JavaOnWeb.models.BedAssignment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.classworks.JavaOnWeb.models.Student;
import edu.classworks.JavaOnWeb.utils.HibernateUtil;

public class StudentDAOHibernate {
    /**
     * Save Student
     *
     * @param student a student to be inserted into the database
     */
    public long saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            long id = (long) session.save(student);
            // commit transaction
            transaction.commit();
            return id;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * Update Student
     *
     * @param student a student
     */
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Student
     *
     * @param id a student id to be be deleted
     */
    public void deleteStudent(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a student object
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("student is deleted");
            }
            // commit transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Student By ID
     *
     * @param id a student id
     * @return a student with a given id
     */
    public Student getStudent(long id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object
            student = session.get(Student.class, id);
            // commit transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }

    /**
     * Get all Students
     *
     * @return listOfStudent a list of students
     */

    @SuppressWarnings("unchecked")
    public List<Student> getAllStudent() {
        Transaction transaction = null;
        List<Student> listOfStudent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an student object
            listOfStudent = session.createQuery("from Student").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfStudent;
    }

    public long  saveBed(Bed bed) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            long id = (long) session.save(bed);
            transaction.commit();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return 0;
    }
    public long  saveBedAssignment(BedAssignment bedAssignment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            long id = (long) session.save(bedAssignment);
            transaction.commit();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return 0;
    }
}