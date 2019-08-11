package exp.beans;

import javax.inject.Inject;

import exp.annotations.Pi;

public class MyBean {
	
	@Inject
	public int myValue;
	
	@Inject
	@Pi
	public float myFloat;
}
