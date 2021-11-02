public class CorrectStringException extends RuntimeException {
    public CorrectStringException(){}

    public CorrectStringException(String msg){
        super(msg);
    }

    public void voice(){
        System.out.println(getMessage());
    }
}