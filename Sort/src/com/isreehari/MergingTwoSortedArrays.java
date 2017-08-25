/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari;

import java.util.Scanner;

/**
 *
 * @author sinukoll
 */
public class MergingTwoSortedArrays {
    
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        MergingTwoSortedArrays mergingTwoSortedArrays = new MergingTwoSortedArrays();
        int arraySize1 = inputScanner.nextInt();
        int[] givenArray1 = new int[arraySize1];
        for(int index = 0; index < arraySize1; index++){
            givenArray1[index] = inputScanner.nextInt();
        }
        
        givenArray1 = mergingTwoSortedArrays.doInsertionSort(givenArray1, arraySize1);
        
        int arraySize2 = inputScanner.nextInt();
        int[] givenArray2 = new int[arraySize2];
        for(int index = 0; index < arraySize2; index++){
            givenArray2[index] = inputScanner.nextInt();
        }
        
       
        givenArray2 = mergingTwoSortedArrays.doInsertionSort(givenArray2, arraySize2);
        
        
        
        int tempArraySize1 = arraySize1 + arraySize2;
        int[] tempArray1 = new int[tempArraySize1];
        tempArray1 = mergingTwoSortedArrays.doMerge(givenArray1, givenArray2, tempArray1);
        
        for(int index = 0; index < tempArraySize1; index++){
            System.out.print(tempArray1[index] + " ");
        }
        
        
        int tempArraySize2 = 6;
        int[] tempArray2 = {2,6,10, 4,5,7};
        tempArray2 = mergingTwoSortedArrays.doMergeWithSingleArray(tempArray2,0,2,3,5);
        
        for(int index = 0; index < tempArraySize2; index++){
            System.out.print(tempArray2[index] + " ");
        }
        
        
        System.out.println();
        
        
        inputScanner.close();
    }
     
     public int[] doInsertionSort(int[] givenArray, int arraySize){        
        
        int tempValue = 0;              
        int j = 0;
        for(int i = 1; i < arraySize; i++ ){                        
            tempValue = givenArray[i];
            for(j = i-1; j >=0 && givenArray[j] > tempValue; j--){
                givenArray[j+1] = givenArray[j];
            }    
            
            givenArray[j+1] = tempValue;
            
        }
        return givenArray;
    }
     
    public int[] doMerge(int a1[],int a2[], int temp[]){
        
        int i =0, j = 0, currentIndex = 0;
        
        
           while(i < a1.length && j < a2.length ){
                if(a1[i] > a2[j]){
                    temp[currentIndex++] = a2[j++];                    
                }else{
                    temp[currentIndex++] = a1[i++];
                }
            }
        
        
        while(i < a1.length)
            temp[currentIndex++] = a1[i++];
        
        while(j < a2.length)
            temp[currentIndex++] = a2[j++];
        
        
        return temp;
    } 
    
     public int[] doMergeWithSingleArray(int temp[],int low1, int up1, int low2, int up2){
        
        int i = low1, j = low2, currentIndex = 0;
        int[] temp2 = new int[temp.length];
        
        
           while(i <= up1 && j <= up2 ){
                if(temp[i] > temp[j]){
                    temp2[currentIndex++] = temp[j++];                    
                }else{
                    temp2[currentIndex++] = temp[i++];
                }
            }
        
        
        while(i <= up1)
            temp2[currentIndex++] = temp[i++];
        
        while(j <= up2)
            temp2[currentIndex++] = temp[j++];
        
        
        return temp2;
    } 
    
}
