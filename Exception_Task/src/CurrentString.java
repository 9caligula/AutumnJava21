public class CurrentString implements Checkable {

    private String str;

    public CurrentString(String str) {
        this.str = str;
    }

    @Override
    public boolean checkString(){
        if (!str.matches("[a-zA-Z]+")){
            throw new CorrectStringException("Некорректное значение строки, должны быть только буквы латинского алфавита!");
        } else {
            return true;
        }
    }
}
