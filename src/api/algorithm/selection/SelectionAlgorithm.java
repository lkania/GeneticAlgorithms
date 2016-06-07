package api.algorithm.selection;

import java.util.List;

import api.algorithm.Algorithm;
import api.model.individual.Individual;

public abstract class SelectionAlgorithm extends Algorithm{


	private int numberOfSelected;

	public SelectionAlgorithm(int numberOfSelected) {
		this.numberOfSelected = numberOfSelected;
	}
	
	
	public abstract List<Individual> select(List<Individual> poblation);
	
	protected int getNumberOfSelected() {
		return numberOfSelected;
	}
	
}
