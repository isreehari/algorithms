/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.warmup;
import java.util.Scanner;
/**
 *
 * @author sinukoll
 */
public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        long min = 0;
        long max = 0;
        long sum = 0;       
        long newValue = 0;
        
        for(int arr_i=0; arr_i < 5; arr_i++){
            newValue = in.nextInt();
            
            if(arr_i == 0){
                min = max = newValue;
            }
            else{
                if(newValue < min)
                min = newValue;
                else
                if(newValue > max){
                    max = newValue;
                }
            }
            
            sum =  sum + newValue;
        }
        
        System.out.println((sum - max) +" "+  (sum - min)); // Min sum and Max sum
        
        in.close();
    }
}
