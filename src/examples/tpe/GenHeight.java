package examples.tpe;

import api.model.gen.Gen;

public class GenHeight extends Gen {
	public static final double MIN_HEIGHT=1.3;
	public static final double MAX_HEIGHT=2.0;
	private double deltaHeight;
	
	public GenHeight(int currentValue, double deltaHeight) {
		super(currentValue);
		this.deltaHeight=deltaHeight;
	}

	public double getHeight() {
		return MIN_HEIGHT+deltaHeight*getCurrentValue();
	}
	

	
}
