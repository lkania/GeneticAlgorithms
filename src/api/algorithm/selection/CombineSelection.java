package api.algorithm.selection;

import java.util.ArrayList;
import java.util.List;

import api.model.individual.Individual;

public class CombineSelection extends SelectionAlgorithm{
	
	public CombineSelection(int numberOfSelected) {
		super(numberOfSelected);
	}

	private List<SelectionAlgorithm> algorithms = null;
	
	public CombineSelection(List<SelectionAlgorithm> algorithms) {
		super(0);
		this.algorithms = algorithms;
	}

	@Override
	public List<Individual> select(List<Individual> poblation) {
		List<Individual> res = new ArrayList<>();
		for (SelectionAlgorithm algorithm: algorithms){
			res.addAll(algorithm.select(poblation));
		}
		return res;
	}

}
