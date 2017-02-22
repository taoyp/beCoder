package com.taoyp.pattern.single;

public class SingleTonN {
	private SingleTonN(){}

	private static class SingleRe{
		public static SingleTonN singleTonN = new SingleTonN();
	}
	
	public static final SingleTonN getSingleTonN(){
		return SingleRe.singleTonN;
	}
}
