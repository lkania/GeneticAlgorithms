package api.model.gen;

public class Gen {

	private int currentValue;

    public Gen(int currentValue){
        this.currentValue=currentValue;
    }

	public int getCurrentValue(){
		return currentValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentValue;
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
		return true;
	}
	@Override
	public String toString() {
		
		return ""+currentValue;
	}

	
}
