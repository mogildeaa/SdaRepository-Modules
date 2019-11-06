import java.util.Objects;

public class MyKey {

    int x;
    String s;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return x == myKey.x &&
                Objects.equals(s, myKey.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, s);
    }
}
