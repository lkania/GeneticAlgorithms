package api.algorithm.crossover;

import api.model.individual.Individual;

import java.util.List;

public class TwoPointCrossover extends TwoIndexCrossover{

    @Override
    public void crossover(Individual i1, Individual i2, List<Individual> ans) {
        int firstIndex = (int) (i1.getGens().size()*Math.random());
        int secondIndex = (int) (i1.getGens().size()*Math.random());

        crossover(i1,i2,ans,Math.min(firstIndex,secondIndex),Math.max(firstIndex,secondIndex));
    }
}
