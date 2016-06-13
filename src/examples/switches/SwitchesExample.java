package examples.switches;


import java.util.ArrayList;
import java.util.List;

import api.GeneticAlgorithm;
import api.algorithm.condition.ContentCondition;
import api.algorithm.crossover.CrossoverAlgorithm;
import api.algorithm.crossover.OnePointCrossover;
import api.algorithm.fitness.FitnessAlgorithm;
import api.algorithm.mutation.MutationAlgorithm;
import api.algorithm.mutation.MutationClassic;
import api.algorithm.replacement.RandomBetweenAllReplacement;
import api.algorithm.replacement.ReplacementAlgorithm;
import api.algorithm.selection.BoltzmannSelection;
import api.algorithm.selection.CombineSelection;
import api.algorithm.selection.Elitism;
import api.algorithm.selection.SelectionAlgorithm;
import api.configuration.Configuration;
import api.model.gen.GenFactory;
import graph.MaxFitnessByGeneration;
import graph.MeanFitnessByGeneration;

public class SwitchesExample {

    private static SelectionAlgorithm selectionAlgorithmOne = new Elitism(6);
    private static SelectionAlgorithm selectionAlgorithmTwo = new BoltzmannSelection(0,31.0);
    private static List<SelectionAlgorithm> selectionAlgorithms = new ArrayList<>();
    static{
    	selectionAlgorithms.add(selectionAlgorithmOne);
    	selectionAlgorithms.add(selectionAlgorithmTwo);
    }
    private static SelectionAlgorithm selectionAlgorithmThree = new CombineSelection(selectionAlgorithms);
    private static CrossoverAlgorithm crossoverAlgorithm = new OnePointCrossover();
    private static MutationAlgorithm mutationAlgorithm = new MutationClassic(0.003);
    private static ReplacementAlgorithm replacementAlgorithm = new RandomBetweenAllReplacement();
    private static FitnessAlgorithm fitnessAlgorithm = new SwitchFitness();
    private static List<Integer> rangeOfGens = new ArrayList<>();
    private static int poblationSize = 10;
    private static int NUMBER_OF_SWITHES = 5;

    static{
        for(int i=0;i<NUMBER_OF_SWITHES;i++){
            rangeOfGens.add(1);
        }
    }
    
    private static GenFactory genFactory=new SwitchesGenFactory(rangeOfGens);

    public static void main(String[] args){
        Configuration configuration = new Configuration(selectionAlgorithmThree,crossoverAlgorithm,mutationAlgorithm,replacementAlgorithm,fitnessAlgorithm,rangeOfGens,poblationSize,genFactory);

       // configuration.addEndCondition(new GoodEnoughFitnessCondition(961));
        //configuration.addEndCondition(new MaximumGenerationsCondition(10));
        //configuration.addEndCondition(new StructureCondition());

        configuration.addEndCondition(new ContentCondition(5));

        GeneticAlgorithm ga = new GeneticAlgorithm();
        ga.subscribe(new SwitchesPrinter());
        ga.subscribe(new MaxFitnessByGeneration("Max Fitness By Generation", "Generations", "Max Fitness", "Max Fitness vs Generation", System.getProperty("user.dir")+"/"));
        ga.subscribe(new MeanFitnessByGeneration("Mean Fitness By Generation", "Generations", "Mean Fitness", "Mean Fitness vs Generation", System.getProperty("user.dir")+"/"));

        ga.run(configuration);
    }

}
