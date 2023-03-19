package model;

public class Pegawai {
    private String id;
    private String nama;
    private String role;
    private String jenis_kelamin;
    private String no_telp;

    public Pegawai(String id, String nama, String role, String jenis_kelamin, String no_telp) {
        this.id = id;
        this.nama = nama;
        this.role = role;
        this.jenis_kelamin = jenis_kelamin;
        this.no_telp = no_telp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
    
    public String showDataPegawai(){
        return this.id + " | " + this.nama + " | " + this.role + " | " + 
                this.jenis_kelamin + " | " + this.no_telp;
    } 
    
    @Override
    public String toString(){
        return nama;
    }
}
