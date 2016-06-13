package examples.tpe;

import java.util.List;

import api.algorithm.fitness.FitnessAlgorithm;
import api.model.gen.Gen;
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
			GenItem gen=(GenItem)gens.get(i);
			force+=gen.getForce();
			agility+=gen.getAgility();
			skill+=gen.getSkill();
			resistence+=gen.getResistence();
			life+=gen.getLife();
		}
		force*=1.1;
		agility*=0.7;
		skill*=0.4;
		resistence*=1.4;
		life*=1.2;
		
		force=100*Math.tanh(0.01*force);
		agility=Math.tanh(0.01*agility);
		skill=0.6*Math.tanh(0.01*skill);
		resistence=Math.tanh(0.01*resistence);
		life=100*Math.tanh(0.01*life);
		
		double height=((GenHeight)(gens.get(0))).getHeight();
		double atm=0.5-Math.pow(3*height-5,4)+Math.pow(3*height-5,2)+height/2;
		double dem=2+Math.pow(3*height-5,4)-Math.pow(3*height-5,2)-height/2;
		
		double attack=(agility+skill)*force*atm;
		double defense=(resistence+skill)*life*dem;
		
		double fitness=0.1*attack+0.9*defense;
		
		return fitness;
		
		
	}
	
}
