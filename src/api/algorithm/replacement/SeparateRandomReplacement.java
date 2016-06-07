package api.algorithm.replacement;

import api.model.individual.Individual;

import java.util.List;

public class SeparateRandomReplacement implements ReplacementAlgorithm{

    private int numberOfSelectedIndividuals;

    public SeparateRandomReplacement(int numberOfSelectedIndividuals){
        this.numberOfSelectedIndividuals=numberOfSelectedIndividuals;
    }

    @Override
    public void replace(List<Individual> newIndividuals, List<Individual> poblation) {

        for(int i=0;i<numberOfSelectedIndividuals;i++){
            int poblationIndex = (int)(poblation.size()*Math.random());
            poblation.remove(poblationIndex);

            int newIndividualsIndex = (int)(newIndividuals.size()*Math.random());
            poblation.add(newIndividuals.get(newIndividualsIndex));
        }

    }

}
