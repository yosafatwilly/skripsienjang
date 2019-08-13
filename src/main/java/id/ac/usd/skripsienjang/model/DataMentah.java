package id.ac.usd.skripsienjang.model;

public class DataMentah {
    private String noStruk;
    private String namaBarang;
    private String tanggal;

    public DataMentah() {
    }

    public DataMentah(String noStruk, String namaBarang, String tanggal) {
        this.noStruk = noStruk;
        this.namaBarang = namaBarang;
        this.tanggal = tanggal;
    }

    public String getNoStruk() {
        return noStruk;
    }

    public void setNoStruk(String noStruk) {
        this.noStruk = noStruk;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "DataMentah{" +
                "noStruk='" + noStruk + '\'' +
                ", namaBarang='" + namaBarang + '\'' +
                ", tanggal='" + tanggal + '\'' +
                '}';
    }
}