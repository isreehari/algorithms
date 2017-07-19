/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm;

/**
 *
 * @author sinukoll
 */
public class Node {
    public Node previousNode;
    public int nodeValue;
    public Node nextNode;
    
    public Node(int newNodeValue){
        this.previousNode = null;
        this.nodeValue = newNodeValue;
        this.nextNode = null;
    }
    
}
