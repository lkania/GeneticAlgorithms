package examples.tpe;

import java.util.List;
import java.util.Map;

import api.model.gen.Gen;
import api.model.gen.GenFactory;

public class ArmorGenFactory implements GenFactory{

	private List<Map<Integer,Item>> items;
	
	public ArmorGenFactory(List<Map<Integer,Item>> items) {
		this.items=items;
	}
	
	@Override
	public Gen getRandomGen(int locus) {
		int maxValue=items.get(locus).size();
		int index=(int)(Math.random()*maxValue);

		if(locus==0){
			return new GenHeight(index,maxValue);
		}else{
			return new GenItem(index, maxValue, items.get(locus));
		}
	}

	
}
