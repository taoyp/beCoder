package com.taoyp.pattern.factory;

public class RectangleProvider implements IProvider {

	@Override
	public Shape producer() {
		// TODO Auto-generated method stub
		return new Rectangle();
	}

}
