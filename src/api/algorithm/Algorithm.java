package api.algorithm;

import java.util.List;

import api.RandomNumbers;
import api.model.individual.Individual;

public abstract class Algorithm {

	public Individual getRandomIndividual(List<Individual> individuals){
		int index = (int)(RandomNumbers.getInstance().getRandomNumber()*individuals.size());
		
		return individuals.get(index);
	}
	
}
