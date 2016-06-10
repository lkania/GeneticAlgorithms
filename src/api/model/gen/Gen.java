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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentValue;
		result = prime * result + maxPossibleValue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gen other = (Gen) obj;
		if (currentValue != other.currentValue)
			return false;
		if (maxPossibleValue != other.maxPossibleValue)
			return false;
		return true;
	}

	
}
