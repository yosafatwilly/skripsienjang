/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.usd.skripsienjang.model;

import id.ac.usd.skripsienjang.proses.Pre;
import id.ac.usd.skripsienjang.util.Util;

import java.util.*;

/**
 * @author P.A.W.E.G
 */
public class Tree extends Pre {

    public static TreeNode root;

    public List<GlobalMining> globalMinings;
    public List<LocalMining> localMinings;
    public TreeMap<String, TreeNode> treeNodes;

    public Integer minSupport;

    public Tree(Integer minSupport) {
        super(minSupport);
        this.minSupport = minSupport;
        globalMinings = new ArrayList<>();
        localMinings = new ArrayList<>();
        treeNodes = new TreeMap<>();
    }

    public void intializeTree() {
        root = new TreeNode(globalItems.get(0).getIdGlobal());
        TreeNode bantu = root;
        for (int i = 0; i < globalItems.size(); i++) {
            bantu.getChild().add(new TreeNode(globalItems.get(i).getIdGlobal()));
            bantu = bantu.getChild().get(0);

        }
        System.out.println("Root " + root.getIdGlobal());
    }

    public void traversal(TreeNode localRoot) {
        if (localRoot != null) {
            System.out.println();
            System.out.println(" NODE " + localRoot.getIdGlobal());
            for (int j = 0; j < localRoot.getTrack().size(); j++) {
                System.out.print(localRoot.getTrack().get(j).getPath() + " count = " + localRoot.getTrack().get(j).getCount());
                System.out.println();
            }
            for (int i = 0; i < localRoot.getChild().size(); i++) {
                traversal(localRoot.getChild().get(i));
            }
        }
    }

    public void input() {
        for (Map.Entry<String, ArrayList<GlobalItem>> item : itemSets.entrySet()) {
            TreeNode nodeInsert = search(item.getValue().get(0).getIdGlobal());
            insert(item.getValue(), nodeInsert);
        }
    }

    public TreeNode search(String key) {
        TreeNode bantu = root;
        while (bantu != null) {
            if (bantu.getIdGlobal().equals(key)) {
                return bantu;
            } else {
                bantu = bantu.getChild().get(0);
            }
        }
        return null;
    }

