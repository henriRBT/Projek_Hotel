package exception;

public class InputKosongException extends Exception{
    public String message(){
        return "Field input tidak boleh kosong!";
    }
}
