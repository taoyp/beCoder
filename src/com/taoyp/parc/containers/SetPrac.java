package com.taoyp.parc.containers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeSet默认需要为同一种类型
		Set setI = new TreeSet();
		setI.add(1);
		setI.add(3);
		setI.add(2);
		setI.add(4);
		setI.add(0);
		
		Iterator it = setI.iterator();
		while(it.hasNext()){
			System.out.print("	" + it.next());
		}
		System.out.println();
		
		Set setT = new HashSet();
		setT.add("a");
		setT.add(1);
		setT.add("b");
		setT.add("c");
		setT.add(2);
		setT.add(4);
		setT.add("d");
		it = setT.iterator();
		while(it.hasNext()){
			System.out.print("	" + it.next());
		}
		System.out.println();
		
	}

}
