package Clase;


//CLASA COLET CARE CUPRINDE DATELE DESPRE COLET
public class Colet {
	
	String colet,Greutate,AWB;
	Client expeditor,destinatar;
	TipColet tip;

	public Colet(String colet, Client expeditor,Client destinatar, String Greutate, TipColet tip,String AWB) {
		this.colet = colet;
		this.expeditor=expeditor;
		this.destinatar=destinatar;
		this.Greutate = Greutate;
		this.tip = tip;
		this.AWB=AWB;
	}
	public String getAWB() {
		return AWB;
	}

	public void setAWB(String awb) {
		AWB = awb;
	}

	public String getColet() {
		return colet;
	}

	public void setColet(String Colet) {
		colet = Colet;
	}

	public String getAdresaExpeditor() {
		return expeditor.getAdresa();
	}
	public void setExpeditor(Client expeditor) {
		this.expeditor = expeditor;
	}
	public String getAdresaDestinatar() {
		return destinatar.getAdresa();
	}
	public void setDestinatar(Client destinatar) {
		this.destinatar = destinatar;
	}
	public String getNumeExpeditor()
	{
		return expeditor.getNume();
	}
	public String getNumeDestinatar()
	{
		return destinatar.getNume();
	}
	public String getTelefonExpeditor()
	{
		return expeditor.getTelefon();
	}
	public String getTelefonDestinatar()
	{
		return destinatar.getTelefon();
	}
	
	public String getGreutate() {
		return Greutate;
	}

	public void setGreutate(String greutate) {
		Greutate = greutate;
	}

	public TipColet getTip() {
		return tip;
	}

	public void setTip(TipColet tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		return colet +" "+expeditor.toString() +" "+destinatar.toString() + " "+Greutate + " " + tip+" "+AWB;

	}
	
	
	//FUNCTIA DE CALCULARE A PRETULUI
	public int CalcPret(String distanta,String tipcolet)
	{
		int pret=0;
		if(Integer.parseInt(Greutate)<4)
			pret+=5;
		else if(Integer.parseInt(Greutate)>20)
			pret+=15;
		else
			pret+=10;
		if(Double.parseDouble(distanta)<8)
			pret+=7;
		else
			pret+=12;
		if(tipcolet.equals("FRAGIL"))
			pret+=8;
		else if(tipcolet.equals("PRETIOS"))
			pret+=10;
		else
			pret+=12;
		return pret;
				
	}
	
	
	
	//FUNCTIA DE CALCULARE A TIMPULUI
	public double CalcTimp(String distanta,String tipcolet)
	{
		double timp=0;
		if(Integer.parseInt(Greutate)<20)
			timp+=0.5;
		else
			timp+=1;
		
		if(tipcolet.equals("FRAGIL"))
			timp+=1;
		else
			timp+=0.5;
		timp+=Double.parseDouble(distanta);
		return timp;
	}
}
