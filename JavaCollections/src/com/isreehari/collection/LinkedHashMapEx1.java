package com.isreehari.collection;
import java.util.Map;
import java.util.LinkedHashMap;

public class LinkedHashMapEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// LRU cache implementation
		
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>(2,1.0f,true){			
			protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
				return this.size() > 2;
			}			
		};
		
		linkedHashMap.put("Sreehari", 30);
		linkedHashMap.put("Mani", 28);
		
		System.out.println(linkedHashMap);
		linkedHashMap.get("Sreehari");	
		
		
		linkedHashMap.put("Sai", 20);
		
		System.out.println(linkedHashMap);
		
		
//		// Creating the linked hashmap and implementing 
//        // removeEldestEntry() to MAX size 
//        LinkedHashMap<Integer, String> li_hash_map =  
//        new LinkedHashMap<Integer, String>() { 
//            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) 
//            { 
//                return size() > 6; 
//            } 
//        }; 
//        // Adding elements using put() 
//        li_hash_map.put(0, "Welcome"); 
//        li_hash_map.put(1, "To"); 
//        li_hash_map.put(2, "The"); 
//        li_hash_map.put(3, "World"); 
//        li_hash_map.put(4, "Of"); 
//        li_hash_map.put(5, "geeks"); 
//  
//        System.out.println("" + li_hash_map); 
//  
//        // Adding more elements 
//        li_hash_map.put(6, "GeeksforGeeks"); 
//  
//        // Displying the map after adding one more element 
//        System.out.println("" + li_hash_map); 
//  
//        // Adding more elements 
//        li_hash_map.put(7, "Hello"); 
//  
//        // Displying the map after adding one more element 
//        System.out.println("" + li_hash_map); 
		
		
		

	}

}
