package api.algorithm.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import api.model.individual.Individual;

public class BoltzmannSelection extends Rulet {

	private int generation=1;
	private double temperature;
	
	public BoltzmannSelection(int numberOfSelected, double temperature) {
		super(numberOfSelected);
		this.temperature=temperature;
		
	}

	@Override
	public List<Individual> select(List<Individual> poblation) {
		
	List<Individual> individuals = new ArrayList<Individual>(getNumberOfSelected());
		
		double meanBoltzmann = getMeanBoltzmann(poblation);
		
		List<Double> randomAccumulatedFitness = getRandomValues(getNumberOfSelected());	
				
		
		Collections.sort(randomAccumulatedFitness);
		
		int randomIndex = 0;
		double accumulatedRelativeFitness = 0;
		for(Individual individual:poblation){
			accumulatedRelativeFitness+=Math.exp(individual.getFitness()/getTemperature())/meanBoltzmann;
			while(randomAccumulatedFitness.get(randomIndex) < accumulatedRelativeFitness){
				individuals.add(individual);
				randomIndex ++;
				if(randomIndex==getNumberOfSelected()){
					generation++;
					return individuals;
				}
				
			}
			
		}
		
		
		generation++;
		return individuals;
		
	}

	private double getMeanBoltzmann(List<Individual> poblation) {
		double accumulate=0;
		for(Individual individual: poblation){
			accumulate+=Math.exp(individual.getFitness()/getTemperature());
		}
		return accumulate/poblation.size() ;
	}

	private double getTemperature() {
		return temperature*Math.exp(-generation);
	}

}
