/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.usd.skripsienjang.model;

import java.util.TreeMap;

/**
 *
 * @author P.A.W.E.G
 */
public class GlobalMining {
    private String idGlobal;
    
    public TreeMap<String, Integer> itemSet;

    public GlobalMining() {
    }

    public GlobalMining(String idGlobal, TreeMap<String, Integer> itemSet) {
        this.idGlobal = idGlobal;
        this.itemSet = itemSet;
    }

    public String getIdGlobal() {
        return idGlobal;
    }

    public void setIdGlobal(String idGlobal) {
        this.idGlobal = idGlobal;
    }

    public TreeMap<String, Integer> getItemSet() {
        return itemSet;
    }

    public void setItemSet(TreeMap<String, Integer> itemSet) {
        this.itemSet = itemSet;
    }

    @Override
    public String toString() {
        return "GlobalMining{" + "idGlobal=" + idGlobal + ", itemSet=" + itemSet + '}';
    }
}
