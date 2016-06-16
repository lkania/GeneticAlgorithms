package api.algorithm.condition;

import api.model.individual.Individual;

import java.util.List;

public class GoodEnoughFitnessCondition implements EndCondition{

    private double expectedFitness;

    public GoodEnoughFitnessCondition(double expectedFitness){
        this.expectedFitness =expectedFitness;
    }


    @Override
    public boolean hasAlgorithmEnded(List<Individual> poblation) {
        for(Individual individual:poblation){
            if(individual.getFitness()>=expectedFitness){
                return true;
            }
        }
        return false;
    }
}
