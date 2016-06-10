package api.configuration;

import java.util.ArrayList;
import java.util.List;

import api.algorithm.fitness.FitnessAlgorithm;
import api.model.gen.Gen;
import api.model.gen.GenFactory;
import api.model.individual.Individual;

public class PoblationInitilizer {

    public static List<Individual> getPoblation(Configuration configuration){
        int poblationSize = configuration.getPoblationSize();
        List<Integer> rangeOfGens = configuration.getRangeOfGens();
        FitnessAlgorithm fitnessAlgorithm = configuration.getFitnessAlgorithm();
        GenFactory genFactory=configuration.getGenFactory();
        
        List<Individual> poblation = new ArrayList<>(poblationSize);

        for(int i=0;i<poblationSize;i++){
            List<Gen> gens = genRandomGens(rangeOfGens,genFactory);
            Individual individual = new Individual(gens,fitnessAlgorithm);
            poblation.add(individual);
        }

        return poblation;
    }

    private static List<Gen> genRandomGens(List<Integer> rangeOfGens,GenFactory genFactory) {
        List<Gen> gens = new ArrayList<>(rangeOfGens.size());
        for(int i=0;i<rangeOfGens.size();i++){
            gens.add(genFactory.getRandomGen(i));
        }
        return gens;
    }

}
