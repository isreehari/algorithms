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
public class BigO {
    private int[] theArray;
    private int arraySize;
    private int itemsArray = 0;
    private long startTime;
    private long endTime;
    
    public BigO(int arraySize){
        this.arraySize = arraySize;
        theArray = new int[this.arraySize];
    }
    
    public void addItemToArray(int item){
       this.theArray[this.itemsArray++] = item;
    }
    
    public void setStartTime(long startTime){
        this.startTime = startTime;
    }
    
    public void setEndTime(long endTime){
        this.endTime = endTime; 
    }
    
    public long getStatrTime(){
        return this.startTime; 
    }
    
    public long getEndTime(){
        return this.endTime;
    }
    
    public int[] getArray(){
        return this.theArray;
    }
    
    public int getArraySize(){         
        return this.arraySize;
    }
    
    
    
}
