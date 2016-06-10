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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gens == null) ? 0 : gens.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individual other = (Individual) obj;
		if (gens == null) {
			if (other.gens != null)
				return false;
		} else{
			for(int i=0;i<gens.size();i++){
				if(!gens.get(i).equals(other.getGens().get(i)))
					return false;
			}
		}
		return true;
	}

	
}
