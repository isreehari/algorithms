/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.graph.dfs.dijkstras;





/**
 *
 * @author sinukoll
 */
public class Vertex {
    public String name;
    public int status;
    public int predecessor;
    public int pathLength;
    
    public Vertex(String newName){
        this.name = newName;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
