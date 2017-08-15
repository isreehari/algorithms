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
public class EuclidAlgGCD {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int givenNumber1 = inputScanner.nextInt();
        int givenNumber2 = inputScanner.nextInt();
                
        EuclidAlgGCD euclidAlgGCD = new EuclidAlgGCD();
         System.out.println(euclidAlgGCD.getGCD(givenNumber1, givenNumber2));
        inputScanner.close();
    }
    
    public int getGCD(int givenNumber1, int givenNumber2){        
        if( givenNumber2 == 0)
            return givenNumber1;
        
        return this.getGCD(givenNumber2, givenNumber1%givenNumber2);
    }    
}

