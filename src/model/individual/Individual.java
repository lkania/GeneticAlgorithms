package model.individual;

import java.util.ArrayList;

import algorithm.fitness.FitnessAlgorithm;
import model.gen.Gen;

public class Individual implements Comparable<Individual> {

	private FitnessAlgorithm fitnessAlgorithm;
	private ArrayList<Gen> gens;

	public Individual(ArrayList<Gen> gens, FitnessAlgorithm fitnessAlgorithm) {
		this.fitnessAlgorithm = fitnessAlgorithm;
	}

	public double getFitness(){
		return fitnessAlgorithm.getFitness(this);
	}

	@Override
	public int compareTo(Individual o) {
		if (this.getFitness() < o.getFitness()) {
			return -1;
		} else if (this.getFitness() > o.getFitness()) {
			return 1;
		} else {
			return 0;
		}
	}

	public ArrayList<Gen> getGens() {
		return gens;
	}

	public FitnessAlgorithm getFitnessAlgorithm() {
		return fitnessAlgorithm;
	}

}
