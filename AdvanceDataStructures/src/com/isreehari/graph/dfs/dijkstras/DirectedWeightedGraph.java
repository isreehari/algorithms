/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.graph.dfs.dijkstras;


import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author sinukoll
 */
public class DirectedWeightedGraph {
    
    public static final int MAX_VERTICES = 30;
    private int numberVerticies;
    private int numberEdges;
    int [][] adjMatrix;
    Vertex[] vertexList;
    
    // Constants for different statuss of a vertex 
    
    private static final int TEMPORARY = 1;    
    private static final int PERMANENT = 2;
    private static final int NIL = -1;    
    private static final int INFINITY = 99999;
    
    
    
    public DirectedWeightedGraph(){
        this.adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.vertexList = new Vertex[MAX_VERTICES];
    }
    
    public static void main(String... args){
        DirectedWeightedGraph matrix = new DirectedWeightedGraph();
        
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
        
        
        matrix.insertEdge("zero", "one");
        matrix.insertEdge("zero", "three");
        matrix.insertEdge("one", "two");
        matrix.insertEdge("one", "four");
        matrix.insertEdge("one", "five");
        
        matrix.insertEdge("two", "three");
        matrix.insertEdge("two", "five");
        
        matrix.insertEdge("three", "six");
        
        
        matrix.insertEdge("four", "five");
        matrix.insertEdge("four", "seven");
        
        matrix.insertEdge("five", "six");
        matrix.insertEdge("five", "eight");
        
        matrix.insertEdge("six", "eight");
        matrix.insertEdge("six", "nine");
        
        matrix.insertEdge("seven", "eight");
        matrix.insertEdge("eight", "nine");
        
        matrix.display();
        
        System.out.println("DFS With Start Vertex: ");
        matrix.dfsTraversal();
        System.out.println();
       
        
    }
    
    public void dfsTraversal(){
        int v, c;
        for(v = 0; v < this.numberVerticies; v++){
            this.vertexList[v].status = TEMPORARY;
            this.vertexList[v].pathLength = INFINITY;
            this.vertexList[v].predecessor = NIL;
        }
            
        
        Scanner inputScan = new Scanner(System.in);
        System.out.println("Enter starting vertex for Deapth First Search: ");
        String s = inputScan.next();
        int initialVertex = this.getIndex(s);
        this.vertexList[initialVertex].pathLength = 0;
        
        while(true){
            c = this.tempVertexMinPathLength();
            
            if(c == NIL)
                return;
            
            this.vertexList[c].status = PERMANENT;
            
            for(v = 0; v < this.numberVerticies ; v++){
                  if(this.vertexList[v].status == TEMPORARY && this.isAdjacent(c,v)){
                      if( (this.vertexList[c].pathLength + this.adjMatrix[c][v]) < this.vertexList[v].pathLength){
                          
                      }
                  }
            }
            
        }
        
        
    }
    
    private int tempVertexMinPathLength(){
        
        
        
        return 1;
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
        return this.adjMatrix[fromIndex][toIndex] > -1;
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
    
    public void insertEdge(String fromVertex, String toVertex){
        if(fromVertex.equals(toVertex)){
           System.out.println("Opps! Invalid arguments. You can not create edge same vertex.");           
        }else{
            int u = this.getIndex(fromVertex);
            int v = this.getIndex(toVertex);
            
              if(u == -1 || v == -1){
                  System.out.println("Opps! Invalid verticies");
                  return;
              }
              
              if(this.adjMatrix[u][v] > -1){
                  System.out.println("Opps! This is already an edge between two verticies");
              }else{
                  this.adjMatrix[u][v] = 1;
                  this.numberEdges++;
                  System.out.println("Edge has been created");
              }
                    
        }
    }
    
}
