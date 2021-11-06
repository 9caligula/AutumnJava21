public class Main {
    public static void main(String[] args) {
        MyList<Character> list = new MyList<>();
        list.add('q');
        list.add('w');
        list.add('e');
        list.add('r');
        list.add('t');
        list.add('y');
        list.add('u');
        list.add('i');

        System.out.println(list.isEmpty() ? "Пустой список " : "Список не пустой ");
        System.out.printf("Размер списка = %s\n", list.size());
        System.out.printf("Элемент на 5 позиции = %s\n", list.get(5));
        System.out.println(list);
        list.remove('w');
        System.out.printf("Размер списка после удаления элемента = %s\n", list.size());
        System.out.println(list);

        System.out.println(list.contains('e') ? "Элемент есть в списке " : "Элемента нет в списке ");
    }
}
