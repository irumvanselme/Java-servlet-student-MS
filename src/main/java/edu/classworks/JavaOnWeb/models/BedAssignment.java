package edu.classworks.JavaOnWeb.models;

import edu.classworks.JavaOnWeb.enums.AssignmentStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bed_assignment")
public class BedAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Bed bed;

    @Column
    private String assignedOn;

    @Column
    private String releasedOn;

    @Enumerated(EnumType.STRING)
    private AssignmentStatus assignmentStatus;

    @Column
    private String assignedBy;

    @Column
    private String comment;

    public BedAssignment() {
    }

    public BedAssignment(Student student, Bed bed, AssignmentStatus assignmentStatus, String assignedBy, String comment) {
        this.student = student;
        this.bed = bed;
        this.assignedOn = LocalDateTime.now().toString();
        this.assignmentStatus = assignmentStatus;
        this.releasedOn = null;
        this.assignedBy = assignedBy;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public String getAssignedOn() {
        return assignedOn;
    }

    public void setAssignedOn(String assignedOn) {
        this.assignedOn = assignedOn;
    }

    public String getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(String releasedOn) {
        this.releasedOn = releasedOn;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public AssignmentStatus getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(AssignmentStatus assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
