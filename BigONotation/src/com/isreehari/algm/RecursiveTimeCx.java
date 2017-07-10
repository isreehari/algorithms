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
public class RecursiveTimeCx {
    
    private int totalCount = 0;
    private int numberIterations = 0; 
    
    public int recursive(int n){
        if(n <= 1)
            return 1;
        
        this.numberIterations++; 
        
        //System.out.println(this.numberIterations);        
        
        System.out.println( this.totalCount + " -> recursive("+n+")");
        
        
        return this.totalCount = recursive(n - 1) + recursive(n - 1);
    }
}
