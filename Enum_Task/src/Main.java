public class Main {
    public static void main(String[] args) throws Exception {
        SeasonService seasonService = SeasonService.INSTANCE;
        seasonService.printSeason(Month.September);
        seasonService.printSeason(Month.May);
        seasonService.printSeason(Month.February);
        seasonService.printSeason(Month.June);
        seasonService.printSeason(Month.December);
    }
}
