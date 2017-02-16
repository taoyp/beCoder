package com.taoyp.pattern.decorator;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Circle circle = new Circle();
		circle.draw();
		
		RedShapeDecorator redCircle = new RedShapeDecorator(new Circle());
		RedShapeDecorator redRect = new RedShapeDecorator(new Rectangle());
		
		redCircle.draw();
		redRect.draw();
	}

}
