package com.taoyp.pattern.single;

public class Singleton {

	private Singleton single;
	private Singleton(){}
	
	public Singleton getSingleton(){
		if(single==null){
			single = new Singleton();
		}
		
		return single;
	}
}
