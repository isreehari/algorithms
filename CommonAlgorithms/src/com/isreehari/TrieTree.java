/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author sinukoll
 */

class TrieNode{
    Map<Character, TrieNode> childNode;
    boolean endOfWord;
    
    public TrieNode(){
        this.childNode = new HashMap<Character, TrieNode>();
        this.endOfWord = true;
    }
    
}

public class TrieTree {
    
}
