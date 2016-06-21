package api;

import api.algorithm.condition.EndCondition;
import api.algorithm.crossover.CrossoverAlgorithm;
import api.algorithm.mutation.MutationAlgorithm;
import api.algorithm.replacement.ReplacementAlgorithm;
import api.algorithm.selection.SelectionAlgorithm;
import api.configuration.Configuration;
import api.model.gen.Gen;
import api.model.gen.GenFactory;
import api.model.individual.Individual;

import java.util.LinkedList;
import java.util.List;

public class GeneticAlgorithm {

    private List<GeneticAlgorithmObserver> subscribers = new LinkedList<>();

    public void run(Configuration configuration) {

        List<Individual> poblation = configuration.getPoblation();

        notifyInitialPoblation(poblation);

        SelectionAlgorithm selectionAlgorithmForCrossover = configuration.getSelectionAlgorithmForCrossover();

        CrossoverAlgorithm crossoverAlgorithm = configuration.getCrossoverAlgorithm();
        
        MutationAlgorithm mutationAlgorithm = configuration.getMutationAlgorithm();

        SelectionAlgorithm selectionAlgorithmForReplacement = configuration.getSelectionAlgorithmForReplacement();

        ReplacementAlgorithm replacementAlgorithm = configuration.getReplacementAlgorithm();

        GenFactory genFactory = configuration.getGenFactory();
        
        while (!algorithmEnded(configuration, poblation)) {

            List<Individual> selectedIndividualsForCrossover = selectionAlgorithmForCrossover.select(poblation);
            List<Individual> crossoveredIndividuals = crossoverAlgorithm.crossover(selectedIndividualsForCrossover);
            mutationAlgorithm.mutate(crossoveredIndividuals, genFactory);

            replacementAlgorithm.replace(crossoveredIndividuals, poblation, selectionAlgorithmForReplacement);

            notifyNewPoblation(poblation);

        }

    }

    private static boolean algorithmEnded(Configuration configuration, List<Individual> poblation) {
        List<EndCondition> endConditions = configuration.getEndConditions();

        for (EndCondition endCondition : endConditions) {
            if (endCondition.hasAlgorithmEnded(poblation)) {
                return true;
            }
        }
        return false;

    }

    public void notifyNewPoblation(List<Individual> poblation) {
        for (GeneticAlgorithmObserver subscriber : subscribers) {
            subscriber.newPoblation(poblation);
        }
    }

    public void notifyInitialPoblation(List<Individual> poblation) {
        for (GeneticAlgorithmObserver subscriber : subscribers) {
            subscriber.initialPoblation(poblation);
        }
    }

    public void subscribe(GeneticAlgorithmObserver geneticAlgorithmObserver){
        subscribers.add(geneticAlgorithmObserver);
    }

    private void print(List<Individual> poblation){
        System.out.println("-------------PASO----------------");
        StringBuilder sb = new StringBuilder();
        for(Individual individual : poblation){
            for(Gen gen : individual.getGens()){
                sb.append(gen.getCurrentValue());
            }
            sb.append(" ").append(individual.getFitness());
            System.out.println(sb.toString());
            sb = new StringBuilder();
        }
        System.out.print("-----------------------------");
    }

}
