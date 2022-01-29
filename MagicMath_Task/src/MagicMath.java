/**
 * The MagicMatch class is needed for basic mathematical operations.
 * @author Lesnyak Denis
 * @version 1.0
 */

public class MagicMath {
    /**
     * Method description module of number
     * @return returns n
     */
    public static int abs(int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }
    /**
     * Method description factorial
     * @return returns n
     */
    public static int fact(int n) { // рекурсивный метод
        if(n == 1 || n == 0) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }
    /**
     * Method description raising the power of a number
     * @return returns n
     */
    public static int pow(int n, int e) {
        var result = 1;
        for (int i = 0; i < e; i++) {
            result *= n;
        }
        return result;
    }
}