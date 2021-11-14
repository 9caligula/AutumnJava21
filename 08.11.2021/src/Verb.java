public class Verb {
    private final String infinitive;
    private final String pastSimple;
    private final String pastParticiple;
    private final String rusName;

    public Verb(String infinitive, String pastSimple, String pastParticiple, String rusName) {
        this.infinitive = infinitive;
        this.pastSimple = pastSimple;
        this.pastParticiple = pastParticiple;
        this.rusName = rusName;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public String getPastSimple() {
        return pastSimple;
    }

    public String getPastParticiple() {
        return pastParticiple;
    }

    public String getRusName() {
        return rusName;
    }

    @Override
    public String toString() {
        return  "[" +
                "infinitive = " + String.format("%-15s", infinitive) +
                "pastSimple = " + String.format("%-16s", pastSimple) +
                "pastParticiple = " + String.format("%-18s", pastParticiple) +
                "rusName = " + rusName + "]";
    }
}