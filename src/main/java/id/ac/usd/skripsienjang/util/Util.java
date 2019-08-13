/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.usd.skripsienjang.util;

import id.ac.usd.skripsienjang.model.GlobalItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author P.A.W.E.G
 */
public class Util {

    public static HashMap<String, Integer> sortDesc(HashMap<String, Integer> map) {
        return map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }

    public static String arrayToString(ArrayList<GlobalItem> itemSets) {
        String itemString = "";
        for (int i = 0; i < itemSets.size(); i++) {
            itemString += itemSets.get(i).getIdGlobal() + ",";
        }
        return itemString;
    }
}
