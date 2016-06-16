package api.algorithm.crossover;

import api.RandomNumbers;
import api.model.individual.Individual;

import java.util.List;

public class AnularCrossover extends TwoIndexCrossover{

    @Override
    public void crossover(Individual i1, Individual i2, List<Individual> ans) {
        int firstIndex = (int) (RandomNumbers.getInstance().getRandomNumber()*ans.size());
        int secondIndex = ((int) (RandomNumbers.getInstance().getRandomNumber()*ans.size()*0.5+1)+firstIndex)%ans.size();

        crossover(i1,i2,ans,Math.min(firstIndex,secondIndex),Math.max(firstIndex,secondIndex));
    }
}
