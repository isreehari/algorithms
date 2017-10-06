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
public class EdgeArrayList {
    
    VertexArrayList endVertex;
    EdgeArrayList nextEdge; 
    
    public EdgeArrayList(VertexArrayList refEndVertex){
        this.endVertex = refEndVertex;
        this.nextEdge = null;
    }
    
}
