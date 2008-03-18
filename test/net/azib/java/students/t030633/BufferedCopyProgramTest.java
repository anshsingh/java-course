package net.azib.java.students.t030633;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * BufferedCopyProgramTest
 * 
 * @author t030633
 */
public class BufferedCopyProgramTest {

	private final File src = new File(CopyPerformanceTimer.SOURCE_ADDRESS);
	private final File dest = new File(CopyPerformanceTimer.DESTINATION_ADDRESS);

	private void copy() throws IOException {
		if (dest.exists())
			dest.delete();
		(new BufferedCopyProgram()).copy(src, dest);
	}

	@Test
	public void destinationExists() throws IOException {
		copy();
		assertTrue(dest.exists());
	}

	@Test
	public void destinationIsAFile() throws IOException {
		copy();
		assertTrue(dest.isFile());
	}

	@Test
	public void bothHaveSameLength() throws IOException {
		copy();
		assertTrue(dest.length() == src.length());
	}

}
