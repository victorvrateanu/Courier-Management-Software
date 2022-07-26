package Clase;


//CLASA CLIENT CARE CUPRINDE DATELE DESPRE CLIENTUL EXPEDITOR SI DESTINATAR
public class Client {
	private String Nume, Adresa, Telefon;

	public Client(String nume,String adresa,String telefon)
	{
		this.Nume=nume;
		this.Adresa=adresa;
		this.Telefon=telefon;
	}
	public String getNume() {
		return Nume;
	}

	public void setNume(String nume) {
		Nume = nume;
	}

	public String getAdresa() {
		return Adresa;
	}

	public void setAdresa(String adresa) {
		Adresa = adresa;
	}

	public String getTelefon() {
		return Telefon;
	}

	public void setTelefon(String telefon) {
		Telefon = telefon;
	}

	@Override
	public String toString() {
		return Nume+" "+Adresa+" "+Telefon+" ";
	}

}
