package auto_radnja.gume;

/**
 * Klasa koja predstavlja auto gumu
 * <br>
 * Ima sledeca polja:
 * <ul>
 * 	<li>markaModel - String koji predstavlja marku i model gume (default null)</li>
 * 	<li>precnik - Ceo broj koji predstavlja precnik gume (default -1)</li>
 * 	<li>sirina - Ceo broj koji predstavlja sirinu gume (default -1)</li>
 * 	<li>visina - Ceo broj koji predstavlja visinu gume (default -1)</li>
 * </ul>
 * 
 * @author Vladimir Maljkovic
 * @version 0.1
 *
 */
public class AutoGuma {
	
	/**
	 * Marka i model gume kao String
	 */
	private String markaModel = null;
	/**
	 * Precnik gume kao ceo broj
	 */
	private int precnik = -1;
	/**
	 * Sirina gume kao ceo broj
	 */
	private int sirina = -1;
	/**
	 * visina gume kao ceo broj
	 */
	private int visina = -1;

	/**
	 * Prazan konstruktor koji samo inicijalizuje objekat
	 */
	public AutoGuma() {
	}

	/**
	 * Parametrizovani konstruktor koji inicijalizuje objekat
	 * i postavlja vrednosti za marku i model, precnik, sirinu i visinu
	 * 
	 * @param markaModel - marka i model gume kao String
	 * @param precnik - precnik gume kao ceo broj
	 * @param sirina - sirina gume kao ceo broj
	 * @param visina - visina gume kao ceo broj
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca marku i model gume
	 * @return Marka i model gume kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}
	
	/**
	 * Postavlja vrednost za marku i model gume.<br>
	 * Uneta vrednost treba da ima makar 3 karaktera i ne sme biti null
	 * @param markaModel - Marka i model gume kao String
	 * @throws java.lang.NullPointerException Ako je proslednjeni String null
	 * @throws java.lang.RuntimeException Ako je proslednjeni String kraci od 3 karaktera
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik gume
	 * @return Precnik gume kao ceo broj
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja vrednost za precnik gume <br>
	 * Precnik mora biti veci od 13, manji od 22
	 * @param precnik - Precnik gume kao ceo broj
	 * @throws java.lang.RuntimeException Ako je vrednost van opsega
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca sirinu gume
	 * @return Sirina gume kao ceo broj
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja vrednost za sirinu gume <br>
	 * Sirina mora biti veca od 135, manja od 355
	 * @param sirina - Sirina gume kao ceo broj
	 * @throws java.lang.RuntimeException Ako je vrednost van opsega
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu gume
	 * @return Visina gume kao ceo broj
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja vrednost za visinu gume <br>
	 * Visina mora biti veca od 25, manja od 95
	 * @param visina - Visina gume kao ceo broj
	 * @throws java.lang.RuntimeException Ako je vrednost van opsega
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca String sa svim inforamcijama o gumi u formatu<br>
	 * AutoGuma [markaModel=<i>markaModel</i>, precnik=<i>precnik</i>, sirina=<i>sirina</i>, visina=<i>visina</i>]
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve gume i vraca true ako su iste
	 * <br>
	 * Gume se porede po marci i modelu, precniku, sirini i visini; sve vrednosti moraju biti iste.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase AutoGuma i imaju iste atribute</li>
	 *		<li>false u svim ostalim slucajevima</li>
	 *</ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}