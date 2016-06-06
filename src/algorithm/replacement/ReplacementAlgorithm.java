package algorithm.replacement;

import java.util.List;

import algorithm.fitness.FitnessAlgorithm;
import model.individual.Individual;
import model.poblation.Poblation;

public interface ReplacementAlgorithm {

	Poblation replace(List<Individual> mutatedIndividuals, Poblation poblation, FitnessAlgorithm fitnessAlgorithm);

}
