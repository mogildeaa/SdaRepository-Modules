package hibernate.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "teacher")
public class Teacher {

    // mappez valorile
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "teacher_gen")
    @SequenceGenerator(name = "teacher_gen",
            sequenceName = "teacher_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "hire_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hire_date;

    @Column(name = "salary")
    private Double salary;

    // Vaaloarea atributului mappedBy este numele exact al membrului de clasa al partenerului
    // de relatie
    /*Ex:
    *  @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;*/
    @OneToMany(mappedBy = "teacher")//mappedBy numele dat in relatia din Course la relatie
    // cu alte cuvinte facem o relatie in oglinda fata de cea din Course



    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
