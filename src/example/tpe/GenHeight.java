package example.tpe;

import api.model.gen.Gen;

public class GenHeight extends Gen {
	private static final double MIN_HEIGHT=1.3;
	private static final double MAX_HEIGHT=2.0;
	
	public GenHeight(int currentValue, int maxPossibleValue) {
		super(currentValue, maxPossibleValue);
	}

	public double getHeight() {
		return MIN_HEIGHT+(MAX_HEIGHT-MIN_HEIGHT)*getCurrentValue()/((double)getMaxPossibleValue());
	}
	

	
}
