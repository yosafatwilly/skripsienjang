package id.ac.usd.skripsienjang.model;

import java.util.TreeMap;

public class Local implements Comparable<Local>{

    private String idLocal;

    private String idGlobal;

    private String namaBarang;

    private Integer count;

    public Local() {

    }

    public Local(String idLocal, String idGlobal, String namaBarang, Integer count) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
        this.namaBarang = namaBarang;
        this.count = count;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getIdGlobal() {
        return idGlobal;
    }

    public void setIdGlobal(String idGlobal) {
        this.idGlobal = idGlobal;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Local{" +
                "idLocal='" + idLocal + '\'' +
                ", idGlobal='"+idGlobal + '\'' +
                ", namaBarang='" + namaBarang + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(Local o) {
        Local a = (Local) o;
        return a.idGlobal.compareTo(o.idGlobal);
    }
}
