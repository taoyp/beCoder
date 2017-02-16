package com.taoyp.pattern.decorator;

public class ShapeDecorator {
	public Shape shape;
	
	public ShapeDecorator(Shape shape){
		this.shape = shape;
	}
	
	public void draw(){
		shape.draw();
	}
}
