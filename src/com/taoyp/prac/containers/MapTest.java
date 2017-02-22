package com.taoyp.prac.containers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map mapI = new TreeMap();
		mapI.put(1, "aa");
		mapI.put(3, "bb");
		mapI.put(2, "cc");
		mapI.put(5, "dd");
		
		System.out.println(mapI);
		
		Map mapT = new HashMap();
		mapT.put(1, "aa");
		mapT.put(3, "bb");
		mapT.put(2, "cc");
		mapT.put(5, "dd");
		
		System.out.println(mapT);
	}

}
