package examples.switches;

import java.util.List;

import api.model.gen.Gen;
import api.model.gen.GenFactory;

public class SwitchesGenFactory implements GenFactory {

	private List<Integer> maxValues;
	
	public SwitchesGenFactory(List<Integer> maxValues) {
		this.maxValues=maxValues;
	}
	
	@Override
	public Gen getRandomGen(int locus) {
		int maxValue=maxValues.get(locus);
		int newIndex=(int)(Math.random()*(maxValue+1));
		return new Gen(newIndex,maxValue);
	}

}