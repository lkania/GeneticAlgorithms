package api.algorithm.mutation;

import java.util.List;

import api.model.gen.Gen;
import api.model.individual.Individual;

public class MutationClassic extends MutationAlgorithm {

	private double probability;
	
	public MutationClassic(double probability) {
		super();
		this.probability=probability;
	}
	
	@Override
	public void mutate(Individual individual) {
		if(Math.random()<probability){
			List<Gen> gens=individual.getGens();
			
			int locus=(int)(Math.random()*gens.size());
			Gen gen=gens.get(locus);
			Gen newGen = new Gen((int)(Math.random()*(gen.getMaxPossibleValue()+1)), gen.getMaxPossibleValue());

			gens.set(locus, newGen);
			individual.setGens(gens);
		}
	}

}
