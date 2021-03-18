package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

public interface Radnja {
	
	void dodajGumu(AutoGuma a);

	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
}
