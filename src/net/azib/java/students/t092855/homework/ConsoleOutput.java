package net.azib.java.students.t092855.homework;

import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Iterator;

/**
 * Console output.
 * For outputting decathlon data to console.
 *
 * @author t092855
 */
public class ConsoleOutput implements OutputStrategy {
	private final PrintStream output;

	/**
	 * Default constructor for console output.
	 * Uses System.out for data output.
	 */
	public ConsoleOutput() {
		this.output = System.out;
	}

	/**
	 * Outputs decathlon competition data to console
	 *
	 * @param competition decathlon competition data
	 */
	@Override
	public void writeOutput(Competition competition) {
		Athlete athlete;

		if(competition.getCompetitors().isEmpty()) {
			return;
		}
		System.out.println("Here are the points");

		Iterator<Athlete> iterator = competition.getCompetitors().iterator();

		do {
			athlete = iterator.next();
			if (athlete != null)
				printAthleteData(competition.getAthletePlace(athlete), athlete);
		}  while (iterator.hasNext());
	}


	private void printAthleteData (String place, Athlete athlete) {
		StringBuilder stringBuilder = new StringBuilder();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

		stringBuilder.append(place);
		stringBuilder.append(" ");
		stringBuilder.append(athlete.getAthleteEvents().getTotalPoints());
		stringBuilder.append(" ");
		stringBuilder.append(athlete.getName());
		stringBuilder.append(" ");
		stringBuilder.append(dateFormat.format(athlete.getBirthday()));
		stringBuilder.append(" ");
		stringBuilder.append(athlete.getCountry());
		stringBuilder.append(" ");

		for (int i = 0; i < athlete.getAthleteEvents().getDecathlonResults().length; i++) {
			stringBuilder.append(athlete.getAthleteEvents().getDecathlonResults()[i]);
			stringBuilder.append(" ");
		}

		output.println(stringBuilder.toString());
	}
}
