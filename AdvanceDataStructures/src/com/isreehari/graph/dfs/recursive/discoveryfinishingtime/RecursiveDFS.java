/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.graph.dfs.recursive.discoveryfinishingtime;


import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author sinukoll
 */
public class RecursiveDFS {
    
    public static final int MAX_VERTICES = 30;
    private int numberVerticies;
    private int numberEdges;
    boolean [][] adjMatrix;
    Vertex[] vertexList;
    
    // Constants for different states of a vertex 
    
    private static int time ;
    private static final int INITIAL = 0;    
    private static final int VISITED = 1;
    private static final int FINISHED = 2;
    
    
    public RecursiveDFS(){
        this.adjMatrix = new boolean[MAX_VERTICES][MAX_VERTICES];
        this.vertexList = new Vertex[MAX_VERTICES];
    }
    
    public static void main(String... args){
        RecursiveDFS matrix = new RecursiveDFS();
        
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
        System.out.println("DFS All - With Start Vertex: ");
        matrix.dfsTraversalAll();
        System.out.println();
        
    }
    
    public void dfsTraversal(){
        
        for(int v = 0; v < this.numberVerticies; v++)
            this.vertexList[v].state = INITIAL;
        
        time = 0;
        Scanner inputScan = new Scanner(System.in);
        System.out.println("Enter starting vertex for Deapth First Search: ");
        String s = inputScan.next();
        System.out.println();
        this.dfs(this.getIndex(s));
        
         for(int v = 0; v < this.numberVerticies; v++){
             System.out.println("Vertex "+ this.vertexList[v]);
             System.out.println("\t Discover time - "+ this.vertexList[v].discoveryTime);
             System.out.println("\t Finishing time - "+ this.vertexList[v].finishingTime);
         }
            
    }
    
    private void dfs(int currentVertex){
        this.vertexList[currentVertex].state = VISITED;
        this.vertexList[currentVertex].discoveryTime = ++time;
        
        for(int i = 0; i < this.numberVerticies; i++){
                    if( this.vertexList[i].state == INITIAL && this.isAdjacent(currentVertex, i)){
                        this.dfs(i);
                    }
        }
        
        this.vertexList[currentVertex].state = FINISHED;
        this.vertexList[currentVertex].finishingTime = ++time;
     
        
        
        
    }
    
    public void dfsTraversalAll(){
        int currentVertex;
        for(currentVertex = 0; currentVertex < this.numberVerticies; currentVertex++)
            this.vertexList[currentVertex].state = INITIAL;
        time = 0;
        Scanner inputScan = new Scanner(System.in);
        System.out.println("Enter starting vertex for Deapth First Search: ");
        String s = inputScan.next();
        this.dfs(this.getIndex(s));
         System.out.println();
        
        for(currentVertex = 0; currentVertex < this.numberVerticies; currentVertex++)
            if(vertexList[currentVertex].state == INITIAL){
                 System.out.println();
                 this.dfs(currentVertex);
            }
        
        
         for(int v = 0; v < this.numberVerticies; v++){
             System.out.println("Vertex "+ this.vertexList[v]);
             System.out.println("\t Discover time - "+ this.vertexList[v].discoveryTime);
             System.out.println("\t Finishing time - "+ this.vertexList[v].finishingTime);
         }
                
        
        
    }
    
    public void display(){
        for(int i = 0; i < this.numberVerticies; i++){
            for(int j = 0; j < this.numberVerticies; j++){
                if(this.adjMatrix[i][j])
                    System.out.print(" 1 ");
                else
                    System.out.print(" 0 ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
    
     public void display(int[][] matrix){
        for(int i = 0; i < this.numberVerticies; i++){
            for(int j = 0; j < this.numberVerticies; j++){                
                    System.out.print(" "+matrix[i][j]+" ");                
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
        return this.adjMatrix[fromIndex][toIndex];
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
              
              if(this.adjMatrix[u][v]){
                  System.out.println("Opps! This is already an edge between two verticies");
              }else{
                  this.adjMatrix[u][v] = true;
                  this.numberEdges++;
                  System.out.println("Edge has been created");
              }
                    
        }
    }    
}
