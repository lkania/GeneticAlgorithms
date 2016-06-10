package example.tpe;

import java.util.List;
import java.util.Map;

import api.model.gen.Gen;
import api.model.gen.GenFactory;

public class ArmorGenFactory implements GenFactory{

	private List<Integer> maxValues;
	private List<Map<Integer,Item>> items;
	
	public ArmorGenFactory(List<Integer> maxValues, List<Map<Integer,Item>> items) {
		this.maxValues=maxValues;
		this.items=items;
	}
	
	@Override
	public Gen getRandomGen(int locus) {
		int maxValue=maxValues.get(locus);
		int index=(int)(Math.random()*(maxValue+1));

		if(locus==0){
			return new GenHeight(index,maxValue);
		}else{
			return new GenItem(index, maxValue, items.get(locus));
		}
	}

	
}
