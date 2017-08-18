/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author sinukoll
 */
public class BaseConversion {
    public static void main(String[] args){
        InputStreamReader inSReader = new InputStreamReader(System.in);
        BufferedReader buffReader = new BufferedReader(inSReader);
        try{
            int givenNumber = Integer.parseInt(buffReader.readLine());            
            int baseNumber = Integer.parseInt(buffReader.readLine());
            BaseConversion baseConversion = new BaseConversion();
            
            baseConversion.convertDecemalToBinary(givenNumber);
            System.out.println();
            
            baseConversion.convertBase(givenNumber, baseNumber);
            System.out.println();
            
            baseConversion.convertBase(givenNumber, 2);
            System.out.println();
            
            baseConversion.convertBase(givenNumber, 8);
            System.out.println();
            
            baseConversion.convertBase(givenNumber, 16);
            System.out.println();
            
            
            buffReader.close();
            inSReader.close();
            
        }catch(IOException ex){
            System.out.println(ex);
        }
        
        
        
        
                
                
        
    }
    
    public void convertDecemalToBinary(int givenNumber){        
          if( givenNumber == 0)
              return;          
          this.convertDecemalToBinary(givenNumber/2);
          System.out.print(givenNumber%2 + " ");        
    }
    
    public void convertBase(int givenNumber, int baseNumber){
         if(givenNumber == 0)
             return;
         this.convertBase(givenNumber / baseNumber , baseNumber);
         int remainder = givenNumber % baseNumber;
         if( remainder  < 10)
             System.out.print(remainder + " ");
         else
             System.out.print((char) (remainder-10+'A'));
    }
    
}
