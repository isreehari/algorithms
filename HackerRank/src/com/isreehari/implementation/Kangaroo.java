/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.implementation;
import java.util.Scanner;
/**
 *
 * @author sinukoll
 */
public class Kangaroo {
    
     static String getKangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
        
        //        If the two kangaroos met, then there woulde be an integer n such that x1 + n * v1 = x2 + n * v2. Subtracting x1 from both sides, we get that n * v1 = x2 - x1 + n * v2. Then we subtract n * v2 from both sides and we get n * v1 - n * v2 = x2 - x1. Factoring out n from the left side of the equation, n * (v1 - v2) = (x2 - x1). We can the divide both sides by (v1 - v2) and we get (x2 - x1) / (v1 - v2). If this is an integer, then (x2 - x1) % (v1 - v2) has to equal 0.
        
         if(v2 > v1)
            return "NO";
        else        
        if((v1-v2) == 0)
            return "NO";
        else
        if((x2-x1) % (v1-v2) == 0) 
            return "YES";
        


        
        return "NO";
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = getKangaroo(x1, v1, x2, v2);
        System.out.println(result);
        in.close();
    }
}
