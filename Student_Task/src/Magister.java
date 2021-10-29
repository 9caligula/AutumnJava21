public class Magister extends Student {

    private String baccalaureate;

    public Magister(String name, String surname, String patronymic) {
        super(name, surname, patronymic);
    }

    public Magister(String name, String surname, String patronymic, String ticketNumber) {
        super(name, surname, patronymic, ticketNumber);
    }

    public Magister(String name, String surname, String patronymic, String ticketNumber, String directionOfStudy) {
        super(name, surname, patronymic, ticketNumber, directionOfStudy);
    }

    public Magister(String name, String surname, String patronymic, String ticketNumber, String directionOfStudy, String baccalaureate){
        this(name, surname, patronymic, ticketNumber, directionOfStudy);
        this.baccalaureate = baccalaureate;
    }

    @Override
    public String toString() {
        return super.toString() + (this.baccalaureate != null ? ", " + this.baccalaureate : "");
    }
}