package com.taoyp.pattern.decorator;

public class RedShapeDecorator extends ShapeDecorator{

	public RedShapeDecorator(Shape shape){
		super(shape);
	}
	
	public void draw(){
		shape.draw();
		this.setRedBorder();
	}
	public void setRedBorder(){
		System.out.println("Border Corlor: Red");
	}
}
