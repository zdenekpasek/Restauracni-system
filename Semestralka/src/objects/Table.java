package objects;

public class Table {

	private int cislo;
	private int zarezervovano;

	public Table(int cislo, int zarezervovano) {
		this.cislo = cislo;
		this.zarezervovano = zarezervovano;
	}

	public int getCislo() {
		return cislo;
	}

	public void setCislo(int cislo) {
		this.cislo = cislo;
	}

	public int getZarezervovano() {
		return zarezervovano;
	}

	public void setZarezervovano(int zarezervovano) {
		this.zarezervovano = zarezervovano;
	}

}
