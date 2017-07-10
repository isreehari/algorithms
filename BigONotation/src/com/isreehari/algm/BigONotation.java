/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm;

/**
 *
 * @author sinukoll
 */
public class BigONotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        // TODO code application logic here
        
        BigO thisBigO = new BigO(1000);
        
        System.out.println("*************** Order 1  *********************");
        
        thisBigO.setStartTime(System.currentTimeMillis());
        thisBigO.addItemToArray(1);
        thisBigO.setEndTime(System.currentTimeMillis());
        
        System.out.println( thisBigO.getEndTime() -  thisBigO.getStatrTime());        
        System.out.println("*************** End of order 1****************************");
        
        System.out.println("*************** Recursive function  *********************");
            RecursiveTimeCx thisRecTimeCx = new RecursiveTimeCx();
            int outPut = thisRecTimeCx.recursive(4);
            System.out.println(outPut);
        System.out.println("*************** End Recursive function 1****************************");
    }
    
}
