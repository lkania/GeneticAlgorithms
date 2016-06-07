package api.algorithm.crossover;

import api.model.gen.Gen;
import api.model.individual.Individual;

import java.util.ArrayList;
import java.util.List;

public abstract class TwoIndexCrossover extends  CrossoverAlgorithm{


    public static void crossover(Individual i1, Individual i2, List<Individual> ans,int firstIndex,int secondIndex) {

        List<Gen> gensI1 = i1.getGens();
        List<Gen> gensI2 = i2.getGens();

        List<List<Gen>> subGensI1 = getSubGens(gensI1,firstIndex,secondIndex);
        List<List<Gen>> subGensI2 = getSubGens(gensI2,firstIndex,secondIndex);

        List<Gen> newGen1 = new ArrayList<>();
        List<Gen> newGen2 = new ArrayList<>();

        crossGens(newGen1,subGensI1,subGensI2);
        crossGens(newGen2,subGensI2,subGensI1);

        ans.add(new Individual(newGen1,i1.getFitnessAlgorithm()));
        ans.add(new Individual(newGen2,i1.getFitnessAlgorithm()));

    }

    private static void crossGens(List<Gen> newGens,List<List<Gen>> g1,List<List<Gen>> g2){

        newGens.addAll(g1.get(0));
        newGens.addAll(g2.get(1));
        newGens.addAll(g1.get(2));

    }

    private static List<List<Gen>> getSubGens(List<Gen> gens,int firstIndex,int secondIndex) {

        ArrayList<List<Gen>> ans = new ArrayList<>();

        ans.add(gens.subList(0, firstIndex));
        ans.add(gens.subList(firstIndex, secondIndex));
        ans.add(gens.subList(secondIndex, gens.size()));

        return ans;
    }


}
