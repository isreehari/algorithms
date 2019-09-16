package com.isreehari.collection;
import java.util.*;

public class ComparatorEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] testing = new String[]{"dig1 1", "let1 a"};

        Arrays.sort(testing, new Comparator<String>(){
            public int compare(String obj1, String obj2){
                String[] subStrings1 = obj1.split(" ", 2);
                String[] subStrings2 = obj2.split(" ", 2);
                
                boolean isDigit1 = Character.isDigit(subStrings1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(subStrings2[1].charAt(0));
                
                if(!isDigit1 && !isDigit2)
                {
                    int flag = subStrings1[1].compareTo(subStrings2[1]);
                    if(flag != 0)
                        return flag;
                    else 
                        return subStrings1[0].compareTo(subStrings2[0]);
                    
                }
                
                return isDigit1 ? ( isDigit2 ? 0 : 1) : -1;
                
            }
        });

        System.out.println(testing[0]);

	}

}
