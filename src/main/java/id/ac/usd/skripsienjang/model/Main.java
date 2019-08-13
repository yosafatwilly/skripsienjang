/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.usd.skripsienjang.model;

/**
 *
 * @author P.A.W.E.G
 */
public class Main {

    public static void main(String[] args) {
        Tree tree2 = new Tree(3);
        tree2.printDataMentah();
        tree2.printMapStruks();
        tree2.printFreq();
        tree2.printGlobalTable();
        tree2.printItemSets();
        tree2.intializeTree();
        tree2.input();
        tree2.traversal(tree2.root);
        tree2.startMining();
        tree2.printGlobalTable();
        tree2.globalMining();
        tree2.printGlobal();
        tree2.localMining();;
        tree2.printLocal();
        tree2.printAllSize();
        tree2.build();
//        tree2.printItemSets();
    }
}
