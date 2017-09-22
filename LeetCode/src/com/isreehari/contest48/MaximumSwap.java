/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.contest48;
import java.util.ArrayList;
/**
 *
 * @author sinukoll
 */
public class MaximumSwap {
    public static void main(String[] args){
        MaximumSwap maximumSwap = new MaximumSwap();
        System.out.println(maximumSwap.getMaximumSwap(99901));
    }
    
    public int getMaximumSwap(int num) {
        ArrayList<Integer> numArrayList = new ArrayList<Integer>();
        
        int temp = num;
        int index = 0, tempIndex = 0, maxIndex = 0, maxValue = -1, newValue = 0 , swapingIndex = -1;
        String numString = new String();
        
        while(temp > 0){
            newValue = temp % 10;
            if( maxValue < newValue ){                
                maxValue = newValue;               
                maxIndex = index;
            }else{
                if(swapingIndex == -1)
                    swapingIndex = index;
                else
                    if(numArrayList.get(swapingIndex) > newValue)
                        swapingIndex = index;
            }
                
            numArrayList.add(index, newValue);
            index++;
            temp = temp / 10;            
        } // end of while loop
         index = index - 1;
        
        temp = numArrayList.get(swapingIndex);
        numArrayList.set(swapingIndex,numArrayList.get(maxIndex));
        numArrayList.set(maxIndex,temp);
        
        while( index >= 0){
            numString += numArrayList.get(index);
            index--;
        }
        
        maxValue = Integer.parseInt(numString);
        
        return maxValue > num ? maxValue: num;
        
    }
}
