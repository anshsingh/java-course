package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.dto.Athlete;
import net.azib.java.students.t104971.homework.athletics.dto.ResultType;
import net.azib.java.students.t104971.homework.athletics.util.InputParser;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class ConsoleDataCollector implements DataCollector {

    public Collection<Athlete> loadCompetitionResults(String parameter) {
        List<Athlete> athletes = new ArrayList<Athlete>();
        for (int i = 1; ; i++) {
            System.out.println("Enter data for " + i + " athlete");
            athletes.add(createAthlete());
            System.out.println("Do you want to break input athletes? (yes/no)");
            if ("yes".equalsIgnoreCase(ConsoleInput.getLine())) break;
        }
        return athletes;
    }

    private Athlete createAthlete() {
        Athlete athlete = new Athlete();

        while (athlete.getName() == null) {
            System.out.println("Enter the name: ");
            athlete.setName(InputParser.parseName(ConsoleInput.getLine()));
        }

        while (athlete.getDateBirth() == null) {
            System.out.println("Enter the date birth in format dd.MM.yyyy : ");
            athlete.setDateBirth(InputParser.parseDate(ConsoleInput.getLine()));
        }

        while (athlete.getCountry() == null) {
            System.out.println("Enter the country in format XX : ");
            athlete.setCountry(InputParser.parseCountry(ConsoleInput.getLine()));
        }

        for (ResultType type : ResultType.values()) {
            double result = 0;
            while (result == 0) {
                System.out.println("Insert the result for " + type + " in " + type.getUnit());
                result = InputParser.parseResult(ConsoleInput.getLine());
            }
            athlete.addResult(type, result);
        }

        return athlete;
    }
}
