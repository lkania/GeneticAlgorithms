package example.tpe;

import api.algorithm.fitness.FitnessAlgorithm;
import api.model.individual.Individual;

public class Defensor1Fitness implements FitnessAlgorithm {

	@Override
	public double getFitness(Individual individual) {
		List<Gen> gens=individual.getGens();
		double force=0;
		double agility=0;
		double skill=0;
		double resistence=0;
		double life=0;
		
		for(int i=1;i<gens.size();i++){
			Gen gen=gens.get(i);
			force+=gen.getForce();
			agility+=gen.getAgility();
			skill+=gen.getSkill();
			resistence+=gen.getResistence();
			life+=gen.getLife();
		}
		
	}
	
}
