public class MagicMath {
    public static int abs(int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }
    public static int fact(int n) { // рекурсивный метод
        if(n == 1 || n == 0) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }
    public static int pow(int n, int e) {
        var result = 1;
        for (int i = 0; i < e; i++) {
            result *= n;
        }
        return result;
    }
}