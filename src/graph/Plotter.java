package graph;

import java.io.IOException;
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

public abstract class Plotter {

	private String plotName;
	private String xAxis;
	private String yAxis;
	private String path;
	private String serieName;

	

	private	XYChart chart;
	private JFrame frame;
	
	public Plotter(String plotName, String xAxis, String yAxis, String serieName, String path) {
		super();
		this.plotName = plotName;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.path = path;
		this.serieName = serieName;
		
		chart = new XYChartBuilder().width(600).height(400).title(plotName).xAxisTitle(xAxis)
				.yAxisTitle(yAxis).build();

		chart.getStyler().setLegendPosition(LegendPosition.OutsideE);
		frame = new JFrame("Advanced Example");
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {

		        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // <-- you need this for now

		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        JPanel chartPanel = new XChartPanel(chart);
		        frame.add(chartPanel);

		        // Display the window.
		        frame.pack();
		        frame.setVisible(true);
		      }
		    });
	}
	

	public void save() throws IOException{
		BitmapEncoder.saveBitmapWithDPI(chart, path + getFileName(), BitmapFormat.PNG, 300);
		
	}
	
	public void plot() throws IOException {
		chart.removeSeries(serieName);
		double[] errorBars=getErrorBars();
		if(errorBars!=null)	
			chart.addSeries(serieName, getXValues(), getYValues(),errorBars);
		else
			chart.addSeries(serieName, getXValues(), getYValues());
		
	    frame.repaint();
	}

	protected abstract String getFileName();
	protected abstract double [] getXValues();
	protected abstract double [] getYValues();
	protected abstract double [] getErrorBars();
	
	protected double[] getDoubleArrayFromDoubleList(List<Double> list) {
		double[] ans = new double[list.size()];
		int i = 0;
		for (Double value : list) {
			ans[i] = value.doubleValue();
			i++;
		}
		return ans;
	}

	protected double[] getDoubleArrayFromIntegerList(List<Integer> list) {
		double[] ans = new double[list.size()];
		int i = 0;
		for (Integer value : list) {
			ans[i] = value.intValue();
			i++;
		}
		return ans;
	}

}
