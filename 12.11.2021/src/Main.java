public class Main {
    public static void main(String[] args) {
        Thread threadEgg = new Thread(new ThreadEgg());
        Thread threadChicken = new Thread(new ThreadChicken());
        threadChicken.start();
        threadEgg.start();
    }
}