package id.ac.usd.skripsienjang.model;

import java.util.List;

public class LocalMining {
    private String idGlobalTambang;
    private List<Local> localList;

    public LocalMining(String idGlobalTambang, List<Local> localList) {
        this.idGlobalTambang = idGlobalTambang;
        this.localList = localList;
    }

    public String getIdGlobalTambang() {
        return idGlobalTambang;
    }

    public void setIdGlobalTambang(String idGlobalTambang) {
        this.idGlobalTambang = idGlobalTambang;
    }

    public List<Local> getLocalList() {
        return localList;
    }

    public void setLocalList(List<Local> localList) {
        this.localList = localList;
    }

    @Override
    public String toString() {
        return "LocalMining{" +
                "idGlobalTambang='" + idGlobalTambang + '\'' +
                ", localList=" + localList +
                '}';
    }
}
