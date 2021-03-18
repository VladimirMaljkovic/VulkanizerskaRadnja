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

	

	// setPrecnik

	@DisplayName("SetPrecnik - normalna vrednost")
	@Test
	void testSetPrecnik() {
		a1.setPrecnik(15);
		assertEquals(15, a1.getPrecnik());
	}

	@DisplayName("SetPrecnik - preniska vrednost")
	@Test
	void testSetPrecnikIspod() {
		assertThrows(java.lang.RuntimeException.class,
				() -> a1.setPrecnik(10));
	}

	@DisplayName("SetPrecnik - previsoka vrednost")
	@Test
	void testSetPrecnikIznad() {
		assertThrows(java.lang.RuntimeException.class,
				() -> a1.setPrecnik(30));
	}
	
	
	// setSirina

		@DisplayName("SetSirina - normalna vrednost")
		@Test
		void testSetSirina() {
			a1.setSirina(200);
			assertEquals(200, a1.getSirina());
		}

		@DisplayName("SetSirina - preniska vrednost")
		@Test
		void testSetSirinaIspod() {
			assertThrows(java.lang.RuntimeException.class,
					() -> a1.setSirina(100));
		}

		@DisplayName("SetSirina - previsoka vrednost")
		@Test
		void testSetSirinaIznad() {
			assertThrows(java.lang.RuntimeException.class,
					() -> a1.setSirina(400));
		}

	// setVisina

	@DisplayName("SetVisina - normalna vrednost")
	@Test
	void testSetVisina() {
		a1.setVisina(50);
		assertEquals(50, a1.getVisina());
	}

	@DisplayName("SetVisina - preniska vrednost")
	@Test
	void testSetVisinaIspod() {
		assertThrows(java.lang.RuntimeException.class,
				() -> a1.setVisina(10));
	}

	@DisplayName("SetVisina - previsoka vrednost")
	@Test
	void testSetVisinaIznad() {
		assertThrows(java.lang.RuntimeException.class,
				() -> a1.setVisina(100));
	}

	
	// precnik (13-22), sirina(135-355), visina(25-95)

	@ParameterizedTest
	@DisplayName("SetPrecnik - parametrizovani")
	@CsvSource({
		"10, false",
		"15, true",
		"30, false"
	})
	void testSetPrecnik(int precnik, boolean eq)
	{
		boolean rule;
		rule = (precnik > 13 && precnik < 22);
		assertEquals(rule, eq);
	}
	
	@ParameterizedTest
	@DisplayName("SetVisina - parametrizovani")
	@CsvSource({
		"100, false",
		"200, true",
		"400, false"
	})
	void testSetSirina(int sirina, boolean eq)
	{
		boolean rule;
		rule = (sirina > 135 && sirina < 355);
		assertEquals(rule, eq);
	}
	
	
	@ParameterizedTest
	@DisplayName("SetSirina - parametrizovani")
	@CsvSource({
		"10, false",
		"50, true",
		"100, false"
	})
	void testSetVisina(int visina, boolean eq)
	{
		boolean rule;
		rule = (visina > 25 && visina < 95);
		assertEquals(rule, eq);
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
