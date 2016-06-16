package api.algorithm.mutation;

import java.util.List;

import api.RandomNumbers;
import api.model.gen.Gen;
import api.model.gen.GenFactory;
import api.model.individual.Individual;

public class MutationClassic extends MutationAlgorithm {

	private double probability;
	
	public MutationClassic(double probability) {
		super();
		this.probability=probability;
	}
	
	@Override
	public void mutate(Individual individual, GenFactory genFactory) {
		if(RandomNumbers.getInstance().getRandomNumber()<probability){
			List<Gen> gens=individual.getGens();
			
			int locus=(int)(RandomNumbers.getInstance().getRandomNumber()*gens.size());
			Gen newGen = genFactory.getRandomGen(locus);
			gens.set(locus, newGen);
			individual.setGens(gens);
		}
	}

}
