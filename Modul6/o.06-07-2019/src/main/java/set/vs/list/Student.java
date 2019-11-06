package set.vs.list;

public class Student {

    private String nume;

    public Student(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString(){
        return nume;
    }

    @Override
    public boolean equals(Object obj){
        if (obj != null && obj instanceof Student){
            return nume.equals(((Student)obj).nume);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return nume.hashCode();
    }
}
