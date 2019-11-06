package hibernate.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "student")
@NamedQueries({
        @NamedQuery(name = "Student.getByLastName",
                query = "select s from Student s where s.last_name " +
                        " = :numeFamilie ")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_gen")
    @SequenceGenerator(name = "student_gen",
            sequenceName = "student_seq",
            allocationSize = 1)
    private Long id;

    @Size(min = 1, max = 30)
    @Column(name = "first_name")
    private String first_name;

    @Size(min = 1, max = 30)
    @Column(name = "last_name")
    private String last_name;

    @Column(name = "birth_date")
    private LocalDate birth_date;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> courses;
}
