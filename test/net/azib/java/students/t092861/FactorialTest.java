package net.azib.java.students.t092861;

import java.math.BigInteger;
import net.azib.java.students.t092861.lecture2.Factorial;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 * @author Stanislav / 092861
 * 
 */
public class FactorialTest {

	
	@Test
	public void indexesFromZeroToTwenty() {
		assertFactorialSequence("1, 1, 2, 6, 24, 120, 720, 5040, 40320, "
				+ "362880, 3628800, 39916800, 479001600, 6227020800, "
				+ "87178291200, 1307674368000, 20922789888000, 355687428096000, "
				+ "6402373705728000, 121645100408832000, 2432902008176640000");
	}

	private void assertFactorialSequence(String expectedValues) {
		int i = 0;
		for (String string : expectedValues.split(", ")) {
			assertFactorial(i++, new BigInteger(string));
		}
	}

	private void assertFactorial(int i, BigInteger expected) {
		assertThat(new Factorial().generate(i), is(expected));
	}
}
