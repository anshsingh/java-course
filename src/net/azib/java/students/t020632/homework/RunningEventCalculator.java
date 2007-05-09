package net.azib.java.students.t020632.homework;


/**
 * RunningEventCalculator is used to calculate score for
 * running events (100m, 400m, 100m hurdles and 1500m).
 * This calculator is singleton object.
 *
 * @author Marek Soobik
 */
public class RunningEventCalculator implements EventCalculator{
	
	public static RunningEventCalculator calculator;
	
	private RunningEventCalculator(){
		
	}
	
	/**
	 * Creates new RunningEventCalculator object or
	 * returns old object
	 * 
	 * @return
	 */
	public static RunningEventCalculator getCalculator(){
		
		if(calculator == null){
			calculator = new RunningEventCalculator();
		}
		
		return calculator;
	}
	
	/**
	 * Calculates score for the event
	 */
	public int calculate(EventInfo info, float result){
		
		int score = 0;
		
		score = (int) (info.getA() * Math.pow((info.getB() - result), info.getC()));
		
		return score;
	}
}
