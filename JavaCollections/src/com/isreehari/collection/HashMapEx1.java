package com.isreehari.collection;
import java.util.*;


public class HashMapEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>(2);
		HashMap<String, Integer> map3 = new HashMap<String, Integer>(2,0.75f);
		
		System.out.println(map1.isEmpty());
		map1.put("Sreehari", 20);
		map1.put("Mani", 30);		
//		System.out.println(map1.get("Sree"));
//		System.out.println(map1.containsKey("Sreehari"));
//		System.out.println(map1.containsValue(20));
		Set<String> keySet = map1.keySet();
		Set<Map.Entry<String, Integer>> entrySet = map1.entrySet();
//		
//		Iterator itr = entrySet.iterator();
//		
//		while(itr.hasNext()) {
//			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)itr.next();
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//			entry.setValue(entry.getValue()+1);
//			System.out.println(entry.getValue()+1);			
//		}
//		
		System.out.println(map1.remove("Sreehari"));
		System.out.println(map1.getOrDefault("Sree", -1));
		System.out.println(map1.getOrDefault("Sree", -1));
		

	}

}
 