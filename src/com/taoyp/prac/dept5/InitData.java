package com.taoyp.prac.dept5;

public class InitData {
	int i;
	
	public InitData(){
		System.out.println(i);
		i = 7;
		System.out.println(i);
	}
	
	public static void main(String[] args){
		new InitData();
	}

}
