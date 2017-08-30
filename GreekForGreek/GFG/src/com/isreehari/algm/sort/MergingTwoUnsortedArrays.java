/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm.sort;
import java.util.Scanner;
/**
 *
 * @author sinukoll
 */
public class MergingTwoUnsortedArrays {
    
    public static void main (String[] args) {
		//code
	    Scanner inputScanner = new Scanner(System.in);
	    int numberTestCases = inputScanner.nextInt();
	    int arraySize1 = 0;
	    int arraySize2 = 0;
	    int[] array1, array2,tempArray;
	    
	    MergingTwoUnsortedArrays mergingTwoUnsortedArrays = new MergingTwoUnsortedArrays();
	    
	    while(numberTestCases > 0){
	        
	        arraySize1 = inputScanner.nextInt();
	        arraySize2 = inputScanner.nextInt();
	        
	        array1 = new int[arraySize1];
	        array2 = new int[arraySize2];
	        
	        for(int currentIndex = 0; currentIndex < arraySize1; currentIndex++)
	        array1[currentIndex] = inputScanner.nextInt();
	        
	        for(int currentIndex = 0; currentIndex < arraySize2; currentIndex++)
	        array2[currentIndex] = inputScanner.nextInt();
	        
	        tempArray = new int[arraySize1];
	        array1 = mergingTwoUnsortedArrays.doMergeSort(array1,tempArray, 0, arraySize1-1);
	        
	        tempArray = new int[arraySize2];
	        array2 = mergingTwoUnsortedArrays.doMergeSort(array2,tempArray, 0, arraySize2-1);
	        
	        tempArray = new int[arraySize1+arraySize2];
	        
	        tempArray = mergingTwoUnsortedArrays.doMerge(array1,array2,arraySize1-1,arraySize2-1);
	        
	        for(int index = 0; index < tempArray.length; index++)
	         System.out.print(tempArray[index]+" ");
	         
	         System.out.println();
	        
	        
	        
	        numberTestCases--;
	    }
	
		inputScanner.close();
		
	}
	
	public int[] doMergeSort(int[] givenArray1, int[] tempArray1, int low, int up){
        
        if(low == up) // one element
            return givenArray1;
        
        int mid = (low + up) / 2;
        
        this.doMergeSort(givenArray1,tempArray1,low,mid);
        this.doMergeSort(givenArray1,tempArray1,mid+1,up);        
        tempArray1 =  this.doMergeMergeSort(givenArray1, tempArray1, low, mid, mid+1,up);
        
        for(int i = low; i <= up; i++)
            givenArray1[i] = tempArray1[i];
        
        return givenArray1;
    }
    
      public int[] doMergeMergeSort(int temp1[], int[] temp2, int low1, int up1, int low2, int up2){
        
        int i = low1, j = low2, currentIndex = low1;
        
           while(i <= up1 && j <= up2 ){
                if(temp1[i] > temp1[j]){
                    temp2[currentIndex++] = temp1[j++];                    
                }else{
                    temp2[currentIndex++] = temp1[i++];
                }
            }
        
        
        while(i <= up1)
            temp2[currentIndex++] = temp1[i++];
        
        while(j <= up2)
            temp2[currentIndex++] = temp1[j++];
        
        
        return temp2;
    } 
    
    
     public int[] doMerge(int temp1[], int[] temp2, int temp1Size, int temp2Size){
        
        int i = 0, j = 0, currentIndex = 0;
        int[] temp3 = new int[temp1Size+temp2Size+2];
        
           while(i <= temp1Size && j <= temp2Size ){
                if(temp1[i] > temp2[j]){
                    temp3[currentIndex++] = temp2[j++];                    
                }else{
                    temp3[currentIndex++] = temp1[i++];
                }
            }
        
        
        while(i <= temp1Size)
            temp3[currentIndex++] = temp1[i++];
        
        while(j <= temp2Size)
            temp3[currentIndex++] = temp2[j++];
        
        
        return temp3;
    } 
    
}
