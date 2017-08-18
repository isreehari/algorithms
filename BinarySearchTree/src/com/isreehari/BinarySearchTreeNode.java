/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari;

/**
 *
 * @author sinukoll
 */
public class BinarySearchTreeNode {
    public int nodeValue;
    public BinarySearchTreeNode leftChildNode;
    public BinarySearchTreeNode rightChildNode;
    
    public BinarySearchTreeNode(int newNodeValue){        
        this.nodeValue = newNodeValue;
        this.leftChildNode = null;
        this.rightChildNode = null;
    }
}
