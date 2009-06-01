package net.azib.java.students.t090437.homework;

/**
 * BadInputFormatException
 *
 * @author Ronald
 */
public class BadDataFormatException extends Exception {

	private String message;
	public BadDataFormatException(String string) {
		message = string;
	}
	
	public String toString() {
		return message;
	}

}
