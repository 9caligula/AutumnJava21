public class Student {
    protected String name;
    protected String surname;
    protected String patronymic;
    protected String ticketNumber;
    protected String directionOfStudy;

    public Student(String name, String surname, String patronymic){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Student(String name, String surname, String patronymic, String ticketNumber){
        this(name, surname, patronymic);
        this.ticketNumber = ticketNumber;
    }

    public Student(String name, String surname, String patronymic, String ticketNumber, String directionOfStudy) {
        this(name, surname, patronymic, ticketNumber);
        this.directionOfStudy = directionOfStudy;
    }

    @Override
    public String toString() {
        return "Student: " + (this.name != null ? this.name : "") +
                (this.surname != null ? ", " + this.surname : "") +
                (this.patronymic != null ? ", " + this.patronymic : "") +
                (this.ticketNumber != null ? ", " + this.ticketNumber: "") +
                (this.directionOfStudy != null ? ", " + this.directionOfStudy : "");
    }
}