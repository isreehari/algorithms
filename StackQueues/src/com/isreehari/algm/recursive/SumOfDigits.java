/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm.recursive;
import java.util.Scanner;
/**
 *
 * @author sinukoll
 */
public class SumOfDigits {
    public static void main(String... args){
        Scanner inputScanner = new Scanner(System.in);
        int inputNumber = inputScanner.nextInt();
        SumOfDigits sumOfDigits = new SumOfDigits();
        System.out.println(sumOfDigits.calSumOfDigits(inputNumber));        
        inputScanner.close();
    }
    
    public int calSumOfDigits(int givenNumber){
        
        if(givenNumber == 0)
            return 0;
        
        return givenNumber%10 + this.calSumOfDigits(givenNumber/10);
        
    }
}
