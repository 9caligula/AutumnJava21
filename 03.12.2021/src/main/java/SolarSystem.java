import java.util.List;

public class SolarSystem {
    private List<Planet> planets;
    private Star star;

    public SolarSystem(Star star, List<Planet> planets) {
        this.planets = planets;
        this.star = star;
    }

    @Override
    public String toString() {
        return "SolarSystem{" +
                "planets=" + planets.toString() +
                ", star=" + star +
                '}';
    }
}
