package net.azib.java.students.t092875.homework.writers;

import net.azib.java.students.t092875.homework.athletes.Athlete;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * HTMLWriterTest
 * 
 * @author Mihhail
 */
public class HTMLWriterTest {
	List<Athlete> athletes;

	@Before
	public void prepareData() {
		athletes = new ArrayList<Athlete>();
		String[] results = { "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20", "50.20" };
		Athlete a = new Athlete("Mihhail Arhipov", new Date(0), "ET", results);
		a.setPlace("1");
		a.setResult(2000);
		athletes.add(a);
	}

	@Test @Ignore
	public void testWrite() throws Exception {
		HTMLWriter writer = new HTMLWriter("test_write_result.html");
		writer.write(athletes);
		File resultFile = new File("test_write_result.html");
		
		InputStream testStream = HTMLWriterTest.class.getResource("test_write_data.html").openStream();
		FileInputStream resultStream = new FileInputStream(resultFile);
		
		assertTrue(IOUtils.contentEquals(testStream, resultStream));
		resultFile.delete();
	}
}
