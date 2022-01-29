import java.util.EnumMap;
import java.util.concurrent.Callable;

public enum SeasonService {

    INSTANCE;

    private EnumMap<Month, Callable<Season>> enumMap;


    SeasonService() {
        enumMap = new EnumMap<>(Month.class);

        for (Month m: Month.values()){
            if (m.ordinal() >= 9){
                enumMap.put(m, ()-> Season.Autumn);
            } else if (m.ordinal() >= 6){
                enumMap.put(m, ()-> Season.Summer);
            } else if (m.ordinal() >= 3){
                enumMap.put(m, ()-> Season.Spring);
            } else {
                enumMap.put(m, ()-> Season.Winter);
            }
        }
    }
    public Season getSeason(Month month) throws Exception {
        return enumMap.get(month).call();
    }

    public void printSeason(Month month) throws Exception {
        System.out.printf("Время года: %s, Описание: %s \n", getSeason(month), getSeason(month).getDecription());
    }
}