package api.algorithm.selection;

import java.util.ArrayList;
import java.util.List;

import api.model.individual.Individual;

public class RandomSelection extends SelectionAlgorithm {

	public RandomSelection(int numberOfSelected) {
		super(numberOfSelected);
	}

	@Override
	public List<Individual> select(List<Individual> poblation) {
		List<Individual> ans = new ArrayList<Individual>();

		for (int i = 0; i < getNumberOfSelected(); i++) {
			ans.add(getRandomIndividual(poblation));
		}

		return ans;
	}

}
