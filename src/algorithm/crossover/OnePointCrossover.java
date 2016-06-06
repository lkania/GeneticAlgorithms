package algorithm.crossover;

import java.util.ArrayList;
import java.util.List;

import model.gen.Gen;
import model.individual.Individual;

public class OnePointCrossover implements CrossoverAlgorithm {

	@Override
	public List<Individual> crossover(List<Individual> selectedIndividualsForCrossover) {

		return null;
	}

	public void crossover(Individual i1, Individual i2, List<Individual> ans) {
		ArrayList<Gen> gensI1 = i1.getGens();
		ArrayList<Gen> gensI2 = i2.getGens();

		int index = (int) Math.random() * gensI1.size();

		ArrayList<Gen> newGens1 = new ArrayList<>();
		ArrayList<Gen> newGens2 = new ArrayList<>();

		for (int i = 0; i < gensI1.size(); i++) {
			Gen gen1;
			Gen gen2;

			if (i >= index) {
				gen1 = gensI2.get(i);
				gen2 = gensI1.get(i);
			} else {
				gen1 = gensI1.get(i);
				gen2 = gensI2.get(i);
			}

			newGens1.set(i, gen1);
			newGens2.set(i, gen2);
		}

		ans.add(new Individual(newGens1, i1.getFitnessAlgorithm()));
		ans.add(new Individual(newGens2, i2.getFitnessAlgorithm()));

	}

}
