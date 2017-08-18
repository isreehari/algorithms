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
public class RadixSortNode {
    public int nodeValue;
    public RadixSortNode nextNode;
    
    public RadixSortNode(){        
        this.nextNode = null;
    }
    
    public RadixSortNode(int newNodeValue){
        this();
        this.nodeValue = newNodeValue;
    }
    
}
