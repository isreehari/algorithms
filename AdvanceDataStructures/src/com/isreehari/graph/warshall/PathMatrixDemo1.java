/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.graph.warshall;
/**
 *
 * @author sinukoll
 */
public class PathMatrixDemo1 {
    
    public static final int MAX_VERTICES = 30;
    private int numberVerticies;
    private int numberEdges;
    boolean [][] adjMatrix;
    Vertex[] vertexList;
    
    public PathMatrixDemo1(){
        this.adjMatrix = new boolean[MAX_VERTICES][MAX_VERTICES];
        this.vertexList = new Vertex[MAX_VERTICES];
    }
    
    public static void main(String... args){
        PathMatrixDemo1 pathMatrix = new PathMatrixDemo1();
        
        pathMatrix.insertVertex("zero");
        pathMatrix.insertVertex("one");
        pathMatrix.insertVertex("two");
        pathMatrix.insertVertex("three");
        
        pathMatrix.insertEdge("zero", "one");
        pathMatrix.insertEdge("zero", "three");
        pathMatrix.insertEdge("one", "two");
        pathMatrix.insertEdge("one", "three");
        pathMatrix.insertEdge("three", "two");
        
        pathMatrix.display();
        
        System.out.println("Find Path matrix: ");
        pathMatrix.warshalls();
        
    }
    
    public void warshalls(){
        
        boolean[][] pathMatrix = new boolean[MAX_VERTICES][MAX_VERTICES];
        
        
        
        for(int i = 0; i < this.numberVerticies; i++)
            for(int j = 0; j < this.numberVerticies; j++)
                pathMatrix[i][j] = this.adjMatrix[i][j];
        
        
        for(int k = 0 ; k < this.numberVerticies ; k++){            
           for(int i = 0; i < this.numberVerticies; i++)
            for(int j = 0; j < this.numberVerticies; j++)
                pathMatrix[i][j] = (pathMatrix[i][j] || (pathMatrix[i][k] && pathMatrix[k][j]));
        }
        
        this.display(pathMatrix);
        
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
    
     public void display(boolean[][] matrix){
        for(int i = 0; i < this.numberVerticies; i++){
            for(int j = 0; j < this.numberVerticies; j++){                
                if(matrix[i][j])
                    System.out.print(" 1 ");                
                else
                    System.out.print(" 0 ");                
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
