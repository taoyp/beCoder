package com.taoyp.pattern.factory;

public class ShapeFactory {

	public Shape getShape(String shape){
		if("circle".equals(shape)){
			return new Circle();
		}else if("rectangle".equals(shape)){
			return new Rectangle();
		}else if("square".equals(shape)){
			return new Square();
		}
			
		return null;
	}
}
