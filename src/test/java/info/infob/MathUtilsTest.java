package info.infob;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import info.incubyte.code.StringCalculator;

class MathUtilsTest {
	
	private StringCalculator stringCalC;
	
	
	@BeforeEach
	void initEach() {
		stringCalC = new StringCalculator();
	}
	
	@Nested
	class AddingNumberTest {
		@Test
		void testForEmptyString() throws Exception {
			assertEquals(0, stringCalC.add(""), 
					"It should return '0' for Empty String");
		}
		
		@Test
		void testForOneNumberString() throws Exception {
			assertEquals(2, stringCalC.add("2"), 
					"Sum is not currect");
		}
		
		@Test
		void testForTwoNumberString() throws Exception {
			assertEquals(2, stringCalC.add("1;1"), 
					"sum is not currect for two numbers");
		}
	}
	
	@Test
	void testforNewLineBtNumbers() throws Exception {
		assertEquals(11, stringCalC.add("1\n2;3\n5"), 
				"it shoul support new line between numbers");
	}
	
	@Test
	void testForChangeDelimeterAndNumbers() throws Exception {
		assertEquals(8, stringCalC.add("//*\n1*2\n5"), 
				"delimeter should be changed");
	}

	@Test
	void testForNumbersBiggerThanThousand() throws Exception {
		assertEquals(299, stringCalC.add("99;200;1002"), 
				"numbers bigger than 1000 should be ignored");
	}
	
	@Test
	void testForMultiLengthDelimeter() throws Exception {
		assertEquals(6, stringCalC.add("//[***]\n1***2***3"), 
				"delimeter should be changed");
	}
	
	@Test
	void testForMultipleDelimeter() throws Exception {
		assertEquals(6, stringCalC.add("//[*][%]\n1*2%3"), 
				"delimeter should be changed");
	}
	
	
	@Test
	void testForMultipleDelimeterLengthWithMultiChar() throws Exception {
		assertEquals(6, stringCalC.add("//[**][%%]\n1**2%%3"), 
				"delimeter should be changed");
	}
	
	@Test
	void testMultipleMultiCharacterDelimeter() throws Exception {
		assertEquals(6, stringCalC.add("//[**][%%]\n1**2%%3"), 
				"it should negative numbers not allowed exception");
	}
	@Test
	void testForNegativeNumbersAndMultipleMultiCharacterDelimeter() throws Exception {
		assertEquals(6, stringCalC.add("//[**][%%]\n1**-2%%3"), 
				"it should negative numbers not allowed exception");
	}
	
	@Test
	void testForNegativeNumbers() throws Exception {
		assertEquals(6, stringCalC.add("1;-2;-3;-7"), 
				"it should negative numbers not allowed exception");
	}
		
}
