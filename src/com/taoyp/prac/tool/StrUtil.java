package com.taoyp.prac.tool;

public class StrUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printStr();
		printInfo();
	}
	
	public static void printStr(){
		System.out.println(String.valueOf(true));
		System.out.println(String.valueOf('s'));
		System.out.println(String.valueOf(new int[]{1,2,3}));
		System.out.println(String.valueOf(1.11));
		System.out.println(String.valueOf(1));
		System.out.println(String.valueOf(new char[]{'a',2,3,4,5,6},2,3));
	}
	
	public static void printInfo(){
		String str = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(str.charAt(5));
		System.out.println(str.codePointAt(5));
		System.out.println(str.codePointBefore(5));
		System.out.println(str.codePointCount(5, 10));
		System.out.println(str.concat("1234"));
		System.out.println(str.contains("abc"));
		System.out.println(str.endsWith("xyz"));
		System.out.println(str.hashCode());
		System.out.println(str.indexOf(1));
		System.out.println(str.indexOf("ef"));
		System.out.println(str.isEmpty());
		System.out.println(str.getBytes());
		System.out.println(str.valueOf('c'));
		
		byte[] b = str.getBytes();
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]);
		}
	}

}