    public int searchchlid(TreeNode node, String key) {
        for (int i = 0; i < node.getChild().size(); i++) {
            if (node.getChild().get(i).getIdGlobal().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public void insert(ArrayList<GlobalItem> itemset, TreeNode nodeInsert) {
        TreeNode bantu = nodeInsert;
        String data = Util.arrayToString(itemset);
        for (int i = 0; i < itemset.size(); i++) {
            String key = itemset.get(i).getIdGlobal();
            boolean sudahAda = false;
            if (bantu.getIdGlobal().equals(key)) {
                if (bantu.getTrack().isEmpty()) {
                    bantu.getTrack().add(new Path(data, 1));
                } else {
                    for (int j = 0; j < bantu.getTrack().size(); j++) {
                        if (bantu.getTrack().get(j).getPath().equals(data)) {
                            bantu.getTrack().get(j).setCount(bantu.getTrack().get(j).getCount() + 1);
                            sudahAda = true;
                            break;
                        }
                    }
                    if (sudahAda == false) {
                        bantu.getTrack().add(new Path(data, 1));
                    }
                }
            } else if (searchchlid(bantu, key) != -1) {
                bantu = bantu.getChild().get(searchchlid(bantu, key));
                if (bantu.getTrack().isEmpty()) {
                    bantu.getTrack().add(new Path(data, 1));
                } else {
                    for (int j = 0; j < bantu.getTrack().size(); j++) {
                        if (bantu.getTrack().get(j).getPath().equals(data)) {
                            bantu.getTrack().get(j).setCount(bantu.getTrack().get(j).getCount() + 1);
                            sudahAda = true;
                            break;
                        }
                    }
                    if (sudahAda == false) {
                        bantu.getTrack().add(new Path(data, 1));
                    }
                }
            } else {
                TreeNode baru = new TreeNode(key);
                bantu.getChild().add(baru);
                bantu = baru;
                baru.getTrack().add(new Path(data, 1));
            }
        }
    }

    public void startMining() {
        for (int i = globalItems.size() - 1; i >= 0; i--) {
            minning(root, globalItems.get(i).getIdGlobal());
        }
    }

    public void minning(TreeNode localRoot, String key) {
//        boolean sudahKetemu = false;
        if (localRoot.getIdGlobal().equals(key)) {
            for (int i = 0; i < localRoot.getTrack().size(); i++) {
                String[] item = localRoot.getTrack().get(i).getPath().split(",");
                if (item[item.length - 1].equals(key)) {
                    globalItems.get(getIndex(key)).getListPath().add(new Path(localRoot.getTrack().get(i).getPath(), localRoot.getTrack().get(i).getCount()));
                }
            }
        }
        for (int j = 0; j < localRoot.getChild().size(); j++) {
            minning(localRoot.getChild().get(j), key);
        }
    }

    public int getIndex(String key) {
        for (int i = 0; i < globalItems.size(); i++) {
            if (globalItems.get(i).getIdGlobal().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public void globalMining() {
        for (int j = 0; j < globalItems.size(); j++) {
            TreeMap<String, Integer> itsets = new TreeMap<>();
            GlobalMining globalMining = new GlobalMining();
            for (int i = 0; i < globalItems.get(j).getListPath().size(); i++) {
                String[] gId = globalItems.get(j).getListPath().get(i).getPath().split(",");
                for (String id : gId) {
                    if (!id.equals(globalItems.get(j).getIdGlobal())) {
                        if (!itsets.containsKey(id)) {
                            itsets.put(id, 1);
                        } else {
                            Integer temp = itsets.get(id);
                            itsets.put(id, temp + 1);
                        }
                    }
                }
            }
            globalMining.setIdGlobal(globalItems.get(j).getIdGlobal());
//            itsets.entrySet().removeIf(e -> e.getValue() < minSupport);
            globalMining.setItemSet(itsets);
            globalMinings.add(globalMining);
        }
//        for (GlobalMining name : new ArrayList<GlobalMining>(globalMinings)) {
//            if (name.getItemSet().size() < 1) {
//                globalMinings.remove(name);
//            }
//        }
    }

    public void localMining() {
        for (int i = 0; i < globalMinings.size(); i++) {
            List<Local> localList = new ArrayList<>();
            TreeMap<String, Integer> itsets = globalMinings.get(i).getItemSet();
            itsets.entrySet().removeIf(e -> e.getValue() < minSupport);
            if (itsets.size() >= 1) {
                int index = 1;
                for (Map.Entry<String, Integer> entry : itsets.entrySet()) {
                    Local local = new Local("L" + index, entry.getKey(), globalItems.get(getIndex(entry.getKey())).getNamaBarang(), entry.getValue());
                    localList.add(local);
                    index++;
                }
            }
            localMinings.add(new LocalMining(globalMinings.get(i).getIdGlobal(), localList));

        }
    }


    public void initTreeLocal() {
        for (int i = 0; i < globalItems.size(); i++) {
            TreeNode treeNode = new TreeNode(globalItems.get(i).getIdGlobal());
            treeNodes.put(globalItems.get(i).getIdGlobal(), treeNode);
        }
    }

    public void build() {
        initTreeLocal();
        TreeNode h = new TreeNode("h");
        for (int i = 0; i < globalItems.get(7).getListPath().size(); i++) {
            String[] path = globalItems.get(7).getListPath().get(i).getPath().split(",");
            insertLocal(path, h);
            traversalLocal(h);
        }

    }

    public void traversalLocal(TreeNode localRoot) {
        if (localRoot != null) {
            System.out.println();
            System.out.println(" NODE " + localRoot.getIdGlobal());
            System.out.println(localRoot.getCount());
            for (int i = 0; i < localRoot.getChild().size(); i++) {
                traversal(localRoot.getChild().get(i));
            }
        }
    }

    public void insertLocal(String[] path, TreeNode nodeInsert) {
        TreeNode bantu = nodeInsert;
        int count = 0;
        for (int j = path.length - 1; j >= 0; j--) {

            System.out.println("[[]]" + bantu.getIdGlobal() + " ; " + path[j]);
            if (bantu.getIdGlobal().equals(path[j])) {
                count++;
                System.out.println(bantu.getIdGlobal()+" "+ count);
                //bantu.setCount(bantu.getCount() + 1);
                //System.out.println("Set Count " + bantu.getIdGlobal() + " path " + path[j]);
            } else if (searchchlidLocal(bantu, path[j]) != -1) {
//                bantu = bantu.getChild().get(searchchlidLocal(bantu, path[j]));
//                bantu.setCount(bantu.getCount() + 1);
                //bantu.getChild().get(searchchlid(bantu, path[j])).setCount(2);
                //System.out.println("Set Child Count " + bantu.getIdGlobal() + " path " + path[j]);
                count++;
                System.out.println(bantu.getIdGlobal()+" "+ count);

            } else {
                TreeNode baru = new TreeNode(path[j]);
                bantu.getChild().add(baru);
                bantu = baru;
                //baru.setCount(1);
                count++;
                System.out.println(bantu.getIdGlobal()+" "+ count);
               // System.out.println("New Child Set Count " + bantu.getIdGlobal() + " path " + path[j]);
            }
        }


//        for (int i = 0; i < itemset.size(); i++) {
//            String key = itemset.get(i).getIdGlobal();
//            boolean sudahAda = false;
//            if (bantu.getIdGlobal().equals(key)) {
//                if (bantu.getTrack().isEmpty()) {
//                    bantu.getTrack().add(new Path(data, 1));
//                } else {
//                    for (int j = 0; j < bantu.getTrack().size(); j++) {
//                        if (bantu.getTrack().get(j).getPath().equals(data)) {
//                            bantu.getTrack().get(j).setCount(bantu.getTrack().get(j).getCount() + 1);
//                            sudahAda = true;
//                            break;
//                        }
//                    }
//                    if (sudahAda == false) {
//                        bantu.getTrack().add(new Path(data, 1));
//                    }
//                }
//            } else if (searchchlid(bantu, key) != -1) {
//                bantu = bantu.getChild().get(searchchlid(bantu, key));
//                if (bantu.getTrack().isEmpty()) {
//                    bantu.getTrack().add(new Path(data, 1));
//                } else {
//                    for (int j = 0; j < bantu.getTrack().size(); j++) {
//                        if (bantu.getTrack().get(j).getPath().equals(data)) {
//                            bantu.getTrack().get(j).setCount(bantu.getTrack().get(j).getCount() + 1);
//                            sudahAda = true;
//                            break;
//                        }
//                    }
//                    if (sudahAda == false) {
//                        bantu.getTrack().add(new Path(data, 1));
//                    }
//                }
//            } else {
//                TreeNode baru = new TreeNode(key);
//                bantu.getChild().add(baru);
//                bantu = baru;
//                baru.getTrack().add(new Path(data, 1));
//            }
//        }
    }

    public TreeNode searchLocal(TreeNode root, String key) {
        TreeNode bantu = root;
        while (bantu != null) {
            if (bantu.getIdGlobal().equals(key)) {
                return bantu;
            } else {
                bantu = bantu.getChild().get(0);
            }
        }
        return null;
    }

    public int searchchlidLocal(TreeNode node, String key) {
        for (int i = 0; i < node.getChild().size(); i++) {
            if (node.getChild().get(i).getIdGlobal().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    // =========================== METHOD PRINT ==============================//
    public void printDataMentah() {
        for (DataMentah dataMentah : dataMentahs) {
            System.out.println(dataMentah);
        }
    }

    public void printMapStruks() {
        for (Map.Entry<String, ArrayList<String>> entry : mapStruks.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void printFreq() {
        for (Map.Entry<String, Integer> entry : preItemSet.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void printGlobalTable() {
        for (int i = 0; i < globalItems.size(); i++) {
            System.out.println(globalItems.get(i));
        }
    }

    public void printItemSets() {
        for (Map.Entry<String, ArrayList<GlobalItem>> entry : itemSets.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    public void printGlobal() {
        for (int i = 0; i < globalMinings.size(); i++) {
            System.out.println("Hasil Tambang : " + globalMinings.get(i).getIdGlobal());
            for (Map.Entry<String, Integer> entry : globalMinings.get(i).getItemSet().entrySet()) {
                System.out.println(entry.getKey() + " = " + globalItems.get(getIndex(entry.getKey())).getNamaBarang() + " : " + entry.getValue());
            }
            System.out.println("----------");
        }
    }

    public void printLocal() {
        for (int i = 0; i < localMinings.size(); i++) {
            if (localMinings.get(i).getLocalList().size() != 0) {
                System.out.println("Hasil Tambang " + localMinings.get(i).getIdGlobalTambang() + " (" + globalItems.get(getIndex(localMinings.get(i).getIdGlobalTambang())).getNamaBarang() + ")");
                for (int j = 0; j < localMinings.get(i).getLocalList().size(); j++) {
                    System.out.println(localMinings.get(i).getLocalList().get(j));
                }
                System.out.println();
            }
        }
    }


    public void printAllSize() {
        System.out.println("Size Data Mentah = " + dataMentahs.size());
        System.out.println("Jumlah Struk = " + mapStruks.size());
        System.out.println("Size Global Items = " + globalItems.size());
        System.out.println("Size Item Sets = " + itemSets.size());
    }
}
