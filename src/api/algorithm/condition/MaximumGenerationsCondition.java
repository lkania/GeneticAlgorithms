package api.algorithm.condition;


import api.model.individual.Individual;

import java.util.List;

public class MaximumGenerationsCondition implements EndCondition{

    private int maxGenerations;

    public MaximumGenerationsCondition(int maxGenerations) {
        this.maxGenerations = maxGenerations;
    }

    private int generation=0;
    @Override
    public boolean hasAlgorithmEnded(List<Individual> poblation) {
        return generation++==maxGenerations;
    }
}
