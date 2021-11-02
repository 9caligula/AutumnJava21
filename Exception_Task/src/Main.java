import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CurrentString str = new CurrentString(in.nextLine());
        if (str.checkString()) {
            System.out.println("Строка имеет верный формат ");
        }
    }
}
