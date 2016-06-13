package examples.tpe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import api.GeneticAlgorithm;
import api.algorithm.condition.ContentCondition;
import api.algorithm.condition.GoodEnoughFitnessCondition;
import api.algorithm.condition.MaximumGenerationsCondition;
import api.algorithm.condition.StructureCondition;
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
import examples.switches.SwitchFitness;
import examples.switches.SwitchesPrinter;
import examples.tpe.reader.ItemsReader;
import graph.MaxFitnessByGeneration;
import graph.MeanFitnessByGeneration;

public class RPGExample {

	private static SelectionAlgorithm selectionAlgorithmOne = new Elitism(30);
	private static SelectionAlgorithm selectionAlgorithmTwo = new BoltzmannSelection(70, 60.0);

	private static List<SelectionAlgorithm> selectionAlgorithms = new ArrayList<>();
	static {
		selectionAlgorithms.add(selectionAlgorithmOne);
		selectionAlgorithms.add(selectionAlgorithmTwo);
	}

	private static SelectionAlgorithm selectionAlgorithmThree = new CombineSelection(selectionAlgorithms);

	private static CrossoverAlgorithm crossoverAlgorithm = new OnePointCrossover();

	private static MutationAlgorithm mutationAlgorithm = new MutationClassic(0.3);

	private static ReplacementAlgorithm replacementAlgorithm = new RandomBetweenAllReplacement();

	private static FitnessAlgorithm fitnessAlgorithm = new Defensor1Fitness();

	private static int poblationSize = 100;

	private static GenFactory genFactory;

	private static final String PATH = System.getProperty("user.dir") + "/items/";
	private static final String PATH_WEAPONS = PATH + "armas.tsv";
	private static final String PATH_BOOTS = PATH + "botas.tsv";
	private static final String PATH_HELMET = PATH + "cascos.tsv";
	private static final String PATH_GAUNLETS = PATH + "guantes.tsv";
	private static final String PATH_CHESTS = PATH + "pecheras.tsv";

	private static double deltaHeight = 0.0001;
	
	public static void main(String[] args) throws IOException {
		
	 	List<Map<Integer,Item>> items = new LinkedList<Map<Integer,Item>>();
    	items.add(ItemsReader.interpreter(PATH_BOOTS));
    	items.add(ItemsReader.interpreter(PATH_WEAPONS));
    	items.add(ItemsReader.interpreter(PATH_HELMET));
    	items.add(ItemsReader.interpreter(PATH_GAUNLETS));
    	items.add(ItemsReader.interpreter(PATH_CHESTS));
    	 	    	    	
    	genFactory = new ArmorGenFactory(items,deltaHeight);
		
		
		Configuration configuration = new Configuration(selectionAlgorithmThree, crossoverAlgorithm, mutationAlgorithm,
				replacementAlgorithm, fitnessAlgorithm, poblationSize, genFactory);

		//configuration.addEndCondition(new GoodEnoughFitnessCondition(961));
		configuration.addEndCondition(new MaximumGenerationsCondition(120));
	//	configuration.addEndCondition(new StructureCondition());
//		configuration.addEndCondition(new ContentCondition(5));

		GeneticAlgorithm ga = new GeneticAlgorithm();
		
		ga.subscribe(new MaxFitnessByGeneration("Max Fitness By Generation", "Generations", "Max Fitness",
				"Max Fitness vs Generation", System.getProperty("user.dir") + "/"));
		ga.subscribe(new MeanFitnessByGeneration("Mean Fitness By Generation", "Generations", "Mean Fitness",
				"Mean Fitness vs Generation", System.getProperty("user.dir") + "/"));

		ga.run(configuration);
	}

}
