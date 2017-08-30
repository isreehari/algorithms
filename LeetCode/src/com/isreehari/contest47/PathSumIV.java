/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.contest47;

import java.util.Scanner;
import java.util.Stack;
import java.util.Iterator;
import java.math.*;

/**
 *
 * @author sinukoll
 */
public class PathSumIV {
    public Stack<Integer> currentStack = new Stack<Integer>();
    public int totalSum = 0;
    public int pathSum(int[] nums) {       
        int significant1,significant2,significant3;
        significant1 =significant2 =significant3 = 0;     
        int newValue = 0;
       
        int[] treeArray = new int[34];
        int treeIndex = 0;
        
        for(int index = 1; index< treeArray.length; index++){
            treeArray[index] = -1;
        }
        
        
        for(int index =0; index< nums.length; index++){
            newValue = nums[index]; // 123            
            significant1 = newValue % 10; // 3 - 123
            newValue = newValue / 10;             
            significant2 = newValue % 10; // 2 - 12
            newValue = newValue / 10;            
            significant3 = newValue % 10; // 1 - 1            
            
            treeIndex = ((int)Math.pow(2,(significant3-1)) + (significant2)) - 1 ;
            
            treeArray[treeIndex] = significant1;
            
        }
        
//            for(int index = 1; index< 17; index++){
//                System.out.println( index + " --> " +treeArray[index] + " ");
//             }
            
            
           
         
        
        
        this.getPathSumInOrder(treeArray, 17, 1);
        return this.totalSum;
    }
    
    public void getPathSumInOrder(int[] nums, int arraySize, int rootIndex){
     
        
        
        if( rootIndex > arraySize || nums[rootIndex] == -1 )
            return;
        
        int leftChildIndex = 2 * rootIndex ;
        int rightChildIndex = leftChildIndex + 1;
       
        
        this.currentStack.push(rootIndex);
        this.getPathSumInOrder(nums, arraySize, leftChildIndex);
        int newIndex = 0 , removeIndex = 0;

        
        if(nums[leftChildIndex] == -1 && nums[rightChildIndex] == -1){
             Iterator<Integer> stackNode = this.currentStack.iterator();
             while(stackNode.hasNext()){
                 newIndex = stackNode.next();
                 this.totalSum = this.totalSum + nums[newIndex];
             }             
         }         
        this.getPathSumInOrder(nums,arraySize, rightChildIndex);
        this.currentStack.pop(); 
            
        
       
    }
    
   
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arraySize  = in.nextInt();
        int[] nums = new int[arraySize];
        
        PathSumIV  pathSumIV = new PathSumIV();
        
         for(int arr_i=0; arr_i < arraySize; arr_i++){
            nums[arr_i] = in.nextInt();
        }
         
        System.out.println(pathSumIV.pathSum(nums));
        
       
        
        in.close();
    }
     
     
    
}

