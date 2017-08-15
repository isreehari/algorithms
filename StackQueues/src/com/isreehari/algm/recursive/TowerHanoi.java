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
public class TowerHanoi {
     public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int givenNumber = inputScanner.nextInt();
        TowerHanoi towerHanoi = new TowerHanoi();
          towerHanoi.doTowerHanoi(givenNumber, 'A', 'B', 'C');
        System.out.println();
         
        inputScanner.close();
    }
    
    public void doTowerHanoi(int givenNumber, char source, char temp, char destination){        
        
        if(givenNumber == 1){
            System.out.println("Move Disk "+ givenNumber + " from " + source + "-->" + destination);
            return;
        }
        
        this.doTowerHanoi(givenNumber-1, source, destination, temp);
        System.out.println("Move Disk " + givenNumber + " from "+  source + "-->" + destination);
        this.doTowerHanoi(givenNumber-1, temp, source, destination);
        
        
    }  
    
}
