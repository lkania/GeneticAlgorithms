import java.util.List;

import algorithm.crossover.CrossoverAlgorithm;
import algorithm.fitness.FitnessAlgorithm;
import algorithm.mutation.MutationAlgorithm;
import algorithm.replacement.ReplacementAlgorithm;
import algorithm.selection.SelectionAlgorithm;
import condition.EndCondition;
import model.individual.Individual;
import model.poblation.Poblation;

public class GeneticAlgorithm {

	public static void run(Configuration configuration) {

		FitnessAlgorithm fitnessAlgorithm = configuration.getFitnessAlgorithm();

		Poblation poblation = configuration.getPoblation();

		while (!algorithmEnded(configuration, poblation)) {

			SelectionAlgorithm selectionAlgorithmForCrossover = configuration.getSelectionAlgorithmForCrossover();

			List<Individual> selectedIndividualsForCrossover = selectionAlgorithmForCrossover.select(poblation,
					fitnessAlgorithm);

			CrossoverAlgorithm crossoverAlgorithm = configuration.getCrossoverAlgorithm();

			List<Individual> crossoveredIndividuals = crossoverAlgorithm.crossover(selectedIndividualsForCrossover,
					fitnessAlgorithm);

			MutationAlgorithm mutationAlgorithm = configuration.getMutationAlgorithm();

			List<Individual> mutatedIndividuals = mutationAlgorithm.mutate(crossoveredIndividuals, fitnessAlgorithm);

			ReplacementAlgorithm replacementAlgorithm = configuration.getReplacementAlgorithm();

			poblation = replacementAlgorithm.replace(mutatedIndividuals, poblation, fitnessAlgorithm);

		}

	}

	private static boolean algorithmEnded(Configuration configuration, Poblation poblation) {
		List<EndCondition> endConditions = configuration.getEndConditions();

		for (EndCondition endCondition : endConditions) {
			if (endCondition.hasAlgorithmEnded(poblation)) {
				return true;
			}
		}
		return false;

	}

}
