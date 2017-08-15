/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isreehari.algm.binarytree;
import java.util.Scanner;
/**
 *
 * @author sinukoll
 */
public class MainClass {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        int userChoice;
        BinaryTree mainBinaryTree = new BinaryTree();
        while(true){
            System.out.println("******************* Binary Tree *******************");
            System.out.println("*1. Build New Binary Tree                         *");
            System.out.println("*2. Display Binary Tree                           *");
            System.out.println("*0. Quit the App                                  *");
            System.out.println("******************* /Binary Tree ******************");
            System.out.print("Please enter your choice: ");
            userChoice = inputScanner.nextInt();
            switch(userChoice){
                case 1: mainBinaryTree.build(inputScanner); break;
                case 2: mainBinaryTree.display(); break;
                case 0: inputScanner.close(); System.exit(0); break;
                default: System.out.println("Your choice is wrong."); break;
            }
        }
        
        
        
    }
}
