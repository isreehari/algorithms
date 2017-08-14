/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.recursive;

import java.util.Scanner;

/**
 *
 * @author sinukoll
 */
public class FibonacciSeries {
    
     public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int givenNumber1 = inputScanner.nextInt();
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
         for(int i=0; i<= givenNumber1; i++)
            System.out.print(fibonacciSeries.getFibonacciValue(i)+ " ");
         System.out.println();
         
        inputScanner.close();
    }
    
    public int getFibonacciValue(int givenNumber){        
        if( givenNumber == 0)
            return 0;
        if(givenNumber == 1)
            return 1;        
        return this.getFibonacciValue(givenNumber-1) + this.getFibonacciValue(givenNumber-2);
        
    }  
    
}
