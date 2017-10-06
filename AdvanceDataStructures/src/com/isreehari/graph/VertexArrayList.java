/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.graph;

/**
 *
 * @author sinukoll
 */
public class VertexArrayList {    
    public String name;
    public VertexArrayList nextVertex;
    public EdgeArrayList startEdge;
    
    public VertexArrayList(String vName){
        this.name = vName;
        this.nextVertex = null;
        this.startEdge = null;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
}
