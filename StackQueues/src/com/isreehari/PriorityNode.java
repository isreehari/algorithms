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
public class PriorityNode {
       public int nodePriority;
       public int nodeValue;
       public PriorityNode nextNode;
       
       public PriorityNode(int newNodeValue, int newNodePriority){
           this.nodeValue = newNodeValue;
           this.nodePriority = newNodePriority;
           this.nextNode = null;
       }
}
