package model;

public class Reservasi {
    private int id;
    private String tgl_checkIn;
    private int durasi;
    private int jumlah_tamu;
    private float total_harga;
    private String tgl_reservasi;
    private Pegawai pegawai;
    private Tamu tamu;

    public Reservasi(int id, String tgl_checkIn, int durasi, int jumlah_tamu, float total_harga, String tgl_reservasi, Pegawai pegawai, Tamu tamu) {
        this.id = id;
        this.tgl_checkIn = tgl_checkIn;
        this.durasi = durasi;
        this.jumlah_tamu = jumlah_tamu;
        this.total_harga = total_harga;
        this.tgl_reservasi = tgl_reservasi;
        this.pegawai = pegawai;
        this.tamu = tamu;
    }

    public Reservasi(String tgl_checkIn, int durasi, int jumlah_tamu, float total_harga, String tgl_reservasi, Pegawai pegawai, Tamu tamu) {
        this.tgl_checkIn = tgl_checkIn;
        this.durasi = durasi;
        this.jumlah_tamu = jumlah_tamu;
        this.total_harga = total_harga;
        this.tgl_reservasi = tgl_reservasi;
        this.pegawai = pegawai;
        this.tamu = tamu;
    } 

    public Reservasi(int id, String tgl_checkIn, int durasi, int jumlah_tamu, float total_harga, String tgl_reservasi) {
        this.id = id;
        this.tgl_checkIn = tgl_checkIn;
        this.durasi = durasi;
        this.jumlah_tamu = jumlah_tamu;
        this.total_harga = total_harga;
        this.tgl_reservasi = tgl_reservasi;
    }

    public float getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(float total_harga) {
        this.total_harga = total_harga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getTgl_checkIn() {
        return tgl_checkIn;
    }

    public void setTgl_checkIn(String tgl_checkIn) {
        this.tgl_checkIn = tgl_checkIn;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public int getJumlah_tamu() {
        return jumlah_tamu;
    }

    public void setJumlah_tamu(int jumlah_tamu) {
        this.jumlah_tamu = jumlah_tamu;
    }

    public String getTgl_reservasi() {
        return tgl_reservasi;
    }

    public void setTgl_reservasi(String tgl_reservasi) {
        this.tgl_reservasi = tgl_reservasi;
    }

    public Tamu getTamu() {
        return tamu;
    }

    public void setTamu(Tamu tamu) {
        this.tamu = tamu;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }
    
    @Override
    public String toString(){
        return tgl_checkIn;
    }
}
