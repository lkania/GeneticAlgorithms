package examples.tpe;

import java.util.List;
import java.util.Map;

import api.model.gen.Gen;
import api.model.gen.GenFactory;

public class ArmorGenFactory implements GenFactory {

	private List<Map<Integer, Item>> items;
	private double deltaHeight;

	public ArmorGenFactory(List<Map<Integer, Item>> items, double deltaHeight) {
		this.items = items;
		this.deltaHeight = deltaHeight;
	}

	@Override
	public Gen getRandomGen(int locus) {

		if (locus == 0) {
			int index = (int) (Math.random() * (GenHeight.MAX_HEIGHT - GenHeight.MIN_HEIGHT) / deltaHeight);
			return new GenHeight(index, deltaHeight);
		} else {
			int maxValue = items.get(locus-1).size();
			int index = (int) (Math.random() * maxValue);
			return new GenItem(index, items.get(locus-1));
		}
	}

	@Override
	public int getGensQuantity() {
		return items.size()+1;
	}

}
