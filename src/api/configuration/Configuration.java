package api.configuration;

import api.algorithm.condition.EndCondition;
import api.algorithm.crossover.CrossoverAlgorithm;
import api.algorithm.fitness.FitnessAlgorithm;
import api.algorithm.mutation.MutationAlgorithm;
import api.algorithm.replacement.ReplacementAlgorithm;
import api.algorithm.selection.SelectionAlgorithm;
import api.model.gen.GenFactory;
import api.model.individual.Individual;

import java.util.LinkedList;
import java.util.List;

public class Configuration {

    private CrossoverAlgorithm crossoverAlgorithm;
    private MutationAlgorithm mutationAlgorithm;
    private ReplacementAlgorithm replacementAlgorithm;
    private SelectionAlgorithm selectionAlgorithm;
    private List<EndCondition> endConditions = new LinkedList<>();
    private FitnessAlgorithm fitnessAlgorithm;
    private int poblationSize;
    private GenFactory genFactory;

    public Configuration(SelectionAlgorithm selectionAlgorithm, CrossoverAlgorithm crossoverAlgorithm, MutationAlgorithm mutationAlgorithm, ReplacementAlgorithm replacementAlgorithm, FitnessAlgorithm fitnessAlgorithm,  int poblationSize,GenFactory genFactory) {
        this.crossoverAlgorithm = crossoverAlgorithm;
        this.mutationAlgorithm = mutationAlgorithm;
        this.replacementAlgorithm = replacementAlgorithm;
        this.selectionAlgorithm = selectionAlgorithm;
        this.fitnessAlgorithm = fitnessAlgorithm;
        this.poblationSize = poblationSize;
        this.genFactory=genFactory;
    }


    public List<Individual> getPoblation() {
        return PoblationInitilizer.getPoblation(this);
	}

	public CrossoverAlgorithm getCrossoverAlgorithm() {
		return crossoverAlgorithm;
	}

	public MutationAlgorithm getMutationAlgorithm() {
		return mutationAlgorithm;
	}

	public ReplacementAlgorithm getReplacementAlgorithm() {
		return replacementAlgorithm;
	}

	public SelectionAlgorithm getSelectionAlgorithm() {
		return selectionAlgorithm;
	}


	public List<EndCondition> getEndConditions() {
		return endConditions;
	}

    public void addEndCondition(EndCondition endCondition){
        this.endConditions.add(endCondition);
    }

	public FitnessAlgorithm getFitnessAlgorithm() {
		return fitnessAlgorithm;
	}

    public int getPoblationSize() {
        return poblationSize;
    }
    
    public GenFactory getGenFactory(){
    	return genFactory;
    }
}
