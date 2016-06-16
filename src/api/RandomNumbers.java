package api;

import java.util.Random;

public class RandomNumbers {

	private static RandomNumbers randomNumbers;
	private Random random;
	
	private RandomNumbers(){
	}
	
	public static RandomNumbers getInstance(){
		if(randomNumbers==null){
			randomNumbers= new RandomNumbers();
		}
		return randomNumbers;
	}
	
	public void setSeed(long seed){
		random=new Random(seed);
	}
	
	public void setSeed(){
		random=new Random();
	}
	
	public double getRandomNumber(){
		return random.nextDouble();
	}
	
	
	
	
}
