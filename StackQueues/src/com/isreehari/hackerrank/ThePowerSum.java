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
public class ThePowerSum {
    public int count = 0;
    public static void main(String[] agrs){
        Scanner inputScanner = new Scanner(System.in);
        int givenNumber = inputScanner.nextInt();
        int nThPower = inputScanner.nextInt();        
        int initial = 1;
        
        ThePowerSum  thePowerSum = new ThePowerSum();
        thePowerSum.getPowerSum(initial, nThPower, givenNumber);            
        
        System.out.println(thePowerSum.count);        
        inputScanner.close();
    }
    
    
    public int getPowerSum(int initial, int nThPower, int givenNumber){
        
        int sum = (this.getNThPower(initial,nThPower) + this.getNThPower(initial+1, nThPower));            
        if( sum > givenNumber ) // Base case sum > givenNumber return
           return 0;
        
        if( sum == givenNumber)
           this.count++;
          
        return this.getPowerSum(initial+1,nThPower, givenNumber) + this.getPowerSum(initial+2,nThPower, givenNumber);
    }
    
    
    public int getNThPower(int givenNumber, int power){        
        if(power == 0)  // Base case  N = 1 then return 1
            return 1;        
        return givenNumber * this.getNThPower(givenNumber, power-1); // Recursive case N * N-1
    }
    
    
    
}
