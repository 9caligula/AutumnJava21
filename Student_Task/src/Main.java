public class Main {
    public static void main(String[] args) {
        Magister mag = new Magister("Денис", "Лесняк", "Дмитриевич");
        Magister mag1 = new Magister("Иван", "Иванов", "Иванович", "654311");
        Magister mag2 = new Magister("Анна", "Иванова", "Ивановна", "654311",
                "Комп безопасность", "ИВТ");

        Student student = new Student("Павел", "Павлов", "Александрович");


        System.out.println(mag);
        System.out.println(mag1);
        System.out.println(mag2);
        System.out.println(student);
    }
}
