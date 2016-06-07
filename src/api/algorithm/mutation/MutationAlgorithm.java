package api.algorithm.mutation;

import api.model.individual.Individual;

import java.util.List;

public abstract class MutationAlgorithm {

	public void mutate(List<Individual> individuals){
        for (Individual individual:individuals){
            mutate(individual);
        }
    }

    public abstract void mutate(Individual individual);

}
