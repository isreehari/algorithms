/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm.sort;

/**
 *
 * @author sinukoll
 */
public class AddressCalculationSortNode {
    public int nodeValue;
    public AddressCalculationSortNode nextNode;
    
    public AddressCalculationSortNode(){        
        this.nextNode = null;
    }
    
    public AddressCalculationSortNode(int newNodeValue){
        this();
        this.nodeValue = newNodeValue;
    }
}
