package api.model.gen;

public class Gen {

	private int maxPossibleValue;
	private int currentValue;

    public Gen(int currentValue,int maxPossibleValue){
        this.currentValue=currentValue;
        this.maxPossibleValue=maxPossibleValue;
    }

	public int getCurrentValue(){
		return currentValue;
	}
	
	public int getMaxPossibleValue(){
		return maxPossibleValue;
	}

}
