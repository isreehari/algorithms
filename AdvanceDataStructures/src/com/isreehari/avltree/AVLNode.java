/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.avltree;

/**
 *
 * @author sinukoll
 */
public class AVLNode {
    AVLNode leftChild;
    int nodeValue;
    AVLNode rightChild;
    int balanceFactor;
    
    public AVLNode(int newNodeValue){
        this.nodeValue = newNodeValue;
        this.leftChild = null;
        this.rightChild = null;
        this.balanceFactor = 0;
    }
}
