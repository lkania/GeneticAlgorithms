package examples.switches;


import api.GeneticAlgorithm;
import api.algorithm.condition.GoodEnoughFitnessCondition;
import api.algorithm.crossover.CrossoverAlgorithm;
import api.algorithm.crossover.OnePointCrossover;
import api.algorithm.fitness.FitnessAlgorithm;
import api.algorithm.mutation.MutationAlgorithm;
import api.algorithm.mutation.SingleGenMutation;
import api.algorithm.replacement.ReplacementAlgorithm;
import api.algorithm.replacement.SeparateRandomReplacement;
import api.algorithm.selection.CombineSelection;
import api.algorithm.selection.DeterministicTournament;
import api.algorithm.selection.Elitism;
import api.algorithm.selection.ProbabilisticTournament;
import api.algorithm.selection.RankingSelection;
import api.algorithm.selection.Rulet;
import api.algorithm.selection.SelectionAlgorithm;
import api.algorithm.selection.UniversalSelection;
import api.configuration.Configuration;

import java.util.ArrayList;
import java.util.List;

public class SwitchesExample {

    private static SelectionAlgorithm selectionAlgorithmOne = new Elitism(2);
    private static SelectionAlgorithm selectionAlgorithmTwo = new RankingSelection(4);
    private static List<SelectionAlgorithm> selectionAlgorithms = new ArrayList<>();
    static{
    	selectionAlgorithms.add(selectionAlgorithmOne);
    	selectionAlgorithms.add(selectionAlgorithmTwo);
    }
    private static SelectionAlgorithm selectionAlgorithmThree = new CombineSelection(selectionAlgorithms);
    private static CrossoverAlgorithm crossoverAlgorithm = new OnePointCrossover();
    private static MutationAlgorithm mutationAlgorithm = new SingleGenMutation(0.03);
    private static ReplacementAlgorithm replacementAlgorithm = new SeparateRandomReplacement(3);
    private static FitnessAlgorithm fitnessAlgorithm = new SwitchFitness();
    private static List<Integer> rangeOfGens = new ArrayList<>();
    private static int poblationSize = 10;
    private static int NUMBER_OF_SWITHES = 5;

    static{
        for(int i=0;i<NUMBER_OF_SWITHES;i++){
            rangeOfGens.add(1);
        }
    }

    public static void main(String[] args){
        Configuration configuration = new Configuration(selectionAlgorithmThree,crossoverAlgorithm,mutationAlgorithm,replacementAlgorithm,fitnessAlgorithm,rangeOfGens,poblationSize);

        configuration.addEndCondition(new GoodEnoughFitnessCondition(961));
        //configuration.addEndCondition(new MaximumGenerationsCondition(10));

        GeneticAlgorithm ga = new GeneticAlgorithm();
        ga.subscribe(new SwitchesPrinter());

        ga.run(configuration);
    }

}
