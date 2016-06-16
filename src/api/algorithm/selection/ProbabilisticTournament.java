package api.algorithm.selection;

import java.util.ArrayList;
import java.util.List;

import api.RandomNumbers;
import api.model.individual.Individual;

public class ProbabilisticTournament extends DeterministicTournament {

	public ProbabilisticTournament(int numberOfSelected) {
		super(numberOfSelected,2);
	}
	
	protected List<Individual> selectRandomContestants(List<Individual> poblation){
		List<Individual> res = new ArrayList<>();
		for(int i=0; i<2; i++){
			res.add(poblation.get((int) (RandomNumbers.getInstance().getRandomNumber()*poblation.size())));
		}
		return res;
	}
	
	protected Individual selectBest(List<Individual> contestants){
		double randomNumber = RandomNumbers.getInstance().getRandomNumber(); 
		Individual best =  contestants.get(0);
		Individual worst = contestants.get(1);
		if(best.getFitness() < worst.getFitness()){
			Individual aux = worst;
			worst = best;
			best = aux;
		}
			
		
		if(randomNumber < 0.75 ){
			return best;
		}else{
			return worst;
		}
		
			
	}


}
