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
        FitnessAlgorithm fitnessAlgorithm = configuration.getFitnessAlgorithm();
        GenFactory genFactory=configuration.getGenFactory();
        
        List<Individual> poblation = new ArrayList<>(poblationSize);

        for(int i=0;i<poblationSize;i++){
            List<Gen> gens = genRandomGens(genFactory);
            Individual individual = new Individual(gens,fitnessAlgorithm);
            poblation.add(individual);
        }

        return poblation;
    }

    private static List<Gen> genRandomGens(GenFactory genFactory) {
        List<Gen> gens = new ArrayList<>(genFactory.getGensQuantity());
        for(int i=0;i<genFactory.getGensQuantity();i++){
            gens.add(genFactory.getRandomGen(i));
        }
        return gens;
    }

}
