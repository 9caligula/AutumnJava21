import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Verb> list = VerbsService.getInstance.getList();

        VerbsService.getInstance.shuffle(); // перемешиваю коллекцию
        System.out.println("Все слова: ");
        list.forEach(System.out::println);
        System.out.println();

        TreeSet<Verb> sortedVerbs = new TreeSet<>(Comparator.comparing(Verb::getRusName).thenComparing(Verb::getInfinitive));
        sortedVerbs.addAll(list);

        Verb verbWithC = sortedVerbs.stream().filter((item) -> item.getRusName().startsWith("с")).findFirst().get();
        Verb verbWithT = sortedVerbs.stream().filter((item) -> item.getRusName().startsWith("т")).findFirst().get();
        // также ищу первое слово на у, чтобы подставить данный verb в subset
        Verb verbWithY = sortedVerbs.stream().filter((item) -> item.getRusName().startsWith("у")).findFirst().get();

        System.out.println("Первое слово на с: \n" + verbWithC + "\n");
        System.out.println("Первое слово на т: \n" + verbWithT + "\n");

        NavigableSet<Verb> navigableSet = new TreeSet<>(Comparator.comparing(Verb::getRusName)){};
        navigableSet.addAll(sortedVerbs);

        System.out.println("Подмножество всех слов на с: ");
        navigableSet.subSet(verbWithC, verbWithT).forEach(System.out::println);
        System.out.println();

        System.out.println("Подмножество всех слов на т: ");
        navigableSet.subSet(verbWithT, verbWithY).forEach(System.out::println);
    }
}