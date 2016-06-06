package algorithm;

import java.util.List;

import model.individual.Individual;

public abstract class Algorithm {

	public Individual getRandomIndividual(List<Individual> individuals){
		int index = (int)Math.random()*individuals.size();
		
		return individuals.get(index);
	}
	
}
