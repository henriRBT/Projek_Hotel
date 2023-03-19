package exception;

import java.lang.Exception;

public class NumberFormatException extends Exception{
    public String message(){
        return "Atribut Tahun Pembuatan atau Kapasitas Penumpang \n atau Daya Angkut harus diisi dengan ANGKA!";
    }
    
}
