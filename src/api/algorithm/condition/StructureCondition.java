package api.algorithm.condition;

import java.util.List;

import api.model.gen.Gen;
import api.model.individual.Individual;

public class StructureCondition implements EndCondition {

	@Override
	public boolean hasAlgorithmEnded(List<Individual> poblation) {
		Individual previous=null;
		for(Individual individual:poblation){
			if(previous!=null && !individual.equals(previous)){
				return false;
			}
			previous=individual;
		}
		return true;
	}
	

}
