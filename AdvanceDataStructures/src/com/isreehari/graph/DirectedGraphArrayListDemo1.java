/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.graph;

import java.util.NoSuchElementException;

/**
 *
 * @author sinukoll
 */
public class DirectedGraphArrayListDemo1 {
    
    private VertexArrayList rootVertex;
    private int numberVertices;
    private int numberEdges;
    
    public DirectedGraphArrayListDemo1(){
        this.rootVertex = null;
        this.numberVertices = 0;
        this.numberEdges = 0;
    }
    
    public static void main(String[] args){
          DirectedGraphArrayListDemo1 directedGraph = new DirectedGraphArrayListDemo1();   
            
            directedGraph.insertVertex("Zero");
            directedGraph.insertVertex("One");
            directedGraph.insertVertex("Two");
            
            directedGraph.insertEdge("One", "Two");
            directedGraph.insertEdge("Two", "Zero");
            directedGraph.insertEdge("Zero", "One");
            
            directedGraph.display();
            System.out.println("Vertices : "+directedGraph.getVertices()+ ", Edges : "+directedGraph.getEdges());
            System.out.println("Vertices In degree: "+directedGraph.inDegree("One")+ ", Out degree : "+directedGraph.outDegree("One"));
    }
    
    public int getVertices(){        
        return this.numberVertices;        
    }
    
    public int getEdges(){
        return this.numberEdges;
    }
    
    public void insertVertex(String vertexName){
        VertexArrayList newVertex = new VertexArrayList(vertexName);
        VertexArrayList currentVertex = this.rootVertex;
        
        if(this.rootVertex == null){
            this.numberVertices++;
            this.rootVertex = newVertex;
            return; 
        }
        
        while(currentVertex.nextVertex != null){        
                if(currentVertex.nextVertex.name.equals(vertexName)){
                    System.out.println("Vertex already present");
                    return;
                }
            currentVertex = currentVertex.nextVertex;
        }
        
        newVertex.nextVertex = currentVertex.nextVertex;
        currentVertex.nextVertex = newVertex;
        
       
        
        this.numberVertices++;
       
    }
    
    public void deleteVertex(String s){
        this.deleteVertexFromEdgeLists(s);
        this.deleteVertexFromVertexList(s);
    }
    
    public void deleteVertexFromEdgeLists(String vertexName){        
        VertexArrayList currentVertex = this.rootVertex;        
        if(currentVertex == null){
            System.out.println("No vertices to be deleted");
            return;
        }
        
        EdgeArrayList currentEdge = null;
        
        while(currentVertex != null){
            
            if(currentVertex.startEdge == null)
                continue;
            
            
            if(currentVertex.startEdge.endVertex.name.equals(vertexName)){
                this.numberEdges--;
                currentVertex.startEdge = currentVertex.startEdge.nextEdge;
            }else{
                currentEdge = currentVertex.startEdge;
                while(currentEdge.nextEdge !=null){
                    if(currentEdge.nextEdge.endVertex.name.equals(vertexName)){
                        break;
                    }                    
                    currentEdge = currentEdge.nextEdge;
                }
                
                currentEdge.nextEdge = currentEdge.nextEdge.nextEdge;
                this.numberEdges--;
            }
            
            currentVertex = currentVertex.nextVertex;
        }
        
    }
    
