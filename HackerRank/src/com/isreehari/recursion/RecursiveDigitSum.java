/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.recursion;

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
        
        RecursiveDigitSum recursiveDigitSum = new RecursiveDigitSum();        
        int firstSetSuperDigit = recursiveDigitSum.getSuerDigitFirstSet(0, givenNumber);
        System.out.println(recursiveDigitSum.getSuerDigit( 0, firstSetSuperDigit*kTimes));
        inputScanner.close();
    }
    
    public int getSuerDigitFirstSet(int sum, String givenNumber){
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
           
        return this.getSuerDigitFirstSet(sum, givenNumber);
    }
    
    public int getSuerDigit(int sum, int givenNumber){         
           if(givenNumber == 0){
                   if(sum / 10 > 0){
                       givenNumber = sum;
                       sum = 0;
                   }else{
                       return sum;
                   }
           }else{
               sum += givenNumber % 10;
           }
           
        return this.getSuerDigit(sum, givenNumber/10);
    }
    
    
}
