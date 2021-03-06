package net.azib.java.students.t103784.homework;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author Ott Madis Ozolit <karuott321@hotmail.com>
 * @version 1.6
 * @since 2011.0520
 */
public class HTMLOutputTest extends Output {

	/**
	 * Tests whether the HTML output works.
	 * <p/>
	 * By feeding some preset valid data into the system using
	 * a reader, I check if the output can get the data from the input properly.
	 */
	@org.junit.Test
	public void testHTMLOutput() {
		List<Athlete> contestants;
		MockInput input = new MockInput();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("src/net/azib/java/students/t103784/homework/tests/CSVTest.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("Test input failed (no such test file)");
		}
		contestants = input.readAthleteFromCSV(reader);
		try {
			outputToHTML(contestants);
		} catch (IOException e) {
			System.out.println("Test output failed (IOException)");
		} catch (ParserConfigurationException e) {
			System.out.println("Test output failed (ParserConfException)");
		} catch (TransformerException e) {
			System.out.println("Test output failed (TransformerException)");
		} catch (SAXException e) {
			System.out.println("Test output failed (SAXException)");
		}
	}

	class MockInput extends Input {

	}
}
