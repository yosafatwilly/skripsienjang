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
public class Path {
    private String path;
    private int count; 

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Path(String path, int count) {
        this.path = path;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Path{" + "path=" + path + " count=" + count + '}';
    }
    
    
}
