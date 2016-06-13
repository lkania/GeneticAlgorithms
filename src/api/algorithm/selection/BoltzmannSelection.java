package api.algorithm.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import api.model.individual.Individual;

public class BoltzmannSelection extends Rulet {

	private int generation = 1;
	private double temperature;

	public BoltzmannSelection(int numberOfSelected, double temperature) {
		super(numberOfSelected);
		this.temperature = temperature;

	}

	@Override
	public List<Individual> select(List<Individual> poblation) {

		List<Individual> individuals = new ArrayList<Individual>(getNumberOfSelected());

		double partialBoltzmann = getTotalBoltzmann(poblation);

		List<Double> randomAccumulatedFitness = getRandomValues(getNumberOfSelected());

		Collections.sort(randomAccumulatedFitness);

		int randomIndex = 0;
		double probabilityOfBeignSelected = 0;
		for (Individual individual : poblation) {
			probabilityOfBeignSelected += Math.exp(individual.getFitness() / getTemperature()) / partialBoltzmann;
			while (randomAccumulatedFitness.get(randomIndex) < probabilityOfBeignSelected) {
				individuals.add(individual);
				randomIndex++;
				if (randomIndex == getNumberOfSelected()) {
					generation++;
					return individuals;
				}

			}

		}

		generation++;
		return individuals;

	}

	private double getTotalBoltzmann(List<Individual> poblation) {
		double accumulate = 0;
		for (Individual individual : poblation) {
			accumulate += Math.exp(individual.getFitness() / getTemperature());
		}
		return accumulate;
	}

	private double getTemperature() {
		return temperature * Math.exp(-generation);
	}

}
