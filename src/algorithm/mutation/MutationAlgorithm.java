package algorithm.mutation;

import java.util.List;

import algorithm.fitness.FitnessAlgorithm;
import model.individual.Individual;

public interface MutationAlgorithm {

	List<Individual> mutate(List<Individual> crossoveredIndividuals);

}
