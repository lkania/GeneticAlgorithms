package examples.switches;


import api.algorithm.fitness.FitnessAlgorithm;
import api.model.gen.Gen;
import api.model.individual.Individual;

import java.util.List;

public class SwitchFitness implements FitnessAlgorithm{

    @Override
    public double getFitness(Individual individual) {
        List<Gen> gens = individual.getGens();

        StringBuilder sb = new StringBuilder();
        for(Gen gen : gens){
            sb.append(gen.getCurrentValue());
        }
        return Math.pow(Integer.parseInt(sb.toString(),2),2);
    }


}
