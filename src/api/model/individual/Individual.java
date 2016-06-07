package api.model.individual;

import api.algorithm.fitness.FitnessAlgorithm;
import api.model.gen.Gen;

import java.util.List;

public class Individual implements Comparable<Individual> {

	private FitnessAlgorithm fitnessAlgorithm;
    private double fitnessCache;
	private List<Gen> gens;
    private boolean recalculateFitness = true;

	public Individual(List<Gen> gens, FitnessAlgorithm fitnessAlgorithm) {
		this.fitnessAlgorithm = fitnessAlgorithm;
        this.gens=gens;
	}

	public double getFitness()
    {
        if(recalculateFitness){
            fitnessCache= fitnessAlgorithm.getFitness(this);
            recalculateFitness=false;
        }
		return fitnessCache;
	}

	@Override
	public int compareTo(Individual o) {
		if (this.getFitness() < o.getFitness()) {
			return 1;
		} else if (this.getFitness() > o.getFitness()) {
			return -1;
		} else {
			return 0;
		}
	}

	public List<Gen> getGens() {
		return gens;
	}

    public void setGens(List<Gen> gens){
        recalculateFitness=true;
        this.gens=gens;
    }

	public FitnessAlgorithm getFitnessAlgorithm() {
		return fitnessAlgorithm;
	}

}
