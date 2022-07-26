package Clase;


//CLASA DATECOLET CARE CUPRINDE INFORMATIILE DESPRE COLET
public class DateColet {

String AWB,ruta,pret,timp;
StatusColet status;
public DateColet(String awb,String ruta,String pret,String timp,StatusColet status)
{
	this.AWB=awb;
	this.ruta=ruta;
	this.pret=pret;
	this.status=status;
	this.timp=timp;
}

public String getTimp() {
	return timp;
}

public void setTimp(String timp) {
	this.timp = timp;
}

public String getAWB() {
		return AWB;
	}
	public void setAWB(String aWB) {
		AWB = aWB;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getPret() {
		return pret;
	}
	public void setPret(String pret) {
		this.pret = pret;
	}
	public StatusColet getStatus() {
		return status;
	}
	public void setStatus(StatusColet status) {
		this.status = status;
	}	
	@Override
	public String toString()
	{
		return AWB+" "+timp+" ore "+pret+" lei "+status+" "+ruta;
	}

	
	
}
