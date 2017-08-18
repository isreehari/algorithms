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
public class BinaryTreeCharNode {
    
    BinaryTreeCharNode leftChildNode;
    char nodeValue;
    BinaryTreeCharNode rightChildNode;
    
    public BinaryTreeCharNode(char newNodeValue){
        this.leftChildNode = null;
        this.nodeValue = newNodeValue;
        this.rightChildNode = null;
    }
    
}
