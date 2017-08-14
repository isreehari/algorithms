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
public class Print1ToNRecursively {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);        
        int nNumber = Integer.parseInt(inputScanner.nextLine());
        
        Print1ToNRecursively print1ToNRecursively = new Print1ToNRecursively();
         print1ToNRecursively.printNNumbers1(nNumber);        
         System.out.println();
         print1ToNRecursively.printNNumbers2(nNumber);
         System.out.println();
        inputScanner.close();
    }
    
    public void printNNumbers1(int givenNumber){
          if( givenNumber == 0)
              return;
          this.printNNumbers1(givenNumber-1);
          System.out.print(givenNumber +" ");
    }
    
    public void printNNumbers2(int givenNumber){
        if(givenNumber == 0 )
             return;
        
        System.out.print(givenNumber+" ");
        this.printNNumbers2(givenNumber-1);
    }
}
