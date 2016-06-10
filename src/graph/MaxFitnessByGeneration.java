package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler.LegendPosition;

import api.GeneticAlgorithmObserver;
import api.model.individual.Individual;

public class MaxFitnessByGeneration extends Plotter implements GeneticAlgorithmObserver {


	private int generation=1;
	private List<Integer> generations=new ArrayList<Integer>();
	private List<Double> fitnessByGeneration=new ArrayList<Double>();
	

	public MaxFitnessByGeneration(String plotName, String xAxis, String yAxis, String serieName, String path) {
		super(plotName, xAxis, yAxis, serieName, path);
		// TODO Auto-generated constructor stub
	}

	

	
	@Override
	public void newPoblation(List<Individual> poblation) {
		generations.add(generation);
		fitnessByGeneration.add(maxFitness(poblation));
		try {
			plot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generation++;
	}
	
	private double maxFitness(List<Individual> poblation){
		Individual best=null;
		for(Individual individual:poblation){
			if(best==null || best.getFitness()<individual.getFitness()){
				best=individual;
			}
		}
		return best.getFitness();
	}

	@Override
	public void initialPoblation(List<Individual> poblation) {
		// TODO Auto-generated method stub

	}




	

	
	


	protected String getFileName() {
		return "MaxFitnessByGeneration.png";
	}

	protected double[] getYValues() {
		return getDoubleArrayFromDoubleList(fitnessByGeneration);
	}

	protected double[] getXValues() {
		return getDoubleArrayFromIntegerList(generations);
	}




	@Override
	protected double[] getErrorBars() {
		return null;
	}


	
}
