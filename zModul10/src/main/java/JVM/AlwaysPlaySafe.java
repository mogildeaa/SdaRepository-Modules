package JVM;

import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalTime;

public class AlwaysPlaySafe {

    private static Unsafe _unsafe;

    static {
        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            _unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            System.err.println("No field theUnsafe exists." + e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println("Illegal access to theUnsafe." + e.getMessage());
        }
    }

    private static long addressOf(Object obj) {
        Object[] array = new Object[]{obj};

        long baseOffset = _unsafe.arrayBaseOffset(Object[].class);
        int addressSize = _unsafe.addressSize();
        long objectAddress;

        switch (addressSize) {
            case 4:
                objectAddress = _unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = _unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("Unsupported address size: " + addressSize);
        }

        return objectAddress;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        BufferedWriter w = new BufferedWriter(new FileWriter("addrs.csv"));
        long start = LocalTime.now().toNanoOfDay();
        for (int i = 0; i < 3200000; ++i) {
            Object mine = new GCMe();
            long address = addressOf(mine);
            w.write(String.valueOf(address) + "\n");
        }
        long end = LocalTime.now().toNanoOfDay();
        System.out.println(end - start);
        w.close();
    }

    static class GCMe {
        long a;
        long aa;
        long aaa;
        long aaaa;
        long aaaaa;
        long aaaaaa;
        long aaaaaaa;
        long aaaaaaaa;
        long aaaaaaaaa;
        long aaaaaaaaaa;
        long aaaaaaaaaaa;
        long aaaaaaaaaaaa;
        long aaaaaaaaaaaaa;
        long aaaaaaaaaaaaaa;
        long aaaaaaaaaaaaaaa;
        long aaaaaaaaaaaaaaaa;
    }
}
