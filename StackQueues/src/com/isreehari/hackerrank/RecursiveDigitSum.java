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
        String givenNumber = inputScanner.next();
        int kTimes = inputScanner.nextInt();  
        int tempTimes = kTimes;
        String composedStr = new String();
        while(kTimes > 0){
            composedStr  += givenNumber;
            kTimes--;
        }
        
        RecursiveDigitSum recursiveDigitSum = new RecursiveDigitSum();        
        System.out.println(recursiveDigitSum.getSuerDigit(0, composedStr));
        
        inputScanner.close();
    }
    
    public int getSuerDigit(int sum, String givenNumber){
        int givenNumberLength = givenNumber.length();
           if(givenNumberLength == 0){
               if((sum / 10) > 0){
                   givenNumber =  String.valueOf(sum);
                   sum = 0;
               }else{
                   return sum;
               }
           }else{
               sum += Character.getNumericValue(givenNumber.charAt(givenNumberLength-1));
               givenNumber = givenNumber.substring(0, givenNumberLength-1);
           }
           
        return this.getSuerDigit(sum, givenNumber);
    }
}
