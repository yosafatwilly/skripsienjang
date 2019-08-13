package id.ac.usd.skripsienjang.model;

import java.util.ArrayList;
import java.util.List;

public class GlobalItem {
    private String idGlobal;
    private String namaBarang;
    private int freq;
    private List<Path> listPath = new ArrayList<>();
    
    public GlobalItem() {
    }

    public GlobalItem(String namaBarang, int freq) {
        this.namaBarang = namaBarang;
        this.freq = freq;
    }

    public GlobalItem(String idGlobal, String namaBarang, int freq) {
        this.idGlobal = idGlobal;
        this.namaBarang = namaBarang;
        this.freq = freq;
    }
    
    

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public List<Path> getListPath() {
        return listPath;
    }

    public void setListPath(List<Path> listPath) {
        this.listPath = listPath;
    }

    public String getIdGlobal() {
        return idGlobal;
    }

    public void setIdGlobal(String idGlobal) {
        this.idGlobal = idGlobal;
    }

    @Override
    public String toString() {
        return "GlobalItem{" + "idGlobal=" + idGlobal + ", namaBarang=" + namaBarang + ", freq=" + freq + ", listPath=" + listPath + '}';
    }

//    @Override
//    public String toString() {
//        return  idGlobal;
//    }

}
