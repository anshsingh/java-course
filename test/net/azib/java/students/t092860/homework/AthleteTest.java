package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

/**
 * AthleteTest
 */
public class AthleteTest extends Athlete {

	private static Logger logger = Logger.getLogger("global");
	
    @Before
    public void setUp() {
		logger.setLevel(Level.OFF);
    }

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Athlete#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		String testVal = "name";
		setName(testVal);
		assertEquals(testVal, athleteName);
	}

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Athlete#setDate(java.util.Date)}.
	 */
	@Test
	public void testSetDate() {
		Date testVal = new Date();
		setDate(testVal);
		assertEquals(testVal, athleteBirthdate);
	}

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Athlete#setCountry(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testSetCountry() throws Exception {
		String testVal = "EE";
		setCountry(testVal);
		assertEquals(testVal, athleteCountry);
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Athlete#setCountry(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test(expected = Exception.class)
	public void testSetCountryException() throws Exception {
		String testVal = "XXXX";
		setCountry(testVal);
	}

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Athlete#addEvent(net.azib.java.students.t092860.homework.Events, java.lang.Double)}.
	 */
	@Test
	public void testAddEvent() {
		Events testEvent = Events.RACE_100M;
		double testPerf = 20.34;
		addEvent(testEvent, testPerf);
		assertTrue(testPerf == athleteEvents.get(testEvent));
		assertTrue(athleteEvents.size() == 1);
	}

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Athlete#getName()}.
	 */
	@Test
	public void testGetName() {
		String testVal = "name";
		athleteName = testVal;
		assertEquals(testVal, getName());
	}

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Athlete#getDate()}.
	 */
	@Test
	public void testGetDate() {
		Date testVal = new Date();
		athleteBirthdate = testVal;
		assertEquals(testVal, getDate());
	}

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Athlete#getCountry()}.
	 */
	@Test
	public void testGetCountry() {
		String testVal = "EE";
		athleteCountry = testVal;
		assertEquals(testVal, getCountry());
	}

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Athlete#getEventResult(net.azib.java.students.t092860.homework.Events)}.
	 */
	@Test
	public void testGetEventResult() {
		Events testEvent = Events.RACE_100M;
		double testPerf = 20.34;
		if(athleteEvents == null)
			athleteEvents = new LinkedHashMap<Events, Double>();
		athleteEvents.put(testEvent, testPerf);
		assertTrue(testPerf == getEventResult(testEvent));
		assertTrue(getEvents().size() == 1);
	}

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Athlete#getEvents()}.
	 */
	@Test
	public void testGetEvents() {
		Events testEvent = Events.RACE_100M;
		double testPerf = 20.34;
		if(athleteEvents == null)
			athleteEvents = new LinkedHashMap<Events, Double>();
		athleteEvents.put(testEvent, testPerf);
		assertTrue(getEvents().contains(testEvent));
		assertTrue(getEvents().size() == 1);
	}

}