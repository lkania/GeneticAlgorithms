package api.algorithm.selection;

import java.util.ArrayList;
import java.util.List;

import api.model.individual.Individual;

public class DeterministicTournament extends SelectionAlgorithm{
	private int numberOfIndividuals = 0;
	
	public DeterministicTournament(int numberOfSelected, int numberOfIndividuals) {
		super(numberOfSelected);
		this.numberOfIndividuals = numberOfIndividuals;
	}

	@Override
	public List<Individual> select(List<Individual> poblation) {
		List<Individual> selection = new ArrayList<>();
		List<Individual> contestants = null;
		for(int k=0; k<getNumberOfSelected(); k++){
			contestants = selectRandomContestants(poblation);
			selection.add(selectBest(contestants));
		}
		return selection;
	}
	
	protected List<Individual> selectRandomContestants(List<Individual> poblation){
		List<Individual> res = new ArrayList<>();
		for(int i=0; i<numberOfIndividuals; i++){
			res.add(poblation.get((int) (Math.random()*poblation.size())));
		}
		return res;
	}
	
	protected Individual selectBest(List<Individual> contestants){
		double bestFitness = 0;
		Individual best = null;
		for(Individual ind: contestants){
			if(ind.getFitness() > bestFitness){
				bestFitness = ind.getFitness();
				best = ind;
			}
			
		}
		return best;
	}

}
