package api.algorithm.replacement;

import java.util.List;

import api.RandomNumbers;
import api.algorithm.selection.SelectionAlgorithm;
import api.model.individual.Individual;

public class SeparateRandomReplacement implements ReplacementAlgorithm{

    @Override
    public void replace(List<Individual> newIndividuals, List<Individual> poblation, SelectionAlgorithm selectionAlgorithmForReplacement) {

    	
    	List<Individual> newPoblation = selectionAlgorithmForReplacement.select(poblation);
    	
    	poblation.clear();
    	poblation.addAll(newPoblation);
    	poblation.addAll(newIndividuals);
    }
    

}
