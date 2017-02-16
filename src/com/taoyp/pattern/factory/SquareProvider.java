package com.taoyp.pattern.factory;

public class SquareProvider implements IProvider {

	@Override
	public Shape producer() {
		// TODO Auto-generated method stub
		return new Square();
	}

}
