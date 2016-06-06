package algorithm.crossover;

import java.util.ArrayList;
import java.util.List;

import model.gen.Gen;
import model.individual.Individual;

public abstract class TwoIndexCrossover extends CrossoverAlgorithm{

	private int firstIndex;
	private int secondIndex;
	
	public TwoIndexCrossover(int firstIndex,int secondIndex){
		this.firstIndex=firstIndex;
		this.secondIndex=secondIndex;
	}
	
	@Override
	public void cross(Individual i1, Individual i2, List<Individual> ans) {

		ArrayList<Gen> gensI1 = i1.getGens();
		ArrayList<Gen> gensI2 = i2.getGens();
		
		List<Gen> subGensI1
		
		gensI1.subList(0, firstIndex);

		
	}
	
	private static ArrayList<ArrayList<Gen>> getSubGens(ArrayList<Gen> gens){
		
		
		
	}
	
	
}
