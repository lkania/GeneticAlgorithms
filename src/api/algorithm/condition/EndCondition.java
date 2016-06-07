package api.algorithm.condition;

import api.model.individual.Individual;

import java.util.List;

public interface EndCondition {

	public boolean hasAlgorithmEnded(List<Individual> poblation);

}
