package exception;

public class PilihanKosongException extends Exception{
    public String message(){
        return "Mobil atau Truk Harus pilih salah satu!";
    }
}
