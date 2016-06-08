package api.algorithm.crossover;

import api.model.individual.Individual;

import java.util.ArrayList;
import java.util.List;

public abstract class CrossoverAlgorithm {


	public List<Individual> crossover(List<Individual> selectedIndividualsForCrossover){

        List<Individual> ans = new ArrayList<>(selectedIndividualsForCrossover.size());
        
        for(int i=0;i<selectedIndividualsForCrossover.size();i+=2){
            Individual i1 = selectedIndividualsForCrossover.get(i);
            Individual i2 = selectedIndividualsForCrossover.get(i+1);
            crossover(i1,i2,ans);
        }

        return ans;
	}

	public abstract void crossover(Individual i1,Individual i2,List<Individual> ans);
	
}
