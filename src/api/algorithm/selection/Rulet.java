package api.algorithm.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import api.RandomNumbers;
import api.model.individual.Individual;

public class Rulet extends SelectionAlgorithm{

	public Rulet(int numberOfSelected) {
		super(numberOfSelected);
	}
	
	@Override
	public List<Individual> select(List<Individual> poblation) {
		List<Individual> individuals = new ArrayList<Individual>(getNumberOfSelected());
		if(getNumberOfSelected()==0)
			return individuals;
		
		double totalFitness = getTotalFitness(poblation);
		
		List<Double> randomAccumulatedFitness = getRandomValues(getNumberOfSelected());	
				
		
		Collections.sort(randomAccumulatedFitness);
		
		int randomIndex = 0;
		double accumulatedRelativeFitness = 0;
		for(Individual individual:poblation){
			accumulatedRelativeFitness+=individual.getFitness()/totalFitness;
			while(randomAccumulatedFitness.get(randomIndex) < accumulatedRelativeFitness){
				individuals.add(individual);
				randomIndex ++;
				if(randomIndex==getNumberOfSelected()){
					return individuals;
				}
				
			}
			
		}
		
		return individuals;
	}

	private double getTotalFitness(List<Individual> poblation) {
		double ans=0;
		for(Individual individual : poblation){
			ans+=individual.getFitness();
		}
		return ans;
	}
	
	protected List<Double> getRandomValues(int qty){
		List<Double> randomAccumulatedFitness = new ArrayList<Double>(getNumberOfSelected());
		for(int i=0; i< getNumberOfSelected(); i++){
			randomAccumulatedFitness.add(RandomNumbers.getInstance().getRandomNumber());
		}
		return randomAccumulatedFitness;
		
	}

}
