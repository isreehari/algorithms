package com.isreehari.collection;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NavigableMap<Float, String> navMap = new TreeMap<Float, String>();
		
		navMap.put(01.30F, "F1");
		navMap.put(02.00F, "F2");
		navMap.put(00.30F, "F3");
		navMap.put(00.45F, "F4");
		navMap.put(01.00F, "F5");
		navMap.put(03.00F, "F6");
		
		System.out.println(navMap);
		
		System.out.println("First Flight Before 00:50F");
		System.out.println(navMap.ceilingEntry(01.30F));
		System.out.println(navMap.floorEntry(01.00F));
		
		System.out.println(navMap.higherEntry(01.00F));
		
		System.out.println(navMap.lowerEntry(01.00F));
		
		
		
		

	}

}
