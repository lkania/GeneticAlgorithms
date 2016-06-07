package api.configuration;

import api.algorithm.fitness.FitnessAlgorithm;
import api.model.gen.Gen;
import api.model.individual.Individual;

import java.util.ArrayList;
import java.util.List;

public class PoblationInitilizer {

    public static List<Individual> getPoblation(Configuration configuration){
        int poblationSize = configuration.getPoblationSize();
        List<Integer> rangeOfGens = configuration.getRangeOfGens();
        FitnessAlgorithm fitnessAlgorithm = configuration.getFitnessAlgorithm();

        List<Individual> poblation = new ArrayList<>(poblationSize);

        for(int i=0;i<poblationSize;i++){
            List<Gen> gens = genRandomGens(rangeOfGens);
            Individual individual = new Individual(gens,fitnessAlgorithm);
            poblation.add(individual);
        }

        return poblation;
    }

    private static List<Gen> genRandomGens(List<Integer> rangeOfGens) {
        List<Gen> gens = new ArrayList<>(rangeOfGens.size());
        for(int i=0;i<rangeOfGens.size();i++){
            int gen = (int)(Math.random()*(rangeOfGens.get(i)+1));
            gens.add(new Gen(gen,rangeOfGens.get(i)));
        }
        return gens;
    }

}
