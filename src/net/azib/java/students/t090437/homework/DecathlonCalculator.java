package net.azib.java.students.t090437.homework;

import java.util.Scanner;
import java.util.SortedSet;

/**
 * Decathlon
 *
 * @author Ronald
 */
public class DecathlonCalculator {
	private static final String[] input_methods = {"-console", "-csv", "-db"};
	private static final String[] output_methods = {"-console", "-csv", "-xml", "-html"};
	
	private static String input_arg;
	private static String output_arg;
	
	private static int inputMethod = -1;
	private static int outputMethod = -1;
	
	public static void main(String[] args) {
		CompetitionDataLoader loader;
		CompetitionResultsProducer producer;
		SortedSet<Competitor> competitors;
		
		parseArguments(args);
		
//		inputMethod = 1;
//		input_arg = "C:\\data.csv";
//		
//		outputMethod = 3;
//		output_arg = "C:\\results.html";
		
		if(inputMethod == 0) { // -console
			loader = new CompetitionFromConsole();
		} else if(inputMethod == 1) { // -csv
			loader = new CompetitionFromCSV(input_arg);
		} else if(inputMethod == 2) { // -db
			int dbId = -1;
			boolean isArgNumeric = true;
			
			try {
				dbId = Integer.parseInt(input_arg);
			} catch(NumberFormatException e) {
				isArgNumeric = false;
			}
			
			if(isArgNumeric) {
				System.out.println("This argument can be database name or database id");
				System.out.println("Is this database id? Enter y if it is or anything else if not.");
				if(!(new Scanner(System.in)).nextLine().equals("y")) {
					isArgNumeric = true;
				}
			}
			
			if(isArgNumeric) {
				loader = new CompetitionFromDB(dbId);
			} else {
				loader = new CompetitionFromDB(input_arg);
			}
		} else {
			System.out.println("No input method recognized.");
			printUsage();
			return;
		}
		
		
		if(outputMethod == 0) {
			producer = new CompetitionToConsole();
		} else if(outputMethod == 1) {
			producer = new CompetitionToCSV(output_arg);
		} else if(outputMethod == 2) {
			producer = new CompetitionToXML(output_arg);
		} else if(outputMethod == 3) {
			producer = new CompetitionToHTML(output_arg);
		} else {
			System.out.println("No output method recognized.");
			printUsage();
			return;
		}
		
		
		try {
			loader.loadData();
		} catch(MyException e) {
			System.out.println("Failed to load data!");
			System.out.println(e);
			return;
		}
		
		competitors = loader.getResults();		
		PositionCalculator.calcPositions(competitors);		
		producer.setCompetitionResults(competitors);
		
		try {
			producer.produceResults();
		}
		catch (MyException e) {
			System.out.println("Error in producing output.");
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 */
	private static void printUsage() {
		// TODO Auto-generated method stub
		
	}

	private static void parseArguments(String[] args) {
		int i;
		int startOfInputArgument = 0, endOfInputArgument = -1;
		
		SearchForInputMethodLoop:
			for(i = 0;i < args.length - 1;i++) {
				for(int j = 0;j < input_methods.length;j++) {
					if(args[i].equals(input_methods[j])) {
						inputMethod = j;
						startOfInputArgument = i + 1;
						break SearchForInputMethodLoop;
					}
				}
			}
		
		SearchForOutputMethodLoop:
			for(i = i + 1;i < args.length;i++) {
				for(int j = 0;j < output_methods.length;j++) {
					if(args[i].equals(output_methods[j])) {
						outputMethod = j;
						endOfInputArgument = i - 1;
						break SearchForOutputMethodLoop;
					}
				}
			}
			
		input_arg = "";
		for(int j = startOfInputArgument; j <= endOfInputArgument;j++) {
			input_arg = input_arg + args[j] + " ";
		}
		if(startOfInputArgument <= endOfInputArgument) {
			input_arg = input_arg.substring(0, input_arg.length() - 1);
		}
		
		output_arg = "";
		for(i = i + 1;i < args.length;i++) {
			output_arg = output_arg + args[i] + " ";
		}
		if(output_arg.length() > 0) {
			output_arg = output_arg.substring(0, output_arg.length() - 1);
		}	
	}
}
