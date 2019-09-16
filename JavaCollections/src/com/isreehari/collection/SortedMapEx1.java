package com.isreehari.collection;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortedMap<Integer, String> sortedMap1 = new TreeMap<Integer, String>();
		
		sortedMap1.put(517, "Sreehari");
		sortedMap1.put(518, "Shantiswar");
		sortedMap1.put(516, "Prashanth");
		System.out.println(sortedMap1);
		
		System.out.println(sortedMap1.firstKey());
		System.out.println(sortedMap1.lastKey());
		System.out.println(sortedMap1.headMap(517));
		System.out.println(sortedMap1.tailMap(517));
		System.out.println(sortedMap1.subMap(516, 517));
		
		
		
		SortedMap<Student, String> sortedMap2 = new TreeMap<Student, String>();
		
		sortedMap2.put(new Student(517, "Sreehari"), "CSE");
		sortedMap2.put(new Student(516, "Prashanth"), "CSE");
		sortedMap2.put(new Student(518, "Shantiswar"), "CSE");
		System.out.println(sortedMap2);
		
		

	}

}


class Student implements Comparable<Student>{
	
	int rollNumber;
	String name;
	
	public Student(int newStdRollNumber, String newStdName) {
		this.rollNumber = newStdRollNumber;
		this.name = newStdName;
	}
	
	public String toString() {
		return this.name + " - " + this.rollNumber;
	}
	
	@Override
	public int compareTo(Student stdObj) {
		
		if(this.rollNumber > stdObj.rollNumber)
			return 1;
		else
			if(this.rollNumber < stdObj.rollNumber)
				return -1;		
		
		return 0;
	}
}
