package api.algorithm.selection;

import api.model.individual.Individual;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Elitism extends SelectionAlgorithm {


	public Elitism(int numberOfSelected) {
		super(numberOfSelected);
	}

	@Override
	public List<Individual> select(List<Individual> poblation) {

		PriorityQueue<Individual> pq = new PriorityQueue<>(poblation);

		List<Individual> ans = new ArrayList<Individual>();

		int selected = 0;
		while (!pq.isEmpty() && selected < getNumberOfSelected()) {
			ans.add(pq.remove());
			selected++;
		}

		return ans;
	}

}
