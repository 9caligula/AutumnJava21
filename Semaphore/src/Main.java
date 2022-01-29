import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        List<Thread> philosophers = new ArrayList<>(){ };
        philosophers.add(new Thread(new Philosopher("Луций Сенека", semaphore)));
        philosophers.add(new Thread(new Philosopher("Сократ", semaphore)));
        philosophers.add(new Thread(new Philosopher("Хайдеггер", semaphore)));
        philosophers.add(new Thread(new Philosopher("Сартр", semaphore)));
        philosophers.add(new Thread(new Philosopher("Декарт", semaphore)));
        philosophers.add(new Thread(new Philosopher("Аристотель", semaphore)));
        philosophers.add(new Thread(new Philosopher("Ницше", semaphore)));
        philosophers.add(new Thread(new Philosopher("Маркс", semaphore)));
        philosophers.add(new Thread(new Philosopher("Кант", semaphore)));
        philosophers.add(new Thread(new Philosopher("Гегель", semaphore)));


        philosophers.forEach(Thread::start);
    }
}
