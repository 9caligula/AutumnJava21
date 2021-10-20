public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Сложение: " + calculator.addition(10.5, 2));
        System.out.println("Деление: " + calculator.division(10.5, 2));
        System.out.println("Умножение: " + calculator.multiply(10.5, 2));
        System.out.println("Вычитание: " + calculator.subtraction(10.5, 2));
    }
}