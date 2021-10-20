public class Calculator implements IMultiplay, IDivision, IAddition, ISubtraction {

    @Override
    public double multiply(double x, double y) {
        return x * y;
    }

    @Override
    public double division(double x, double y) {
        try {
            if (x / y == Double.POSITIVE_INFINITY || x / y == Double.NEGATIVE_INFINITY)
                throw new ArithmeticException();
            else {
                return x / y;
            }
        } catch (ArithmeticException exception) {
            throw new ArithmeticException("Деление на ноль");
        }
    }

    @Override
    public double addition(double x, double y) {
        return x + y;
    }

    @Override
    public double subtraction(double x, double y) {
        return x - y;
    }
}