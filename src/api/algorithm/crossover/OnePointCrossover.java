package api.algorithm.crossover;

import api.model.gen.Gen;
import api.model.individual.Individual;

import java.util.ArrayList;
import java.util.List;

public class OnePointCrossover extends CrossoverAlgorithm {



	public void crossover(Individual i1, Individual i2, List<Individual> ans) {
		List<Gen> gensI1 = i1.getGens();
		List<Gen> gensI2 = i2.getGens();

		int index = (int) Math.random() * gensI1.size();

		ArrayList<Gen> newGens1 = new ArrayList<>(gensI1.size());
		ArrayList<Gen> newGens2 = new ArrayList<>(gensI1.size());

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

			newGens1.add(i, gen1);
			newGens2.add(i, gen2);
		}


		ans.add(new Individual(newGens1, i1.getFitnessAlgorithm()));
		ans.add(new Individual(newGens2, i2.getFitnessAlgorithm()));

	}

}
