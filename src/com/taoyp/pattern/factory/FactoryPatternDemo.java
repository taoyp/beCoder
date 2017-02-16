package com.taoyp.pattern.factory;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShapeFactory sf = new ShapeFactory();
		sf.getShape("circle").draw();
		sf.getShape("rectangle").draw();
		sf.getShape("square").draw();
		
		IProvider provider = new CircleProvider();
		Shape shape = provider.producer();
		shape.draw();
		
		provider = new RectangleProvider();
		shape = provider.producer();
		shape.draw();
		
		provider = new SquareProvider();
		shape = provider.producer();
		shape.draw();
	}

}
