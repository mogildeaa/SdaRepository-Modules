package hibernate.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
/*Clasa fiind scrisa cu litere mari Hibernate e destul de intelignet
* sa caute tabela cu acelasi nume dar care incepe cu litera mica*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_gen")
    @SequenceGenerator(name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    // Lucrul asta face ca Course sa fie owner pe relatie
    // Acum relatia este unidirectionala
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany (mappedBy = "courses")
    private Set<Student> students;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
