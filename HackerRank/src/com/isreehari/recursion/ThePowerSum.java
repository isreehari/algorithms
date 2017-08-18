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
public class ThePowerSum {
    public int count = 0;
    public static void main(String[] agrs){
        Scanner inputScanner = new Scanner(System.in);
        int givenNumber = inputScanner.nextInt();
        int nThPower = inputScanner.nextInt();        
        int initial = 1;
        int maximum = 1;
        
        ThePowerSum  thePowerSum = new ThePowerSum();
        
        while(thePowerSum.getNThPower(maximum, nThPower) <= givenNumber)
            maximum++;
        
        if(maximum > 1)
            maximum--;        
        
        System.out.println(thePowerSum.getPowerSum(givenNumber, nThPower, 1));            
        inputScanner.close();
    }
    
    
    public int getPowerSum(int total, int nThPower, int initialNumber){
        
//        int a = this.getNThPower(initial,nThPower);
//        int b = this.getNThPower(secondValue,nThPower);            
//        int sum = a + b;
//        
//        System.out.println(initial + " + " +(secondValue) + " = " + sum);    
//        
//        if( sum > givenNumber ) // Base case sum > givenNumber return
//           return 0;
//        
//        if( sum == givenNumber){
//            this.count++;
//            return 0;
//        }
//        
//        if( secondValue == maximum){
//            initial = initial + 1;
//            secondValue = initial;
//        }

//        if(initial > maximum)
//            return 0;
//
//        int sum =  0  ;
//        
//        System.out.println(initial + " --> " + (initial + this.getPowerSum(initial+1,maximum, nThPower, givenNumber)));
//          
//        return sum;
        int value = (total - this.getNThPower(initialNumber, nThPower));
        
        if(value < 0 ) return 0;
        else if( value == 0) return 1;
        else return this.getPowerSum(value, nThPower, initialNumber+1) + this.getPowerSum(total,nThPower, initialNumber+1);

    }
    
    
    public int getNThPower(int givenNumber, int power){        
        if(power == 0)  // Base case  N = 1 then return 1
            return 1;        
        return givenNumber * this.getNThPower(givenNumber, power-1); // Recursive case N * N-1
    }
    
    
    
}
