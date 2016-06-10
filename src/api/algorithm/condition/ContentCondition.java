package api.algorithm.condition;

import java.util.List;

import api.model.individual.Individual;

public class ContentCondition implements EndCondition {

	private int kGenerations;

	private double bestFitness;
	private int generations;
	
	public ContentCondition(int kGenerations) {
		this.kGenerations=kGenerations;
	}
	@Override
	public boolean hasAlgorithmEnded(List<Individual> poblation) {
		Individual best=null;
		for(Individual individual: poblation){
			if(best==null || best.getFitness()<individual.getFitness())
				best=individual;
		}
		if(best.getFitness()==bestFitness){
			generations++;
		}else{
			generations=0;
			bestFitness=best.getFitness();
		}
		if(generations==kGenerations)
			return true;
		else
			return false;
	}

}
