package dev.idion.test;

import dev.idion.stringcalc.StringCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalcTest {
	private StringCalculator stringCalculator;
	
	@BeforeEach
	void init() {
		this.stringCalculator = new StringCalculator();
	}
	
	@Test
	void addition() {
		Assertions.assertEquals(4, stringCalculator.stringCalc("1 plus 3"));
	}
	
	@Test
	void subtract() {
		Assertions.assertEquals(90, stringCalculator.stringCalc("99 minus 9"));
	}
	
	@Test
	void multiply() {
		Assertions.assertEquals(32, stringCalculator.stringCalc("4 multiply 8"));
	}
	
	@Test
	void divide() {
		Assertions.assertEquals(8, stringCalculator.stringCalc("888 divide 111"));
	}
	
	@Test
	void error() {
		Assertions.assertNull(stringCalculator.stringCalc("888 777 666 multiply"));
	}
}
