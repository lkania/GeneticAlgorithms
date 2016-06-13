package examples.tpe;

import java.util.HashMap;
import java.util.Map;

import api.model.gen.Gen;

public class GenItem extends Gen{
	private Map<Integer,Item> items = new HashMap<>();
	
	public GenItem(int currentValue, Map<Integer,Item> items) {
		super(currentValue);
		this.items=items;
	}

	public double getForce() {
		return items.get(getCurrentValue()).getForce();
	}

	public double getAgility() {
		return items.get(getCurrentValue()).getAgility();
	}

	public double getSkill() {
		return items.get(getCurrentValue()).getSkill();
	}

	public double getResistence() {
		return items.get(getCurrentValue()).getResistence();
	}

	public double getLife() {
		return items.get(getCurrentValue()).getLife();
	}
	
	public Map<Integer,Item> getItems(){
		return items;
	}
	

}
