/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.graph.dfs.prims;



import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author sinukoll
 */
public class Prims {
    
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
    
    
    
    public Prims(){
        this.adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.vertexList = new Vertex[MAX_VERTICES];
    }
    
    public static void main(String... args){
        Prims matrix = new Prims();
        
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
        
        
        matrix.insertEdge("zero", "one", 1);
        matrix.insertEdge("zero", "three", 6);
        matrix.insertEdge("one", "two", 8);
        matrix.insertEdge("one", "four", 7);
        matrix.insertEdge("one", "five", 9);
        
        matrix.insertEdge("two", "three",1);
        matrix.insertEdge("two", "five", 4);
        
        matrix.insertEdge("three", "six", 7);
        
        
        matrix.insertEdge("four", "five", 10);
        matrix.insertEdge("four", "seven", 2);
        
        matrix.insertEdge("five", "six", 5);
        matrix.insertEdge("five", "eight", 6);
        
        matrix.insertEdge("six", "eight", 11);
        matrix.insertEdge("six", "nine", 9);
        
        matrix.insertEdge("seven", "eight", 10);
        matrix.insertEdge("eight", "nine",1);
        
        matrix.display();
        
        System.out.println("Find the shortest path: ");
        matrix.prims();
        System.out.println();
       
        
    }
    
    public void prims(){
        int v, c;
        for(v = 0; v < this.numberVerticies; v++){
            this.vertexList[v].status = TEMPORARY;
            this.vertexList[v].length = INFINITY;
            this.vertexList[v].predecessor = NIL;
        }
        int numberEdgesInTree = 0;
        int weightTree = 0;
        int rootIndex = 0;
        
        this.vertexList[rootIndex].length = 0;
        
        while(true){
            c = this.tempVertexMinLength();
            
            if(c == NIL){
                
                if(numberEdgesInTree == this.numberVerticies - 1){
                    System.out.println("Weight of minimum spanning tree is " + weightTree);
                    return;
                }else{
                    throw new RuntimeException("Graph is not connected, Spanning tree not possible");
                }
                
                
            }
                
            
            this.vertexList[c].status = PERMANENT;
            
            // Include edge ( vertexList[c].predecessor, c) in the tree 
            
            if(c != rootIndex){
                numberEdgesInTree++;
                System.out.println("(" + this.vertexList[c].predecessor + ", "+ c +")");
                weightTree += this.adjMatrix[this.vertexList[c].predecessor][c];
            }
            
            
            
            for(v = 0; v < this.numberVerticies ; v++){
                  if(this.vertexList[v].status == TEMPORARY && this.isAdjacent(c,v)){
                      if(  this.adjMatrix[c][v] < this.vertexList[v].length ){
                          this.vertexList[v].predecessor = c;
                          this.vertexList[v].length =   this.adjMatrix[c][v];
                      }
                  }
            }
            
        }
        
        
    }
    
    private int tempVertexMinLength(){
        
        int min = INFINITY;
        int x = NIL;
        
        for(int v = 0; v < this.numberVerticies; v++){
              if(this.vertexList[v].status == TEMPORARY && this.vertexList[v].length < min){
                  min = this.vertexList[v].length;
                  x = v;
              }
        }
        
        
        return x;
    }
    
    public void findPath(int sourceIndex, int destinationIndex){
        int i, u;
        int path[] = new int[this.numberVerticies];
        int shortestPath = 0;
        int numberVxs = 0;
        
        while( destinationIndex != sourceIndex){
            numberVxs++;
            path[numberVxs] = destinationIndex;
            u = this.vertexList[destinationIndex].predecessor;            
            shortestPath += this.adjMatrix[u][destinationIndex];
            destinationIndex = u;
        }
        
        numberVxs++;
        path[numberVxs] = sourceIndex;
        
        System.out.println("Shortest Path is: ");
        for(i = numberVxs; i >= 1; i--){
            System.out.print(path[i] + " -> ");
        }
        
        System.out.println(" \n Shortest distace is : " + shortestPath);
        
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
