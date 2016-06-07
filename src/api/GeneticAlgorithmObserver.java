package api;

import api.model.individual.Individual;

import java.util.List;

public interface GeneticAlgorithmObserver {
    public void newPoblation(List<Individual> poblation);

    public void initialPoblation(List<Individual> poblation);
}
