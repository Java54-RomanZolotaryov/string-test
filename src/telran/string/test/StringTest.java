package telran.string.test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class StringTest {
	
	// ********************************
	// Test Data
	// ********************************
	
	private static final String EMPTY_STRING = "";
	private static final String Hello = "Hello";
	private static final String H = "H";
	private static final String h = "h";
	private static final String o = "o";
	private static final String l = "l";
	private static final String He = H + "e";
	private static final String Hela = He + "la";
	private static final String llo = "llo";
	private static final String ell = "ell";
	private static final String elll = "elll";
	private static final String Helloell = Hello + ell;
	private static final String aa = "aa";
	private static final String aA = "aA";
	private static final String ab = "ab";
	private static final String aB = "aB";
	private static final String ac = "ac";
	private static final String aC = "aC";
	
	private static final char l_char = l.charAt(0);
	private static final char a_char = aa.charAt(0);
	private static final char h_char = h.charAt(0);
	private static final char H_char = H.charAt(0);
	
	private static final int INDEX_OF_llo_IN_Hello = 2;
	private static final int FIRST_INDEX_OF_l_IN_Hello = 2;
	private static final int LAST_INDEX_OF_l_IN_Hello = 3;
	private static final int INDEX_OF_He_IN_Hello = 0;
	private static final int ZERO_INDEX = 0;
	private static final int NOT_FOUND_INDEX = -1;

	@Test
	void concatTest() {
		String expected = Helloell;
		String actual = Hello.concat(ell);
		assertEquals(expected, actual);
		assertEquals(expected.length(), actual.length());
		
		actual = actual.concat(ell);
		assertNotEquals(expected, actual);
		assertNotEquals(expected.length(), actual.length());
		assertTrue(expected.length() < actual.length());
	}
	
	@Test
	void containsTest() {
		assertTrue(Hello.contains(ell));
		assertTrue(Hello.contains(EMPTY_STRING));
		
		assertFalse(Hello.contains(elll));
		assertFalse(EMPTY_STRING.contains(Hello));
	}
	
	@Test
	void compareToTest() {
		// if a > b && b > c -> a > c
		// if a < b && b < c -> a < c
		assertTrue((aa.compareTo(ab) < 0) && (ab.compareTo(ac) < 0) && (aa.compareTo(ac) < 0));
		assertTrue((ac.compareTo(ab) > 0) && (ab.compareTo(aa) > 0) && (ac.compareTo(aa) > 0));
		assertTrue((ac.compareTo(aB) > 0) && (aB.compareTo(aA) > 0) && (ac.compareTo(aA) > 0));
		assertTrue((aB.compareTo(ac) < 0) && (aA.compareTo(aB) < 0) && (aA.compareTo(ac) < 0));
		
		// ASCII comparison
		// "a" - "b" == "b" - "c"
		assertTrue(aa.compareTo(ab) == ab.compareTo(ac));
		assertTrue(aa.compareTo(aB) == ab.compareTo(aC));
		assertTrue(aa.compareTo(aB) == ab.compareTo(aC));
		assertTrue(aA.compareTo(aB) == aB.compareTo(aC));
		
		// False statements
		assertFalse(EMPTY_STRING.compareTo(aa) > 0);
		assertFalse(aa.compareTo(ab) > 0);
		assertFalse(EMPTY_STRING.compareTo(aa) == aa.compareTo(ab));
		assertFalse(aA.compareTo(aa) == 0);
		assertFalse(aB.compareTo(ab) == 0);
		assertFalse(aC.compareTo(ac) == 0);
		assertFalse((aa.compareTo(ab) == 0) && (ab.compareTo(ac) == 0) && (aa.compareTo(ac) == 0));
		assertFalse((ac.compareTo(ab) < 0) && (ab.compareTo(aa) < 0) && (ac.compareTo(aa) < 0));
		assertFalse((ac.compareTo(aB) < 0) && (aB.compareTo(aA) < 0) && (ac.compareTo(aA) < 0));
		assertFalse((aB.compareTo(ac) != 0) && (aA.compareTo(aB) == 0) && (aA.compareTo(ac) > 0));
	}
	
	@Test
	void compareToIgnoreCaseTest() {	
		// if a > b && b > c -> a > c (case ignored)
		// if a < b && b < c -> a < c (case ignored)
		assertTrue((aA.compareToIgnoreCase(ab) < 0) && (aB.compareToIgnoreCase(aC) < 0) && (aa.compareToIgnoreCase(ac) < 0));
		assertTrue((aC.compareToIgnoreCase(ab) > 0) && (aB.compareToIgnoreCase(aA) > 0) && (ac.compareToIgnoreCase(aa) > 0));
		assertTrue((aC.compareToIgnoreCase(ab) > 0) && (aB.compareToIgnoreCase(aa) > 0) && (aC.compareToIgnoreCase(aa) > 0));
		assertTrue((ab.compareToIgnoreCase(ac) < 0) && (aa.compareToIgnoreCase(aB) < 0) && (aa.compareToIgnoreCase(aC) < 0));
		
		// ASCII comparison (case ignored)
		// "a" - "b" == "b" - "c"
		assertTrue(aa.compareToIgnoreCase(aB) == aB.compareToIgnoreCase(ac));
		assertTrue(aa.compareToIgnoreCase(ab) == ab.compareToIgnoreCase(aC));
		assertTrue(aA.compareToIgnoreCase(aB) == aB.compareToIgnoreCase(aC));
		assertTrue(aa.compareToIgnoreCase(aB) == aB.compareToIgnoreCase(aC));
		
		// False statements
		assertFalse(EMPTY_STRING.compareToIgnoreCase(aa) > 0);
		assertFalse(aa.compareToIgnoreCase(ab) > 0);
		assertFalse(EMPTY_STRING.compareToIgnoreCase(aa) == aa.compareToIgnoreCase(ab));
		assertFalse(aA.compareToIgnoreCase(aa) != 0);
		assertFalse(aB.compareToIgnoreCase(ab) != 0);
		assertFalse(aC.compareToIgnoreCase(ac) != 0);
		assertFalse((aa.compareToIgnoreCase(ab) == 0) && (ab.compareToIgnoreCase(ac) == 0) && (aa.compareToIgnoreCase(ac) == 0));
		assertFalse((ac.compareToIgnoreCase(ab) < 0) && (ab.compareToIgnoreCase(aa) < 0) && (ac.compareToIgnoreCase(aa) < 0));
		assertFalse((ac.compareToIgnoreCase(aB) < 0) && (aB.compareToIgnoreCase(aA) < 0) && (ac.compareToIgnoreCase(aA) < 0));
		assertFalse((aB.compareToIgnoreCase(ac) != 0) && (aA.compareToIgnoreCase(aB) == 0) && (aA.compareToIgnoreCase(ac) > 0));
	}
	
	@Test
	void startsWithTest() {
		assertTrue(Hello.startsWith(H));
		assertTrue(Hello.startsWith(He));
		assertTrue(Hello.startsWith(Hello));
		assertTrue(Hello.startsWith(EMPTY_STRING));
		
		assertFalse(Hello.startsWith(H.toLowerCase()));
		assertFalse(Hello.startsWith(Hela));
		assertFalse(Hello.startsWith(ell));
		assertFalse(Hello.startsWith(Helloell));
		assertFalse(!Hello.startsWith(EMPTY_STRING));
	}
	
	@Test
	void endsWithTest() {
		assertTrue(Hello.endsWith(o));
		assertTrue(Hello.endsWith(llo));
		assertTrue(Hello.endsWith(Hello));
		assertTrue(Hello.endsWith(EMPTY_STRING));
		
		assertFalse(Hello.endsWith(o.toUpperCase()));
		assertFalse(Hello.endsWith(Hela));
		assertFalse(Hello.endsWith(H));
		assertFalse(Hello.endsWith(He));
		assertFalse(Hello.endsWith(Helloell));
		assertFalse(Hello.endsWith(ell));
		assertFalse(!Hello.endsWith(EMPTY_STRING));
	}
	
	@Test
	void equalsIgnoreCaseTest() {
		String lowerCaseHello = Hello.toLowerCase();
		assertTrue(!Hello.equals(lowerCaseHello) && Hello.equalsIgnoreCase(lowerCaseHello));
		assertTrue(!aa.equals(aA) && aa.equalsIgnoreCase(aA));
		assertTrue(!aA.equals(aa) && aA.equalsIgnoreCase(aa));
		assertTrue(!aA.equals(ab) && !aA.equalsIgnoreCase(ab));
		
		assertFalse(EMPTY_STRING.equalsIgnoreCase(aa));
		assertFalse(EMPTY_STRING.equalsIgnoreCase(ab));
		assertFalse(EMPTY_STRING.equalsIgnoreCase(aB));
		assertFalse(aa.equalsIgnoreCase(aB));
		assertFalse(ab.equalsIgnoreCase(aC));
		assertFalse(!aC.equalsIgnoreCase(ac));
	}
	
	@Test
	void indexOfTest() {
		assertEquals(INDEX_OF_llo_IN_Hello, Hello.indexOf(llo));
		assertEquals(INDEX_OF_llo_IN_Hello, Hello.indexOf(l));
		assertEquals(INDEX_OF_He_IN_Hello, Hello.indexOf(He));
		assertEquals(INDEX_OF_He_IN_Hello, Hello.indexOf(H));
		assertEquals(ZERO_INDEX ,Hello.indexOf(EMPTY_STRING));
		assertEquals(NOT_FOUND_INDEX ,Hello.indexOf(Hela));
		assertEquals(NOT_FOUND_INDEX ,Hello.indexOf(aa));
		
		assertNotEquals(INDEX_OF_llo_IN_Hello, Hello.indexOf(H));
		assertNotEquals(INDEX_OF_llo_IN_Hello, Hello.indexOf(He));
		assertNotEquals(INDEX_OF_He_IN_Hello, Hello.indexOf(llo));
		assertNotEquals(INDEX_OF_He_IN_Hello, Hello.indexOf(Hela));
		assertNotEquals(ZERO_INDEX ,Hello.indexOf(Hela));
		assertNotEquals(ZERO_INDEX ,Hello.indexOf(aa));
	}
	
	@Test
	void lastIndexOfTest() {
		assertEquals(LAST_INDEX_OF_l_IN_Hello, Hello.lastIndexOf(l_char));
		assertTrue(Hello.lastIndexOf(l_char) > Hello.indexOf(l_char));
		assertEquals(NOT_FOUND_INDEX, Hello.lastIndexOf(a_char));
		assertEquals(NOT_FOUND_INDEX, Hello.lastIndexOf(h_char));
		assertEquals(ZERO_INDEX, Hello.lastIndexOf(H));
		
		assertFalse(Hello.lastIndexOf(l_char) < Hello.indexOf(l_char));
		assertNotEquals(FIRST_INDEX_OF_l_IN_Hello, Hello.lastIndexOf(l_char));
		assertNotEquals(ZERO_INDEX, Hello.lastIndexOf(l_char));
		assertNotEquals(NOT_FOUND_INDEX, Hello.lastIndexOf(l_char));
	}

}
