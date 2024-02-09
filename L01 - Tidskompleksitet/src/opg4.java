public class opg4 {
    public static int fibonacci(int n) {
        int result = 0;
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            int[] arrayFib = new int[n+1];
            arrayFib[0] = 0;
            arrayFib[1] = 1;
            arrayFib[2] = 1;
            for (int i = 3; i <= n; i++) {
                arrayFib[i] = arrayFib[i-1] + arrayFib[i-2];
            }
            result = arrayFib[n];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(11));
    }
}
