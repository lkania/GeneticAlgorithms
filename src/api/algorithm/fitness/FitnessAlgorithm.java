package api.algorithm.fitness;

import api.model.individual.Individual;

public interface FitnessAlgorithm {

	public double getFitness(Individual individual);

}
