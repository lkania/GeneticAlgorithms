package algorithm.crossover;

import java.util.List;

import algorithm.fitness.FitnessAlgorithm;
import model.individual.Individual;

public abstract class CrossoverAlgorithm {

	public List<Individual> crossover(List<Individual> selectedIndividualsForCrossover){
		
	}
	
	
	public abstract void cross(Individual i1,Individual i2,List<Individual> ans);
	
}
