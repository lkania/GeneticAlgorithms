package examples.tpe.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import api.GeneticAlgorithm;
import api.RandomNumbers;
import api.algorithm.condition.ContentCondition;
import api.algorithm.condition.GoodEnoughFitnessCondition;
import api.algorithm.condition.MaximumGenerationsCondition;
import api.algorithm.condition.StructureCondition;
import api.algorithm.crossover.AnularCrossover;
import api.algorithm.crossover.CrossoverAlgorithm;
import api.algorithm.crossover.OnePointCrossover;
import api.algorithm.crossover.TwoPointCrossover;
import api.algorithm.crossover.UniformCrossover;
import api.algorithm.fitness.FitnessAlgorithm;
import api.algorithm.mutation.MultiGenMutation;
import api.algorithm.mutation.MutationAlgorithm;
import api.algorithm.mutation.MutationClassic;
import api.algorithm.mutation.SingleGenMutation;
import api.algorithm.replacement.RandomBetweenAllReplacement;
import api.algorithm.replacement.ReplaceAll;
import api.algorithm.replacement.ReplacementAlgorithm;
import api.algorithm.replacement.SeparateRandomReplacement;
import api.algorithm.selection.BoltzmannSelection;
import api.algorithm.selection.DeterministicTournament;
import api.algorithm.selection.Elitism;
import api.algorithm.selection.ProbabilisticTournament;
import api.algorithm.selection.RandomSelection;
import api.algorithm.selection.RankingSelection;
import api.algorithm.selection.Rulet;
import api.algorithm.selection.SelectionAlgorithm;
import api.algorithm.selection.UniversalSelection;
import api.configuration.Configuration;
import api.model.gen.GenFactory;
import examples.tpe.ArmorGenFactory;
import examples.tpe.Defensor1Fitness;
import examples.tpe.Item;
import graph.MaxFitnessByGeneration;
import graph.MeanFitnessByGeneration;

public class AlgorithmReader {

	private static final String PATH = System.getProperty("user.dir") + "/items/";
	private static final String PATH_WEAPONS = PATH + "armas.tsv";
	private static final String PATH_BOOTS = PATH + "botas.tsv";
	private static final String PATH_HELMET = PATH + "cascos.tsv";
	private static final String PATH_GAUNLETS = PATH + "guantes.tsv";
	private static final String PATH_CHESTS = PATH + "pecheras.tsv";

	public static void main(String[] args) throws IOException {
		(new AlgorithmReader()).read();
	}

	public void read() throws IOException {

		Properties prop = new Properties();
		String propFileName = "configure.properties";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		String seedString = prop.getProperty("seed");
		if (seedString.equals("")) {
			RandomNumbers.getInstance().setSeed();
		} else {
			int seed = Integer.parseInt(seedString);
			RandomNumbers.getInstance().setSeed(seed);
		}

		List<SelectionAlgorithm> selectionAlgorithms = new ArrayList<>();

		getSelectionAlgorithm(prop.getProperty("selectionAlgorithmOne"), prop, selectionAlgorithms);
		getSelectionAlgorithm(prop.getProperty("selectionAlgorithmTwo"), prop, selectionAlgorithms);
		getSelectionAlgorithm(prop.getProperty("selectionAlgorithmThree"),
		 prop, selectionAlgorithms);

		CrossoverAlgorithm crossoverAlgorithm = getCrossoverAlgorithm(prop.getProperty("crossoverAlgorithm"),prop);

		MutationAlgorithm mutationAlgorithm = getMutationAlgorithm(prop.getProperty("mutationAlgorithm"), prop);

		ReplacementAlgorithm replacementAlgorithm = getReplacementAlgorithm(prop.getProperty("replacementAlgorithm"),
				prop);

		FitnessAlgorithm fitnessAlgorithm = new Defensor1Fitness();

		int poblationSize = Integer.parseInt(prop.getProperty("poblationSize"));

		double deltaHeight = Double.parseDouble(prop.getProperty("deltaheight"));

		List<Map<Integer, Item>> items = new LinkedList<Map<Integer, Item>>();
		items.add(ItemsReader.interpreter(PATH_BOOTS));
		items.add(ItemsReader.interpreter(PATH_WEAPONS));
		items.add(ItemsReader.interpreter(PATH_HELMET));
		items.add(ItemsReader.interpreter(PATH_GAUNLETS));
		items.add(ItemsReader.interpreter(PATH_CHESTS));

		GenFactory genFactory = new ArmorGenFactory(items, deltaHeight);

		Configuration configuration = new Configuration(selectionAlgorithms, crossoverAlgorithm, mutationAlgorithm,
				replacementAlgorithm, fitnessAlgorithm, poblationSize, genFactory);

		addContions(configuration, prop);

		GeneticAlgorithm ga = new GeneticAlgorithm();

		ga.subscribe(new MaxFitnessByGeneration("Max Fitness By Generation", "Generations", "Max Fitness",
				"Max Fitness vs Generation", System.getProperty("user.dir") + "/"));
		ga.subscribe(new MeanFitnessByGeneration("Mean Fitness By Generation", "Generations", "Mean Fitness",
				"Mean Fitness vs Generation", System.getProperty("user.dir") + "/"));

		ga.run(configuration);

	}

