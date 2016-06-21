package api.algorithm.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import api.RandomNumbers;
import api.model.individual.Individual;

public class RankingSelection extends SelectionAlgorithm {

	private static double CONSTANT_A=1;
	private static double CONSTANT_B=0.1;
	
	
	public RankingSelection(int numberOfSelected) {
		super(numberOfSelected);
	}

	@Override
	public List<Individual> select(List<Individual> poblation) {
		List<Individual> aux = new ArrayList<>();
		List<Individual> res = new ArrayList<>();
		if(getNumberOfSelected()==0)
			return res;
		
		aux.addAll(poblation);
		Collections.sort(aux);
		List<Double> randomNumbers = getRandomValues(getNumberOfSelected());	
		double probability = 0;
		int randomIndex = 0;
		
		for(int i = 0; i < aux.size(); i++ ){
			
			probability += ((aux.size()-i)*CONSTANT_B+CONSTANT_A)/(aux.size()*(CONSTANT_A+CONSTANT_B*(aux.size()+1)*0.5)); 
			
			while(randomNumbers.get(randomIndex) < probability ){
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
			randomAccumulatedFitness.add(RandomNumbers.getInstance().getRandomNumber());
		}
		return randomAccumulatedFitness;
		
	}

}
