package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.GeneticAlgorithmObserver;
import api.model.individual.Individual;

public class MeanFitnessByGeneration extends Plotter implements GeneticAlgorithmObserver {

	private int generation=1;
	private List<Integer> generations=new ArrayList<Integer>();
	private List<Double> meanFitnessByGeneration=new ArrayList<Double>();
	private List<Double> standartDesviationFitnessByGeneration=new ArrayList<Double>();
	
	public MeanFitnessByGeneration(String plotName, String xAxis, String yAxis, String serieName, String path) {
		super(plotName, xAxis, yAxis, serieName, path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void newPoblation(List<Individual> poblation) {
		generations.add(generation);
		double mean=meanFitness(poblation);
		meanFitnessByGeneration.add(mean);
		standartDesviationFitnessByGeneration.add(standartDesviationFitness(poblation,mean));
		try {
			plot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generation++;
	}
	
	
	private Double standartDesviationFitness(List<Individual> poblation,double mean) {
		double accumulate=0;
		for(Individual individual:poblation){
			accumulate+=Math.pow(mean-individual.getFitness(), 2);
		}
		return Math.sqrt(accumulate/poblation.size());
	}

	private double meanFitness(List<Individual> poblation){
		double accumulate=0;
		for(Individual individual:poblation){
			accumulate+=individual.getFitness();
		}
		return accumulate/poblation.size();
	}
	


	@Override
	public void initialPoblation(List<Individual> poblation) {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getFileName() {
		return "MeanFitnessByGeneration.png";
	}

	@Override
	protected double[] getXValues() {
		return getDoubleArrayFromIntegerList(generations);
	}

	@Override
	protected double[] getYValues() {
		return getDoubleArrayFromDoubleList(meanFitnessByGeneration);
	}

	@Override
	protected double[] getErrorBars() {
		return getDoubleArrayFromDoubleList(standartDesviationFitnessByGeneration);
	}

}
