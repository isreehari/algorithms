/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.graph.pathmatrix;

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
        pathMatrix.findPathMatrix();
        
    }
    
    public void findPathMatrix(){
        
        int[][] x, adjp, temp;
        
        x = new int[MAX_VERTICES][MAX_VERTICES];
        adjp = new int[MAX_VERTICES][MAX_VERTICES];
        temp = new int[MAX_VERTICES][MAX_VERTICES];
        
        for(int i = 0; i < this.numberVerticies; i++)
            for(int j = 0; j < this.numberVerticies; j++)
                x[i][j] = adjp[i][j] = this.adjMatrix[i][j] ? 1 : 0;
        
        
        for(int p = 2 ; p <= this.numberVerticies ; p++){
            
            
            //Matrix  multiplication
            for(int i = 0; i< this.numberVerticies; i++)
                for(int j = 0; j < this.numberVerticies; j++){
                    temp[i][j] = 0;                    
                    for(int k = 0; k < this.numberVerticies; k++)
                        temp[i][j] = temp[i][j] + adjp[i][k] * (this.adjMatrix[k][j]?1:0);  // A^2 = A * A; 
                }
            
           for(int i = 0; i < this.numberVerticies; i++)
            for(int j = 0; j < this.numberVerticies; j++)
                adjp[i][j] = temp[i][j];
           
           
           for(int i = 0; i < this.numberVerticies; i++)
            for(int j = 0; j < this.numberVerticies; j++)
                    x[i][j] = x[i][j] + adjp[i][j];    // Path matrix = A + A^2 + A^3 + A^4 
            
        }
        
        
        
        for(int i = 0; i < this.numberVerticies; i++)
            for(int j = 0; j < this.numberVerticies; j++)
                    x[i][j] = x[i][j] > 0 ? 1 : 0; // Replace non zeros with 1 in Path matrix -> Final path martix
        
        
        this.display(x);
        
        
        
        
        
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
