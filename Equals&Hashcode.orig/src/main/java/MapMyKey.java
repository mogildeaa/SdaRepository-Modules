import java.util.HashMap;
import java.util.Map;

public class MapMyKey {

    public static void main(String[] args) {

        Map<MyKey, String> map = new HashMap<>();

        MyKey key1 = new MyKey();
        key1.x = 1;
        key1.s = "aaa";

        MyKey key2 = new MyKey();
        key2.x = 2;
        key2.s = "bbb";

        MyKey key3 = new MyKey();
        key3.x = 1;
        key3.s = "aaa";

        map.put(key1, "value aaa");
        map.put(key2, "value bbb");
        map.put(key3, "value ccc");

        System.out.println(map);

    }
}
