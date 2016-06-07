package api.algorithm;

import api.model.individual.Individual;

import java.util.List;

public abstract class Algorithm {

	public Individual getRandomIndividual(List<Individual> individuals){
		int index = (int)Math.random()*individuals.size();
		
		return individuals.get(index);
	}
	
}
