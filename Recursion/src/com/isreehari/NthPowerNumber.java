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
public class NthPowerNumber {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        float givenNumber = inputScanner.nextFloat();
        int powerNumber = inputScanner.nextInt();
                
        NthPowerNumber nThPowerNumber = new NthPowerNumber();
         System.out.println(nThPowerNumber.nThPower(givenNumber, powerNumber));
        inputScanner.close();
    }
    
    public float nThPower(float givenNumber, int powerNumber){        
        if( powerNumber == 0)
            return 1;
        
        return givenNumber * this.nThPower(givenNumber, powerNumber-1);
    }
}
