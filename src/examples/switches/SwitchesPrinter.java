package examples.switches;


import api.GeneticAlgorithmObserver;
import api.model.gen.Gen;
import api.model.individual.Individual;

import java.util.List;

public class SwitchesPrinter implements GeneticAlgorithmObserver{


    @Override
    public void newPoblation(List<Individual> poblation) {
        System.out.println("Generation "+generation++);
        print(poblation);
    }

    private int generation=0;
    @Override
    public void initialPoblation(List<Individual> poblation) {
        System.out.println("Initial Poblation: ");
        print(poblation);
    }

    private void print(List<Individual> poblation){
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
