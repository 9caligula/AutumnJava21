import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable{

    private String name;
    private Semaphore semaphore;

    public Philosopher(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(getName() + " взял вилку, и теперь он может поесть");
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
            System.out.println(getName() + " поел, теперь он передал вилку следующему");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}