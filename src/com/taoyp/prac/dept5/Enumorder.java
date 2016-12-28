package com.taoyp.prac.dept5;

public class Enumorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Spiciness s:Spiciness.values()){
			System.out.println(s+",ordinal "+s.ordinal());
		}
		
		Burrito 
		plain = new Burrito(Spiciness.NOT),
		greenChile = new Burrito(Spiciness.MEDIUM),
		jalapeno = new Burrito(Spiciness.HOT);
		
		plain.describer();
		greenChile.describer();
		jalapeno.describer();
	}

}

class Burrito{
	Spiciness degree;
	
	public Burrito(Spiciness degree){
		this.degree = degree;
	}
	
	public void describer(){
		System.out.print("This burrito is :");
		switch(degree){
		case NOT: System.out.println("not spicy at all");
		break;
		case MILD: 
		case MEDIUM: System.out.println("a little hot");
		break;
		case HOT: 
		case FLAMING :
		default:System.out.println("maybe too hot");
		}
	}
}
