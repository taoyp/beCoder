package com.taoyp.pattern.factory;

public class CircleProvider implements IProvider {

	@Override
	public Shape producer() {
		// TODO Auto-generated method stub
		return new Circle();
	}

}
