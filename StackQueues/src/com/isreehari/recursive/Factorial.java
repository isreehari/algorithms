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
public class Factorial {
    public static void main(String... agrs){
        Scanner inputScanner = new Scanner(System.in);
        int givenNumber = inputScanner.nextInt();
        inputScanner.close();
        Factorial factorial = new Factorial();        
        System.out.println(factorial.getFactorial(givenNumber));
    }
    
    public int getFactorial(int givenNumber){        
        if(givenNumber == 0)
            return 1;    
            
        return givenNumber * getFactorial(givenNumber-1);
    }
}
