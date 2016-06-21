package api.algorithm.replacement;

import java.util.ArrayList;
import java.util.List;

import api.algorithm.selection.SelectionAlgorithm;
import api.model.individual.Individual;

public class RandomBetweenAllReplacement implements ReplacementAlgorithm {


    @Override
    public void replace(List<Individual> newIndividuals, List<Individual> poblation,SelectionAlgorithm selectionAlgorithmForReplacement) {
        List<Individual> newPoblation;

        List<Individual> allIndividuals = new ArrayList<Individual>(newIndividuals.size() + poblation.size());
        allIndividuals.addAll(poblation);
        allIndividuals.addAll(newIndividuals);
        
        newPoblation=selectionAlgorithmForReplacement.select(allIndividuals);
        
        poblation.clear();
        poblation.addAll(newPoblation);
    }

}
