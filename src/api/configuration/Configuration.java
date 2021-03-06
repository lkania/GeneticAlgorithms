package api.configuration;

import api.algorithm.condition.EndCondition;
import api.algorithm.crossover.CrossoverAlgorithm;
import api.algorithm.fitness.FitnessAlgorithm;
import api.algorithm.mutation.MutationAlgorithm;
import api.algorithm.replacement.ReplacementAlgorithm;
import api.algorithm.selection.CombineSelection;
import api.algorithm.selection.SelectionAlgorithm;
import api.model.gen.GenFactory;
import api.model.individual.Individual;

import java.util.LinkedList;
import java.util.List;

public class Configuration {

    private CrossoverAlgorithm crossoverAlgorithm;
    private MutationAlgorithm mutationAlgorithm;
    private ReplacementAlgorithm replacementAlgorithm;
    private SelectionAlgorithm selectionAlgorithmForCrossover;
    private List<EndCondition> endConditions = new LinkedList<>();
    private FitnessAlgorithm fitnessAlgorithm;
    private int poblationSize;
    private GenFactory genFactory;
	private SelectionAlgorithm selectionAlgorithmForReplacement;

    public Configuration(List<SelectionAlgorithm> selectionAlgorithmsForCrossover, CrossoverAlgorithm crossoverAlgorithm, MutationAlgorithm mutationAlgorithm, List<SelectionAlgorithm> selectionAlgorithmsForReplacement, ReplacementAlgorithm replacementAlgorithm, FitnessAlgorithm fitnessAlgorithm,  int poblationSize,GenFactory genFactory) {
        this.crossoverAlgorithm = crossoverAlgorithm;
        this.mutationAlgorithm = mutationAlgorithm;
        this.replacementAlgorithm = replacementAlgorithm;
        this.selectionAlgorithmForCrossover = new CombineSelection(selectionAlgorithmsForCrossover);
        this.fitnessAlgorithm = fitnessAlgorithm;
        this.poblationSize = poblationSize;
        this.genFactory=genFactory;
        this.selectionAlgorithmForReplacement = new CombineSelection(selectionAlgorithmsForReplacement);

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

	public SelectionAlgorithm getSelectionAlgorithmForCrossover() {
		return selectionAlgorithmForCrossover;
	}

	public SelectionAlgorithm getSelectionAlgorithmForReplacement() {
		return selectionAlgorithmForReplacement;
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
