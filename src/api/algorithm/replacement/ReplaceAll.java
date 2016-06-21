package api.algorithm.replacement;

import java.util.List;

import api.algorithm.selection.SelectionAlgorithm;
import api.model.individual.Individual;

public class ReplaceAll implements ReplacementAlgorithm {

	@Override
	public void replace(List<Individual> mutatedIndividuals, List<Individual> poblation, SelectionAlgorithm selectionAlgorithmForReplacement) {
		poblation.clear();
		poblation.addAll(mutatedIndividuals);
		
	}


}
