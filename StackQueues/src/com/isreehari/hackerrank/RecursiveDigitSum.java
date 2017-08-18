/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.hackerrank;
import java.util.Scanner;
/**
 *
 * @author sinukoll
 */
public class RecursiveDigitSum {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);        
        Long givenNumber = inputScanner.nextLong();
        int kTimes = inputScanner.nextInt();  
       // int tempTimes = kTimes;
        //String composedStr = new String();        
        RecursiveDigitSum recursiveDigitSum = new RecursiveDigitSum();        
        System.out.println(recursiveDigitSum.getSuerDigit(kTimes,0, givenNumber));
        
        inputScanner.close();
    }
    
    public int getSuerDigit(int kTimes, int sum, Long givenNumber){         
           if(givenNumber == 0){
                   if(sum / 10 > 0){
                       givenNumber = (long)sum;
                       sum = 0;
                   }else{
                       if(kTimes == 0){
                           return sum;
                       }else{
                           sum *= kTimes;
                            if(sum / 10 > 0)
                            {
                                givenNumber = (long) sum;
                                sum = 0;
                                kTimes = 0;
                            }else
                            return sum;
                       }
                       
                   }
           }else{
               sum += givenNumber % 10;
           }
           
        return this.getSuerDigit(kTimes, sum, givenNumber/10);
    }
}
