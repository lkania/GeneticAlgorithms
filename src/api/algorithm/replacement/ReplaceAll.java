package api.algorithm.replacement;

import java.util.List;

import api.model.individual.Individual;

public class ReplaceAll implements ReplacementAlgorithm {

	@Override
	public void replace(List<Individual> mutatedIndividuals, List<Individual> poblation) {
		poblation.clear();
		poblation.addAll(mutatedIndividuals);
		
	}

}
