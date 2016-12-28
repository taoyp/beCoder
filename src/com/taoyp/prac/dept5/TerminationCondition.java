package com.taoyp.prac.dept5;

public class TerminationCondition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book novel = new Book(true);
		novel.checkIn();
		
		new Book(true);
		System.gc();
	}

}

class Book{
	public boolean checkOut = false;
	
	public Book(boolean checkOut){
		this.checkOut = checkOut;
	}
	
	public void checkIn(){
		this.checkOut = false;
	}
	
	protected void finalize(){
		if(this.checkOut){
			System.out.println("Error: checked out!!");
		}
	}
}
