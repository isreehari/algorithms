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
public class DirectedGraphDemo1 {
    
    public final int MAX_VERTICES = 30;
    
    int n;
    int e;
    boolean[][] adj;
    Vertex[] vertexList;
    
    public DirectedGraphDemo1(){
        
          this.adj = new boolean[MAX_VERTICES][MAX_VERTICES];
          this.vertexList = new Vertex[MAX_VERTICES];
          
          // By default n=0, e = 0
          // By default adj[u][v] = false
    }
    
    public static void main(String[] args){        
            DirectedGraphDemo1 directedGraph = new DirectedGraphDemo1();   
            
            directedGraph.insertVertex("Zero");
            directedGraph.insertVertex("One");
            directedGraph.insertVertex("Two");
            
            directedGraph.insertEdge("One", "Two");
            directedGraph.insertEdge("Two", "Zero");
            
            directedGraph.display();
            System.out.println("Vertices : "+directedGraph.vertices() + ", Edges : "+directedGraph.edges());
    }
    
    public int vertices(){
        return this.n;
    }
    
    public int edges(){
        return this.e;
    }
    
    public void display(){        
        for(int u = 0; u < n ; u++){
            for(int v = 0; v < n; v++){
                if(this.adj[u][v])
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }
    
    public void insertVertex(String name){
        this.vertexList[this.n++] = new Vertex(name);
    }
    
    public int getIndex(String name){
      for(int i= 0; i < n ; i++)   
          if(name.equals(this.vertexList[i].name))
              return i;
      throw new RuntimeException("Invalid Vertex");
    }
    
    public boolean isAdjacent(int u, int v){
        return this.adj[u][v];
    }
    
    public boolean edgeExists(String s1, String s2){        
        int u = this.getIndex(s1);
        int v = this.getIndex(s2);
        return this.isAdjacent(u, v);        
    }
    
    public void insertEdge(String s1, String s2){
        int u = this.getIndex(s1);
        int v = this.getIndex(s2);
        
        if(u == v)
            throw new IllegalArgumentException("Not a valid edge");
        
        if(this.adj[u][v] == true)
            System.out.println("Edge already present");
        else{
            this.adj[u][v] = true;
            this.e++;
        }
        
            
    }
    
     public void deleteEdge(String s1, String s2){
        int u = this.getIndex(s1);
        int v = this.getIndex(s2);
        
        if(this.adj[u][v] == false)
            System.out.println("Edge not present in the graph");
        else{
            this.adj[u][v] = false;
            this.e--;
        }   
    }
     
    public int outDegree(String s1){
        int u = this.getIndex(s1);
        int outDegreeCount = 0;
        
        for(int v = 0; v < n ; v++)
            if(this.adj[u][v])
                outDegreeCount++;
        
        return outDegreeCount;
    }
    
    public int inDegree(String s2){
        int v = this.getIndex(s2);
        int inDegreeCount = 0;
        
        for(int u = 0; u < n ; u++)
            if(this.adj[u][v])
                inDegreeCount++;
        
        return inDegreeCount;
    }
    
}
