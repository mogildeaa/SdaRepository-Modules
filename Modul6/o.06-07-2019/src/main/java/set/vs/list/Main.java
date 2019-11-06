package set.vs.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Student> student = new ArrayList<>();

        student.add(new Student("Catalin"));
        student.add(new Student("Maria"));
        student.add(new Student("Ion"));

        System.out.println(student);

        Set<Student> studentSet = new HashSet<>();

        studentSet.add(new Student("Gabriel"));
        studentSet.add(new Student("Gabriel"));
        studentSet.add(new Student("Mihai"));
        studentSet.add(new Student("Viorica"));

        System.out.println(studentSet);

    }
}
