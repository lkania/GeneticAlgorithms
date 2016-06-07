package api.algorithm.replacement;

import api.model.individual.Individual;

import java.util.List;

public interface ReplacementAlgorithm {

	public void replace(List<Individual> mutatedIndividuals, List<Individual> poblation);

}
