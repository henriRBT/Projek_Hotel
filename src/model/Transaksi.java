package model;

public class Transaksi {
    private int id;
    private String metode_pembayaran;
    private String status;
    private Pegawai pegawai;
    private Reservasi reservasi;

    public Transaksi(int id, String metode_pembayaran, String status, Pegawai pegawai, Reservasi reservasi) {
        this.id = id;
        this.metode_pembayaran = metode_pembayaran;
        this.status = status;
        this.pegawai = pegawai;
        this.reservasi = reservasi;
    }

    public Transaksi(String metode_pembayaran, String status, Pegawai pegawai, Reservasi reservasi) {
        this.metode_pembayaran = metode_pembayaran;
        this.status = status;
        this.pegawai = pegawai;
        this.reservasi = reservasi;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reservasi getReservasi() {
        return reservasi;
    }

    public void setReservasi(Reservasi reservasi) {
        this.reservasi = reservasi;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }
}