    public void deleteVertexFromVertexList(String vertexName){
        
        if(this.rootVertex == null){
            System.out.println("No vertices to be deleted");
            return;
        }
        
        if(this.rootVertex.name.equals(vertexName)){ // if it is start node of graph
            for(EdgeArrayList currentEdge = this.rootVertex.startEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                this.numberEdges--;
            
            this.rootVertex = this.rootVertex.nextVertex;
            this.numberVertices--;
            
        }else{
            VertexArrayList currentVertex = this.rootVertex;
            while(currentVertex.nextVertex != null){
                if(currentVertex.nextVertex.name.equals(vertexName)){
                    break;
                }                
                currentVertex = currentVertex.nextVertex;
            }
            
            for(EdgeArrayList currentEdge = currentVertex.nextVertex.startEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                this.numberEdges--;
            
            currentVertex.nextVertex = currentVertex.nextVertex.nextVertex;
            this.numberVertices--;            
            
        }
    }
    

    
    public VertexArrayList findVertex(String vertexName){
        VertexArrayList currentVertex = this.rootVertex;
        
        while(currentVertex != null)
            if(currentVertex.name.equals(vertexName))
                return currentVertex;
        else
                currentVertex = currentVertex.nextVertex;
        
        return null;
        
    }
    
    public void display(){
        VertexArrayList currentVertex = this.rootVertex;
        EdgeArrayList currentEdge = null; 
        
        while(currentVertex != null){
            System.out.print(currentVertex.name + " ");
            currentEdge = currentVertex.startEdge;
            while(currentEdge != null){
                System.out.print(" -> " + currentEdge.endVertex.name);
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            currentVertex = currentVertex.nextVertex;
        }
    }
    
    public boolean edgeExists(String fromVertex, String toVertex){
        
        VertexArrayList v1 = this.findVertex(fromVertex);
        VertexArrayList v2 = this.findVertex(toVertex);
        
        if(v1 == null || v2 == null || v1 == v2)
          throw new IllegalArgumentException("Vertices are not valid");
        
        EdgeArrayList currentEdge = v1.startEdge;        
       
        while(currentEdge != null){
            
            if(currentEdge.endVertex.equals(v2))
                return true;
            
            currentEdge = currentEdge.nextEdge;
        }
            
        
        return false;
    }
    
    public void insertEdge(String fromVertex, String toVertex){
        
        VertexArrayList v1 = this.findVertex(fromVertex);
        VertexArrayList v2 = this.findVertex(toVertex);
        
        if(v1 == null || v2 == null || v1 == v2)
          throw new IllegalArgumentException("Vertices are not valid");
        
        EdgeArrayList currentEdge = v1.startEdge, newEdge = new EdgeArrayList(v2);
        
        if(currentEdge == null){
            this.numberEdges++;
            v1.startEdge = newEdge;
            return;
        }
        
        if(this.edgeExists(fromVertex, toVertex)){
            System.out.println("Opps! Edge already exists between the two vertices.");
            return ;
        }
            
        
        while(currentEdge.nextEdge != null)
            currentEdge = currentEdge.nextEdge;
        
        currentEdge.nextEdge = newEdge;    
        this.numberEdges++;
    }
    
    
   
    
    public EdgeArrayList deleteEdge(String fromVertexName, String toVertexName){
        VertexArrayList v1 = this.findVertex(fromVertexName);
        VertexArrayList v2 = this.findVertex(fromVertexName);
        
        if(v1 == null || v2 == null || v1 == v2){
            System.out.println("Invalid vertices");
            return null;
        }
        
        EdgeArrayList currentEdge = v1.startEdge, deletedEdge = null;
        
        while(currentEdge != null){
            if(currentEdge.endVertex.equals(v2)){
                break;
            }                
            currentEdge = currentEdge.nextEdge;
        }
        
        if(currentEdge == null){
            System.out.println("There is no Edge present");
            return null;
        }
            
        
        if(currentEdge == v1.startEdge){
            v1.startEdge = null;
            this.numberEdges--;
            return currentEdge;
        }
        deletedEdge = currentEdge;
        this.numberEdges--;
        currentEdge = currentEdge.nextEdge;
        
        return deletedEdge;
        
        
    }
    
    
    public int outDegree(String vertexName){
        int count = 0;
        VertexArrayList currentVertex = this.findVertex(vertexName);
        
        if(currentVertex == null){
            System.out.println("Invalid vertex");
            return count;
        }
        
        EdgeArrayList currentEdge = currentVertex.startEdge;
        while( currentEdge != null){
            currentEdge = currentEdge.nextEdge;
            count++;
        }
        
        return count;
    }
    
    
    public int inDegree(String vertexName){
        int count = 0;
        VertexArrayList currentVertex = this.findVertex(vertexName);
        
        if(currentVertex == null){
            System.out.println("Invalid vertex");
            return count;
        }
        
        VertexArrayList tempVertex = this.rootVertex;
        
         if(tempVertex == null){
            System.out.println("Invalid vertex");
            return count;
        }
         EdgeArrayList currentEdge = null;
         while(tempVertex != null){             
            currentEdge = tempVertex.startEdge;
                while( currentEdge != null){
                    
                    if(currentEdge.endVertex == currentVertex)
                        count++;
                    
                    currentEdge = currentEdge.nextEdge;
                }
             
             tempVertex = tempVertex.nextVertex;
         }
        
        
        
        return count;
    }
    
    
    
    
    
    
}
