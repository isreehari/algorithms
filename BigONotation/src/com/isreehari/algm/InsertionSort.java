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
public class InsertionSort {
    
    private int[] listArray;
    private int arraySize;
    
    public InsertionSort(){        
    }
    
    public InsertionSort(int[] array){        
        this.listArray = array;        
    }
    
    public int[] doIncrementSort(){
            int i = 0;
            int key = 0;
            for(int j = 1; j < this.listArray.length; j++ ){                    
                    key = this.listArray[j];
                    i = j - 1;
                    
                    while(i >= 0 && this.listArray[i] > key){                            
                            this.listArray[i+1] = this.listArray[i];                            
                            i = i - 1;                        
                    }
                this.listArray[i+1] = key;
                
            }
        
        return this.listArray;
    }
    
    public int[] doDecrementSort(){
        
            int i = 0;
            int key = 0;
            for(int j = 2; j < this.listArray.length; j++){                
                key = this.listArray[j];
                i = j-1;
                
                while(i >= 0 && this.listArray[i] < key){
                    this.listArray[i+1] = this.listArray[i];                    
                    i--;
                }                
                this.listArray[i+1] = key;               
            }           
        
        return this.listArray;
    }
    
    
}
