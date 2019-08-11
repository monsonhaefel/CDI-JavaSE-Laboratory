package exp.labs.inject.beans;

import javax.inject.Inject;

import exp.labs.inject.annotations.Pi_Prdcr;

public class BasicBean {
	
	@Inject
	public int myValue;
	
	@Inject
	@Pi_Prdcr
	public float myFloat;
	
	
}
