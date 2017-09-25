/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.threadedbinarytree;

/**
 *
 * @author sinukoll
 */
public class Node {
    public Node leftNode;
    public boolean leftThread;
    public int nodeValue;
    public boolean rightThread;
    public Node rightNode;
    
    public Node(int newNodeValue){
         this.nodeValue = newNodeValue;
         this.leftNode = null;
         this.rightNode = null;
         this.leftThread = true;
         this.rightThread = true;
    }
    
    
    
}
