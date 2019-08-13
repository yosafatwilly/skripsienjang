package id.ac.usd.skripsienjang.tree;

import id.ac.usd.skripsienjang.model.GlobalItem;

import java.util.ArrayList;
import java.util.List;

public class Node{
    private String data = null;
    private List<Node> children;
    private Node parent = null;
    private Integer count;

    public Node(String data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public void addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void addChild(String data, Integer count) {
        Node newChild = new Node(data);
        newChild.setCount(1);
        this.addChild(newChild);
    }

    public void addChildren(List<Node> children) {
        for(Node t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }
}
