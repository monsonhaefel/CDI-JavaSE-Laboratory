package exp.labs.inject.producers;

import javax.enterprise.inject.Produces;

import exp.labs.inject.annotations.Pi_Prdcr;

public class PiProducer {

	@Produces @Pi_Prdcr
	private float π = 3.14f;
}
