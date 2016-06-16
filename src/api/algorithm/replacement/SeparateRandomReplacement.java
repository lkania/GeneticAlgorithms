package api.algorithm.replacement;

import java.util.List;

import api.RandomNumbers;
import api.model.individual.Individual;

public class SeparateRandomReplacement implements ReplacementAlgorithm{

    private int numberOfSelectedIndividuals;

    public SeparateRandomReplacement(int numberOfSelectedIndividuals){
        this.numberOfSelectedIndividuals=numberOfSelectedIndividuals;
    }

    @Override
    public void replace(List<Individual> newIndividuals, List<Individual> poblation) {

        for(int i=0;i<numberOfSelectedIndividuals;i++){
            int poblationIndex = (int)(poblation.size()*RandomNumbers.getInstance().getRandomNumber());
            poblation.remove(poblationIndex);

            int newIndividualsIndex = (int)(newIndividuals.size()*RandomNumbers.getInstance().getRandomNumber());
            poblation.add(newIndividuals.get(newIndividualsIndex));
        }

    }

}
