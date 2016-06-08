package api.algorithm.selection;

import java.util.ArrayList;
import java.util.List;

public class UniversalSelection extends Rulet {

	public UniversalSelection(int numberOfSelected) {
		super(numberOfSelected);
	}
	
	protected List<Double> getRandomValues(int qty){
		List<Double> randomAccumulatedFitness = new ArrayList<Double>(getNumberOfSelected());
		double rndNumber =  Math.random();
		for(int i=0; i< getNumberOfSelected(); i++){
			randomAccumulatedFitness.add((rndNumber+i)/getNumberOfSelected());
		}
		return randomAccumulatedFitness;
		
	}

}
