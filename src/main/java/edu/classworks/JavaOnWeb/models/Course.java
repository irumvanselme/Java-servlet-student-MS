package edu.classworks.JavaOnWeb.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull
    @Column
    String courseName;

    @NotNull
    @Column
    int hoursInAWeek;

    @NotNull
    @Column
    int maximumMarks;

    public Course() {
    }

    public Course(String courseName, int hoursInAWeek, int maximumMarks) {
        this.courseName = courseName;
        this.hoursInAWeek = hoursInAWeek;
        this.maximumMarks = maximumMarks;
    }

    public Course(int id, String courseName, int hoursInAWeek, int maximumMarks) {
        this.id = id;
        this.courseName = courseName;
        this.hoursInAWeek = hoursInAWeek;
        this.maximumMarks = maximumMarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getHoursInAWeek() {
        return hoursInAWeek;
    }

    public void setHoursInAWeek(int hoursInAWeek) {
        this.hoursInAWeek = hoursInAWeek;
    }

    public int getMaximumMarks() {
        return maximumMarks;
    }

    public void setMaximumMarks(int maximumMarks) {
        this.maximumMarks = maximumMarks;
    }
}
