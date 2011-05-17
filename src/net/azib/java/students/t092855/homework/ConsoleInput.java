package net.azib.java.students.t092855.homework;


import java.io.PrintStream;
import java.util.Scanner;

/**
 * Console input strategy.
 * Gets decathlon data from console input.
 *
 * @author t092855
 */
public class ConsoleInput implements InputStrategy {
	private final Scanner input;
	private final PrintStream output;

	/**
	 * Default constructor for ConsoleInput.
	 * Uses System.in for data input and System.out for data output
	 */
	public ConsoleInput() {
		input = new Scanner(System.in);
		output = new PrintStream(System.out);
	}

	public ConsoleInput(Scanner input, PrintStream output) {
		this.input = input;
		this.output = output;
	}

	/**
	 * Get decathlon competition data from console
	 *
	 * @return competition data
	 */
	@Override
	public Competition getData() {
		Competition competition = new Competition();

		input.useDelimiter(System.getProperty("line.separator"));
		while(true)
		{
			output.println("Do you want to add an athlete? (y/n)");
			if (getYes(input))
				break;
			Athlete athlete = new Athlete();
			getAthleteData(input, athlete);
			getAthleteResults(input, athlete);

			competition.addAthlete(athlete);
		}
		output.println("Athlete adding completed.");
		return competition;
	}

	private void getAthleteResults(Scanner scanner, Athlete athlete) {
		double[] results = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		int i = 0;

		for(DecathlonEvent events : DecathlonEvent.values()) {
			while(true) {
				output.print("Enter " + events.toString() + " result: ");
				String s = scanner.next();
				double temp = DecathlonEvents.validateAndConvertResult(s);
				if (temp < 0.0) {
					output.println(Error.ERROR_NUMBER_FORMAT.getErrorText());
				}
				else {
					results[i++] = temp;
					break;
				}
			}
		}
		athlete.setDecathlonEvent(new DecathlonEvents(results));
	}

	private void getAthleteData(Scanner scanner, Athlete athlete) {
		getAthleteName(scanner, athlete);
		getAthleteCountry(scanner, athlete);
		getAthleteBirthday(scanner, athlete);
	}

	private void getAthleteName(Scanner scanner, Athlete athlete) {
		while(athlete.getName() == null)
		{
			output.println("Please enter athlete's name:");
			String s = scanner.next();
			athlete.setName(s);
		}
	}

	private void getAthleteCountry(Scanner scanner, Athlete athlete) {
		while(athlete.getCountry() == null)
		{
			output.println("Please enter athlete's origin:");
			String s = scanner.next();
			athlete.setCountry(s);
		}
	}

	private void getAthleteBirthday(Scanner scanner, Athlete athlete) {
		while(athlete.getBirthday() == null)
		{
			output.println("Please enter athlete's date of birth:");
			String s = scanner.next();
			athlete.setBirthday(s);
		}
	}

	private boolean getYes(Scanner scanner) {
		String s = scanner.next();
		return s == null || !s.equalsIgnoreCase("y");
	}
}