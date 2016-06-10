package api.algorithm.mutation;

import api.model.gen.GenFactory;
import api.model.individual.Individual;

import java.util.List;

public abstract class MutationAlgorithm {

	public void mutate(List<Individual> individuals, GenFactory genFactory){
        for (Individual individual:individuals){
            mutate(individual,genFactory);
        }
    }

    public abstract void mutate(Individual individual,GenFactory genFactory);

}
