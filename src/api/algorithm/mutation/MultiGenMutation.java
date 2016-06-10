package api.algorithm.mutation;


import api.model.gen.Gen;
import api.model.gen.GenFactory;
import api.model.individual.Individual;

import java.util.List;

public class MultiGenMutation extends MutationAlgorithm{

    private double probability;
    private int genGroupSize;

    public MultiGenMutation(double probability,int genGroupSize){
        this.probability=probability;
        this.genGroupSize=genGroupSize;
    }

    @Override
    public void mutate(Individual individual,GenFactory genFactory) {
        List<Gen> gens = individual.getGens();

        for(int i=0;i<gens.size();i+=genGroupSize){
            if(Math.random()<probability){
                for(int j=i;j<i+genGroupSize;j++) {
                	Gen newGen = genFactory.getRandomGen(j);
                    gens.set(j,newGen);
                }
            }
        }

        individual.setGens(gens);
    }
}
