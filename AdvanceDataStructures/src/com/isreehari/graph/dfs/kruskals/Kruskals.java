/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.graph.dfs.kruskals;

import java.util.Scanner;
import java.util.PriorityQueue;

/**
 *
 * @author sinukoll
 */
public class Kruskals {
    
    public static final int MAX_VERTICES = 30;
    private int numberVerticies;
    private int numberEdges;
    int [][] adjMatrix;
    Vertex[] vertexList;
    
    private static final int NIL = -1;    
    
    public Kruskals(){
        this.adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.vertexList = new Vertex[MAX_VERTICES];
    }
    
    public static void main(String... args){
        Kruskals matrix = new Kruskals();
        
        matrix.insertVertex("zero");
        matrix.insertVertex("one");
        matrix.insertVertex("two");
        matrix.insertVertex("three");
        matrix.insertVertex("four");
        matrix.insertVertex("five");
        matrix.insertVertex("six");
        matrix.insertVertex("seven");
        matrix.insertVertex("eight");
        matrix.insertVertex("nine");
        
        
        matrix.insertEdge("zero", "one", 19);
        matrix.insertEdge("zero", "three", 14);
        matrix.insertEdge("zero", "four", 12);
        
        matrix.insertEdge("one", "two", 20);
        matrix.insertEdge("one", "four", 18);
        
        
        matrix.insertEdge("two", "four",17);
        matrix.insertEdge("two", "five", 15);
        matrix.insertEdge("two", "nine", 29);
        
        matrix.insertEdge("three", "four", 13);
        matrix.insertEdge("three", "six", 28);
        
        
        matrix.insertEdge("four", "five", 16);
        matrix.insertEdge("four", "six", 21);
        matrix.insertEdge("four", "seven", 22);
        matrix.insertEdge("four", "eight", 24);
        
        
        matrix.insertEdge("five", "eight", 26);
        matrix.insertEdge("five", "nine", 27);
        
        matrix.insertEdge("six", "seven", 23);
        matrix.insertEdge("six", "eight", 30);
        matrix.insertEdge("six", "nine", 35);
        
        
        
        matrix.display();
        
        System.out.println("Find the minimum spanning tree: ");
        matrix.kruskals();
        System.out.println();
       
        
    }
    
    public void kruskals(){
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        
        int u, v;
        for(u = 0; u < this.numberVerticies; u++){
            for(v = 0; v < u; v++){
                if(this.adjMatrix[v][u] != 0){
                    pq.add(new Edge(u,v,this.adjMatrix[v][u]));
                }
            }
        }
        
        for(v = 0; v < this.numberVerticies; v++)
            this.vertexList[v].father = NIL;
        
        int v1, v2, r1 = NIL, r2 = NIL;
        int numberEdgesInTree = 0;
        int weightTree = 0;
        
        while(!pq.isEmpty() && numberEdgesInTree < this.numberVerticies - 1){
            Edge edge = pq.remove();
            v1 = edge.u;
            v2 = edge.v;
            
            v = v1;
            while(this.vertexList[v].father != NIL)
                v = this.vertexList[v].father;
            r1 = v;
            
            v = v2;
            while(this.vertexList[v].father != NIL)
                v = this.vertexList[v].father;
            r2 = v;
            
            if( r1 != r2 ){ // Edge (v1, v2 ) is included
                numberEdgesInTree++;
                System.out.println(this.vertexList[v1] + " , " + this.vertexList[v2]);
                weightTree += edge.wt;
                this.vertexList[r2].father = r1;
            }
        }
        
        if(numberEdgesInTree < this.numberVerticies - 1)
            throw new RuntimeException("Graph is not connected, no spanning tree possible ");
        
        
        System.out.println("Weight of minimum spanning tree is : " + weightTree);
        
        
    }
    
    
    public void display(){
        for(int i = 0; i < this.numberVerticies; i++){
            for(int j = 0; j < this.numberVerticies; j++){                
                    System.out.print(" "+this.adjMatrix[i][j] + " ");
                
            }
            System.out.println();
        }
        
        System.out.println();
    }
    
    
    
    public int getIndex( String vertexName){
        
        for(int index = 0; index < this.numberVerticies; index++){
            if(this.vertexList[index].name.equals(vertexName)){
                return index;
            }
        }
        
        return -1;        
    }
    
    public boolean isAdjacent(int fromIndex , int toIndex){        
        return this.adjMatrix[fromIndex][toIndex] >= 1;
    }
    
    public void insertVertex(String newVertex){
        if( this.getIndex(newVertex) == -1){
            if(this.numberVerticies < MAX_VERTICES){
                this.vertexList[this.numberVerticies++] = new Vertex(newVertex);
            }else{
                System.out.println("Opps! Maximum allowed verticies are only "+MAX_VERTICES);    
            }
        }else{
            System.out.println("Opps! Vertex name already exist.");
        }
    }
    
    public void insertEdge(String fromVertex, String toVertex, int weight){
        if(fromVertex.equals(toVertex)){
           System.out.println("Opps! Invalid arguments. You can not create edge same vertex.");           
        }else{
            int u = this.getIndex(fromVertex);
            int v = this.getIndex(toVertex);
            
              if(u == -1 || v == -1){
                  System.out.println("Opps! Invalid verticies");
                  return;
              }
              
              if(this.adjMatrix[u][v] >= 1){
                  System.out.println("Opps! This is already an edge between two verticies");
              }else{
                  this.adjMatrix[u][v] = weight;
                  this.numberEdges++;
                  System.out.println("Edge has been created");
              }
                    
        }
    }
    
}
