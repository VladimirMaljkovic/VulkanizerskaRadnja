package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {
	
	protected Radnja radnja;

	//precnik (13-22), sirina(135-355), visina(25-95)

	@Test
	@DisplayName("DodajGumu - normalno")
	void testDodajGumu() {
		AutoGuma a = new AutoGuma("abc", 15, 150, 50);
		radnja.dodajGumu(a);
		
		assertEquals(1, radnja.pronadjiGumu("abc").size());
		assertEquals(a, radnja.pronadjiGumu("abc").get(0));
	}
	
	@Test
	@DisplayName("DodajGumu - guma je null")
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> radnja.dodajGumu(null) );
	}
	
	@Test
	@DisplayName("DodajGumu - duplikat")
	void testDodajGumuDuplikat() {
		AutoGuma a = new AutoGuma("abc", 15, 150, 50);
		radnja.dodajGumu(a);
		
		RuntimeException e = assertThrows(java.lang.RuntimeException.class,
				() -> radnja.dodajGumu(a) );
		assertEquals("Guma vec postoji", e.getMessage());
	}
	
	

	@Test
	@DisplayName("PronadjiGumu - normalno")
	void testPronadjiGumu() {
		AutoGuma a = new AutoGuma("abc", 15, 150, 50);
		radnja.dodajGumu(a);
		
		assertEquals(a, radnja.pronadjiGumu("abc").get(0));
	}
	
	
	@Test
	@DisplayName("PronadjiGumu - vise elemenata")
	void testPronadjiGumuViseEl() {
		AutoGuma a1 = new AutoGuma("abc", 15, 150, 50);
		AutoGuma a2 = new AutoGuma("abc", 16, 150, 50);
		AutoGuma a3 = new AutoGuma("cab", 15, 151, 50);
		AutoGuma a4 = new AutoGuma("abc", 15, 150, 51);
		AutoGuma a5 = new AutoGuma("cba", 15, 150, 52);
		radnja.dodajGumu(a1);
		radnja.dodajGumu(a2);
		radnja.dodajGumu(a3);
		radnja.dodajGumu(a4);
		radnja.dodajGumu(a5);
		
		assertEquals(3, radnja.pronadjiGumu("abc").size());
		
	}
	
	@Test
	@DisplayName("PronadjiGumu - String je null")
	void testPronadjiGumuNull() {
		AutoGuma a = new AutoGuma("abc", 15, 150, 50);
		
		radnja.dodajGumu(a);
		
		assertEquals(null, radnja.pronadjiGumu(null));
		
	}
	
	@Test
	@DisplayName("PronadjiGumu - Ne postoji trazena")
	void testPronadjiGumuNePostoji() {
		AutoGuma a = new AutoGuma("abc", 15, 150, 50);
		
		radnja.dodajGumu(a);
		
		assertEquals(0, radnja.pronadjiGumu("bac").size());
		
	}

}
