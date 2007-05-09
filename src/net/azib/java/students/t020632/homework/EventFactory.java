package net.azib.java.students.t020632.homework;

/**
 * EventFactory creates Event objects.
 *
 * @author Marek Soobik t020632
 */
public class EventFactory {
	
	public Event createEvent(EventInfo eventInfo){
		Event event = null;
		EventCalculator calculator = null;
		String type = eventInfo.getType();
		
		if(type.equals("runningEvent")){
			calculator = RunningEventCalculator.getCalculator();
			event = new Event(eventInfo, calculator);
		}
		else if(type.equals("fieldEvent")){
			calculator = FieldEventCalculator.getCalculator();
			event = new Event(eventInfo, calculator);
		}
		
		
		return event;
		
	}
	
}
