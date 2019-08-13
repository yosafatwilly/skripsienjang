/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.usd.skripsienjang.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author P.A.W.E.G
 */
public class TreeNode {

    private String IdGlobal;
    private int Count;
    private List<TreeNode> Child = new ArrayList<TreeNode>();
    private List<Path> track = new ArrayList<Path>();

    public TreeNode(String IdGlobal, int Count, List<TreeNode> child) {
        this.IdGlobal = IdGlobal;
        this.Count = Count;
        this.Child = child;
    }

    public TreeNode(String IdGlobal, List<Path> track, List<TreeNode> child) {
        this.IdGlobal = IdGlobal;
        this.track = track;
        this.Child = child;
    }

    public TreeNode(String IdGlobal) {
        this.IdGlobal = IdGlobal;
    }

    public List<Path> getTrack() {
        return track;
    }

    public void setTrack(List<Path> track) {
        this.track = track;
    }

    public String getIdGlobal() {
        return IdGlobal;
    }

    public void setIdGlobal(String IdGlobal) {
        this.IdGlobal = IdGlobal;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public List<TreeNode> getChild() {
        return Child;
    }

    public void setChild(List<TreeNode> child) {
        this.Child = child;
    }

}
