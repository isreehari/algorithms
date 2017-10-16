/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.graph.dfs.kruskals;

/**
 *
 * @author sinukoll
 */
public class Edge implements Comparable<Edge> {
    
    int u; // Start vertex
    int v; // End vertex
    int wt; //  weight of edge 
    
    public Edge(int u, int v, int wt){
        this.u = u;
        this.v = v;
        this.wt = wt;
    }

    @Override
    public int compareTo(Edge obj1) {
       if(wt == obj1.wt)
            return 0;
        else if(wt > obj1.wt)
            return 1;
        else
            return -1;
    }
}
