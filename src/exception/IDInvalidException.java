package exception;

public class IDInvalidException extends Exception{
    public String message(){
        return "ID harus berukuran 5-8 digit!";
    }
}
