package objects;

public class Food {

	private String polozka;
	private int cena;

	public Food(String polozka, int cena) {
		this.polozka = polozka;
		this.cena = cena;
	}

	public String getPolozka() {
		return polozka;
	}

	public int getCena() {
		return cena;
	}

}
