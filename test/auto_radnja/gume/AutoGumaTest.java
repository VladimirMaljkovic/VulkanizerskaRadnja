package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class AutoGumaTest {
	AutoGuma a1;

	@BeforeEach
	void setUp() throws Exception {
		a1 = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		a1 = null;
	}

	@Test
	@DisplayName("Prazan konstruktor")
	void testAutoGuma() {
		assertNotNull(a1);
	}

	// markamodel, precnik (13-22), sirina(135-355), visina(25-95)
	@Test
	@DisplayName("Parametrizovan konstruktor")
	void testAutoGumaStringIntIntInt() {
		a1 = new AutoGuma("ABC", 16, 200, 50);
		assertNotNull(a1);
		assertEquals("ABC", a1.getMarkaModel());
		assertEquals(16, a1.getPrecnik());
		assertEquals(200, a1.getSirina());
		assertEquals(50, a1.getVisina());
	}

	@Test
	@DisplayName("SetMarkaModel - normalno ime")
	void testSetMarkaModel() {
		a1.setMarkaModel("ABC");
		assertEquals("ABC", a1.getMarkaModel());
	}

	@Test
	@DisplayName("SetMarkaModel - ime je null")
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a1.setMarkaModel(null));
	}

	@Test
	@DisplayName("SetMarkaModel - ime je manje od 3 karaktera")
	void testSetMarkaModelTooShort() {
		assertThrows(java.lang.RuntimeException.class,
				() -> a1.setMarkaModel("A"));
	}

	

	// setPrecnik (13-22)
	
	@ParameterizedTest
	@DisplayName("SetPrecnik - dobra vrednost")
	@CsvSource({
		"13", "14", "16", "18", "20", "21", "22"
	})
	void testSetPrecnikOk(int precnik) {
		a1.setPrecnik(precnik);
		assertEquals(precnik, a1.getPrecnik());
	}

	@ParameterizedTest
	@DisplayName("SetPrecnik - losa vrednost")
	@CsvSource({
		"-1", "0", "10", "12", "23", "25", "100"
	})
	void testSetPrecnikNotOk(int precnik) {
		assertThrows(java.lang.RuntimeException.class,
				() -> a1.setPrecnik(precnik));
	}
	
	
	// setSirina (135-355)

	@ParameterizedTest
	@DisplayName("SetSirina - dobra vrednost")
	@CsvSource({
		"135", "185", "200", "355"
	})
	void testSetSirinaOk(int sirina) {
		a1.setSirina(sirina);
		assertEquals(sirina, a1.getSirina());
	}

	@ParameterizedTest
	@DisplayName("SetSirina - losa vrednost")
	@CsvSource({
		"-100", "134", "356", "1000"
	})
	void testSetSirinaNotOk(int sirina) {
		assertThrows(java.lang.RuntimeException.class,
				() -> a1.setSirina(sirina));
	}

	// setVisina (25-95)

	@ParameterizedTest
	@DisplayName("SetVisina - dobra vrednost")
	@CsvSource({
		"25", "40", "80", "95"
	})
	void testSetVisinaOk(int visina) {
		a1.setVisina(visina);
		assertEquals(visina, a1.getVisina());
	}

	@ParameterizedTest
	@DisplayName("SetVisina - losa vrednost")
	@CsvSource({
		"-100", "24", "96", "1000"
	})
	void testSetVisinaNotOk(int visina) {
		assertThrows(java.lang.RuntimeException.class,
				() -> a1.setVisina(visina));
	}
	
	
	
	@Test
	@DisplayName("toString")
	void testToString() {
		a1.setMarkaModel("ABC");
		a1.setPrecnik(16);
		a1.setSirina(200);
		a1.setVisina(70);
		String s = a1.toString();
		assertTrue(s.contains("markaModel=ABC"));
		assertTrue(s.contains("precnik=16"));
		assertTrue(s.contains("sirina=200"));
		assertTrue(s.contains("visina=70"));
	}

	
	// precnik (13-22), sirina(135-355), visina(25-95)
	@ParameterizedTest
	@DisplayName("Equals")
	@CsvSource({
		"ABC, 15, 150, 30, ABC, 15, 150, 30, true",
		"ABC, 15, 150, 30, ABBC, 15, 150, 30, false",
		"ABC, 16, 150, 30, ABC, 15, 150, 30, false",
		"ABC, 15, 151, 30, ABC, 15, 150, 30, false",
		"ABC, 15, 150, 31, ABC, 15, 150, 30, false",
	})
	void testEqualsObject(String mm1, int precnik1, int sirina1, int visina1, String mm2, int precnik2, int sirina2, int visina2, boolean eq) {
			
		a1 = new AutoGuma(mm1, precnik1, sirina1, visina1);
		AutoGuma a2 = new AutoGuma(mm2, precnik2, sirina2, visina2);
		
		assertEquals(eq, a1.equals(a2));
		
	}

}
