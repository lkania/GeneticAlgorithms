package api.algorithm.crossover;

import java.util.List;

import api.RandomNumbers;
import api.model.individual.Individual;

public class TwoPointCrossover extends TwoIndexCrossover{

    @Override
    public void crossover(Individual i1, Individual i2, List<Individual> ans) {
        int firstIndex = (int) (ans.size()*RandomNumbers.getInstance().getRandomNumber());
        int secondIndex = (int) (ans.size()*RandomNumbers.getInstance().getRandomNumber());

        crossover(i1,i2,ans,Math.min(firstIndex,secondIndex),Math.max(firstIndex,secondIndex));
    }
}
