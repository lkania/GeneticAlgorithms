package api.algorithm.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import api.model.individual.Individual;

public class RankingSelection extends SelectionAlgorithm {

	public RankingSelection(int numberOfSelected) {
		super(numberOfSelected);
	}

	@Override
	public List<Individual> select(List<Individual> poblation) {
		List<Individual> aux = new ArrayList<>();
		List<Individual> res = new ArrayList<>();
		aux.addAll(poblation);
		Collections.sort(aux);
		List<Double> randomNumbers = getRandomValues(getNumberOfSelected());	
		double probability = 0;
		int randomIndex = 0;
		
		for(int i = 0; i < aux.size(); i++ ){
			probability += ((i+1))/aux.size(); 
			while(randomNumbers.get(randomIndex) > probability ){
				res.add(aux.get(i));
				randomIndex ++;
				if(randomIndex==getNumberOfSelected()){
					return res;
				}
				
			}
			
		}
		return res;
	}
	
	protected List<Double> getRandomValues(int qty){
		List<Double> randomAccumulatedFitness = new ArrayList<Double>(getNumberOfSelected());
		for(int i=0; i< getNumberOfSelected(); i++){
			randomAccumulatedFitness.add(Math.random());
		}
		return randomAccumulatedFitness;
		
	}

}
