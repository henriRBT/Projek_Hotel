package model;

public class Tamu {
    private int id;
    private String nama;
    private String email;
    private String no_ktp;
    private String no_telp;

    public Tamu(int id, String nama, String email, String no_ktp, String no_telp) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.no_ktp = no_ktp;
        this.no_telp = no_telp;
    }

    public Tamu(String nama, String email, String no_ktp, String no_telp) {
        this.nama = nama;
        this.email = email;
        this.no_ktp = no_ktp;
        this.no_telp = no_telp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_ktp() {
        return no_ktp;
    }

    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
    
    @Override
    public String toString(){
        return nama;
    }
}
