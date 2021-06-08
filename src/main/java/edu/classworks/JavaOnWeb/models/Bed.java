package edu.classworks.JavaOnWeb.models;

import edu.classworks.JavaOnWeb.enums.BedType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "beds")
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private BedType type;

    @ManyToMany(mappedBy = "beds", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();

    public Bed() {
    }

    public Bed(String number, BedType type) {
        this.number = number;
        this.type = type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BedType getType() {
        return type;
    }

    public void setType(BedType type) {
        this.type = type;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
