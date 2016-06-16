package api.algorithm.replacement;

import java.util.ArrayList;
import java.util.List;

import api.RandomNumbers;
import api.model.individual.Individual;

public class RandomBetweenAllReplacement implements ReplacementAlgorithm {


    @Override
    public void replace(List<Individual> newIndividuals, List<Individual> poblation) {
        List<Individual> newPoblation = new ArrayList<>(poblation.size());

        int range = newIndividuals.size() + poblation.size();

        for (int i = 0; i < poblation.size(); i++) {
            int index = (int) (range * RandomNumbers.getInstance().getRandomNumber());
            Individual individual;

            if (index < poblation.size()) {
                individual = poblation.get(index);
            } else {
                individual = newIndividuals.get(index - poblation.size());
            }

            newPoblation.add(individual);
        }

        poblation.clear();
        poblation.addAll(newPoblation);
    }
}
