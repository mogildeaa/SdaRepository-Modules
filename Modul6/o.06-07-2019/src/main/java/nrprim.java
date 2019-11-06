public class nrprim {

    public static void main(String[] args) {
        System.out.println(checkIfPrime(4));
    }

    static boolean checkIfPrime(int nr) {
        boolean isTrue = false;
        int sqrt = (int) Math.sqrt(nr);

        if (nr == 1 || nr == 0) {
            return isTrue;
        }

        for (int i = 2; i <= sqrt; i++) {
            if (nr % i == 0) {
                isTrue = false;
            } else {
                isTrue = true;
            }
        }
            return isTrue;
    }
}
