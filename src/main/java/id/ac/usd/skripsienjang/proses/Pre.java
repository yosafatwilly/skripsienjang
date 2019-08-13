package id.ac.usd.skripsienjang.proses;

import id.ac.usd.skripsienjang.excel.DB;
import id.ac.usd.skripsienjang.model.DataMentah;
import id.ac.usd.skripsienjang.model.GlobalItem;
import id.ac.usd.skripsienjang.model.Tree;
import id.ac.usd.skripsienjang.util.Util;
import id.ac.usd.skripsienjang.tree.Node;

import java.util.*;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toMap;

public class Pre extends DB {

    public List<DataMentah> dataMentahs;
    public TreeMap<String, ArrayList<String>> mapStruks;
    public HashMap<String, Integer> preItemSet;
    public List<GlobalItem> globalItems;
    public TreeMap<String, ArrayList<GlobalItem>> itemSets;

    public Node root;

    public Pre(Integer minSupport) {
        this.dataMentahs = bacaData;
        this.mapStruks = new TreeMap<>();
        this.preItemSet = new HashMap<>();
        this.globalItems = new ArrayList<>();
        this.itemSets = new TreeMap<>();
        for (DataMentah dataMentah : dataMentahs) {
            String noStruk = dataMentah.getNoStruk();
            String namaBarang = dataMentah.getNamaBarang();
            if (noStruk != null) {
                if (!mapStruks.containsKey(noStruk)) {
                    ArrayList<String> barangs = new ArrayList<>();
                    barangs.add(dataMentah.getNamaBarang());
                    mapStruks.put(dataMentah.getNoStruk(), barangs);
                } else {
                    mapStruks.get(noStruk).add(dataMentah.getNamaBarang());
                }
                //FREQ
                if (!preItemSet.containsKey(namaBarang)) {
                    preItemSet.put(namaBarang, 1);
                } else {
                    int temp = preItemSet.get(namaBarang);
                    preItemSet.put(namaBarang, temp + 1);
                }
            }
        }
        globalTable(minSupport);
        itemSets();
    }

//    public void globalTable(int minSupport) {
//        preItemSet = Util.sortDesc(preItemSet);
//        int i = 1;
//        for (Map.Entry<String, Integer> entry : preItemSet.entrySet()) {
//            if (entry.getValue() >= minSupport) {
//                globalItems.add(new GlobalItem("G"+i,entry.getKey(), entry.getValue()));
//                i++;
//            }
//        }
//    }

    public void globalTable(int minSupport) {
        preItemSet = Util.sortDesc(preItemSet);
        int i = 1;
        String[] abjad = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (Map.Entry<String, Integer> entry : preItemSet.entrySet()) {
            if (entry.getValue() >= minSupport) {
                globalItems.add(new GlobalItem(abjad[i-1],entry.getKey(), entry.getValue()));
                i++;
            }
        }
    }

    public void itemSets() {
        for (Map.Entry<String, ArrayList<String>> entry : mapStruks.entrySet()) {
            for (int i = 0; i < globalItems.size(); i++) {
                if (entry.getValue().contains(globalItems.get(i).getNamaBarang())) {
                    if (!itemSets.containsKey(entry.getKey())) {
                        ArrayList<GlobalItem> idGlobals = new ArrayList<>();
                        idGlobals.add(globalItems.get(i));
                        itemSets.put(entry.getKey(), idGlobals);
                    } else {
                        itemSets.get(entry.getKey()).add(globalItems.get(i));
                    }
                }
            }
        }
        for (Map.Entry<String, ArrayList<GlobalItem>> entry : itemSets.entrySet()) {
            ArrayList<GlobalItem> sorted = sorting(entry.getValue());
            itemSets.put(entry.getKey(), sorted);
        }
    }
    
    public ArrayList<GlobalItem> sorting(ArrayList<GlobalItem> itemSet) {
        int n = itemSet.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (itemSet.get(j).getFreq() < itemSet.get(j + 1).getFreq()) {
                    // swap arr[j+1] and arr[i] 
                    GlobalItem temp = itemSet.get(j);
                    itemSet.add(j, itemSet.get(j + 1));
                    itemSet.remove(j + 1);
                    itemSet.add(j + 1, temp);
                    itemSet.remove(j + 1 + 1);

                }
            }
        }
        return itemSet;
    }
}