	private void addContions(Configuration configuration, Properties prop) {
		if (prop.getProperty("GoodEnoughFitnessCondition").equals("true")) {
			configuration.addEndCondition(new GoodEnoughFitnessCondition(
					Double.parseDouble(prop.getProperty("GoodEnoughFitnessConditionFitnessValue"))));
		}

		if (prop.getProperty("MaximumGenerationsCondition").equals("true")) {
			configuration.addEndCondition(new MaximumGenerationsCondition(
					Integer.parseInt(prop.getProperty("MaximumGenerationsConditionGenerationValue"))));
		}

		if (prop.getProperty("StructureCondition").equals("true")) {

			configuration.addEndCondition(new StructureCondition());
		}

		if (prop.getProperty("ContentCondition").equals("true")) {

			configuration.addEndCondition(
					new ContentCondition(Integer.parseInt(prop.getProperty("ContentConditionContentValue"))));
		}

	}

	private ReplacementAlgorithm getReplacementAlgorithm(String algorithm, Properties prop) {
		ReplacementAlgorithm ans = null;

		if (algorithm == null || algorithm.equals(""))
			return null;
		String qty = prop.getProperty("replaceQuantity");
		int replaceQuantity = 0;
		if (!qty.equals(""))
			replaceQuantity = Integer.parseInt(qty);

		switch (algorithm) {
		case "RandomBetweenAll":
			ans = new RandomBetweenAllReplacement();
			break;
		case "SeparateRandom":
			ans = new SeparateRandomReplacement(replaceQuantity);
			break;
		case "ReplaceAll":
			ans = new ReplaceAll();
			break;
		}

		return ans;
	}

	private MutationAlgorithm getMutationAlgorithm(String algorithm, Properties prop) {
		MutationAlgorithm ans = null;

		if (algorithm == null)
			return null;

		double mutationProbability = Double.parseDouble(prop.getProperty("mutationProbabilty"));

		switch (algorithm) {
		case "Classic":
			ans = new MutationClassic(mutationProbability);
			break;
		case "SingleGen":
			ans = new SingleGenMutation(mutationProbability);
			break;
		case "MultiGen":
			ans = new MultiGenMutation(mutationProbability, Integer.parseInt(prop.getProperty("multiGenGroupSize")));
			break;
		}

		return ans;

	}

	private int numberOfSelectedAlgorithm = 1;

	private void getSelectionAlgorithm(String algorithm, Properties prop,
			List<SelectionAlgorithm> selectionAlgorithms) {
		if (algorithm == null || algorithm.equals(""))
			return;

		SelectionAlgorithm ans = null;

		int numberOfSelected = Integer.parseInt(prop.getProperty("numberOfSelected" + numberOfSelectedAlgorithm++));

		switch (algorithm) {
		case "Elitism":
			ans = new Elitism(numberOfSelected);
			break;
		case "Boltzmann":
			double temperature = Double.parseDouble(prop.getProperty("temperature"));
			ans = new BoltzmannSelection(numberOfSelected, temperature);
			break;
		case "DeterministicTournament":
			ans = new DeterministicTournament(numberOfSelected,Integer.parseInt(prop.getProperty("deterministicTournamentGroupSize")));
			break;
		case "ProbabilisticTournament":
			ans = new ProbabilisticTournament(numberOfSelected);
			break;
		case "Universal":
			ans = new UniversalSelection(numberOfSelected);
			break;
		case "Ranking":
			ans = new RankingSelection(numberOfSelected);
			break;
		case "Rulet":
			ans = new Rulet(numberOfSelected);
			break;
		case "Random":
			ans = new RandomSelection(numberOfSelected);
			break;
		}

		selectionAlgorithms.add(ans);

	}

	private static CrossoverAlgorithm getCrossoverAlgorithm(String algorithm,Properties prop) {

		CrossoverAlgorithm ans = null;

		if (algorithm == null || algorithm.equals(""))
			return null;

		switch (algorithm) {
		case "OnePoint":
			ans = new OnePointCrossover();
			break;
		case "TwoPoint":
			ans = new TwoPointCrossover();
			break;
		case "Anular":
			ans = new AnularCrossover();
			break;
		case "Uniform":
			ans = new UniformCrossover(Double.parseDouble(prop.getProperty("uniformProbability")));
			break;
		}

		return ans;

	}

}
