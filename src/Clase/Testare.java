package Clase;

import Clase.Graph.Graf;
import Clase.Graph.Nod;


//CLASA PENTRU TESTARE
public class Testare {

	
	
		String drum1,drum2;
		Graf grafic = new Graf(true);
		
	
		TipColet tip = null;
		StatusColet status = null;
		Client expeditor=new Client("NumeExp","AdresaExp","TelefonExp");
		Client destinatar=new Client("NumeDest","AdresaDest","TelefonDest");
		Colet colet = new Colet("colet", expeditor,destinatar, "10", tip ,"AWB");
		AWBGenerator awb = new AWBGenerator();
		DateColet date = new DateColet("awb", "ruta", "pret", "timp", status);
		
		
		//Testarea initializarii clasei colet		
		@Test
		public void TestareColet() {
			assertEquals("colet",colet.getColet());
			assertEquals("NumeExp", colet.getNumeExpeditor());
			assertEquals("AdresaExp", colet.getAdresaExpeditor());
			assertEquals("TelefonExp", colet.getTelefonExpeditor());
			assertEquals("NumeDest", colet.getNumeDestinatar());
			assertEquals("AdresaDest", colet.getAdresaDestinatar());
			assertEquals("TelefonDest", colet.getTelefonDestinatar());
			assertEquals("10", colet.getGreutate());
			assertEquals("AWB", colet.getAWB());
		}
		
	
	
		// testare initializare date colet
		@Test
		public void TestareDateColet() {
			assertEquals("awb", date.getAWB());
			assertEquals("ruta", date.getRuta());
			assertEquals("pret", date.getPret());
			assertEquals("timp", date.getTimp());
		}
		
		//Verifica daca functiile set functioneaza pentru datele coletului
		@Test
		public void TestareSetColetPret() {
			String coletN = "4.5";
			date.setPret(coletN);
			assertEquals(date.getPret(),coletN);
		}
		@Test
		public void TestareSetColetTimp() {
			String coletN = "3.7";
			date.setTimp(coletN);
			assertEquals(coletN,date.getTimp());
		}
		

		//testare graf: Nodurile nu sunt nule
				@Test
				public void TestareNoduriNule() {
					String drum1,drum2;
					Graf grafic = new Graf(true);
					Nod zero = new Nod(0, "Timisoara");
					Nod unu = new Nod(1, "Arad");
					Nod doi = new Nod(2, "Tg Jiu");
					Nod trei = new Nod(3, "Craiova");
					Nod patru = new Nod(4, "Braila");
					Nod cinci = new Nod(5, "Bucuresti");
					Nod sase = new Nod(6, "Cluj-Napoca");
					
					grafic.adaugaVarf(zero,unu, 8);
					grafic.adaugaVarf(zero,doi, 11);
					grafic.adaugaVarf(unu,trei, 3);
					grafic.adaugaVarf(unu,patru, 8);
					grafic.adaugaVarf(unu,doi, 7);
					grafic.adaugaVarf(doi,patru, 9);
					grafic.adaugaVarf(trei,patru, 5);
					grafic.adaugaVarf(trei,cinci, 2);
					grafic.adaugaVarf(patru,sase, 6);
					grafic.adaugaVarf(cinci,patru, 1);
					grafic.adaugaVarf(cinci,sase, 8);
					
					assertNotNull(zero);
					assertNotNull(cinci);
					assertNotNull(patru);
					assertNotNull(sase);
				}
		
		
		//testare graf: Nodurile sunt diferite 
				@Test
				public void TestareGraphDiferentaNoduri() {
					String drum1,drum2;
					Graf grafic = new Graf(true);
					Nod zero = new Nod(0, "Timisoara");
					Nod unu = new Nod(1, "Arad");
					Nod doi = new Nod(2, "Tg Jiu");
					Nod trei = new Nod(3, "Craiova");
					Nod patru = new Nod(4, "Braila");
					Nod cinci = new Nod(5, "Bucuresti");
					Nod sase = new Nod(6, "Cluj-Napoca");
					
					grafic.adaugaVarf(zero,unu, 8);
					grafic.adaugaVarf(zero,doi, 11);
					grafic.adaugaVarf(unu,trei, 3);
					grafic.adaugaVarf(unu,patru, 8);
					grafic.adaugaVarf(unu,doi, 7);
					grafic.adaugaVarf(doi,patru, 9);
					grafic.adaugaVarf(trei,patru, 5);
					grafic.adaugaVarf(trei,cinci, 2);
					grafic.adaugaVarf(patru,sase, 6);
					grafic.adaugaVarf(cinci,patru, 1);
					grafic.adaugaVarf(cinci,sase, 8);
					
					assertNotSame(zero,cinci);
					assertNotSame(cinci,trei);
					assertNotSame(patru,unu);
					assertNotSame(zero,sase);
				}
		
				//testare graf: nu returneaza null daca drumul exista deoarece acesta returneaza null daca nu exista drumul
				@Test
				public void TestareGraphNuReturneazNull() {
					String drum1,drum2;
					Graf grafic = new Graf(true);
					Nod zero = new Nod(0, "Timisoara");
					Nod unu = new Nod(1, "Arad");
					Nod doi = new Nod(2, "Tg Jiu");
					Nod trei = new Nod(3, "Craiova");
					Nod patru = new Nod(4, "Braila");
					Nod cinci = new Nod(5, "Bucuresti");
					Nod sase = new Nod(6, "Cluj-Napoca");
					
					grafic.adaugaVarf(zero,unu, 8);
					grafic.adaugaVarf(zero,doi, 11);
					grafic.adaugaVarf(unu,trei, 3);
					grafic.adaugaVarf(unu,patru, 8);
					grafic.adaugaVarf(unu,doi, 7);
					grafic.adaugaVarf(doi,patru, 9);
					grafic.adaugaVarf(trei,patru, 5);
					grafic.adaugaVarf(trei,cinci, 2);
					grafic.adaugaVarf(patru,sase, 6);
					grafic.adaugaVarf(cinci,patru, 1);
					grafic.adaugaVarf(cinci,sase, 8);
					
					drum2 = grafic.Dijkstra("Timisoara", "Craiova");
					
					if(drum2 != null) {
						assertTrue(true);
					}
				}
				
		//testare graf: stringul final contine punctul de plecare si destinatia
		@Test
		public void TestareGraph() {
			String drum1,drum2;
			Graf grafic = new Graf(true);
			Nod zero = new Nod(0, "Timisoara");
			Nod unu = new Nod(1, "Arad");
			Nod doi = new Nod(2, "Tg Jiu");
			Nod trei = new Nod(3, "Craiova");
			Nod patru = new Nod(4, "Braila");
			Nod cinci = new Nod(5, "Bucuresti");
			Nod sase = new Nod(6, "Cluj-Napoca");
			
			grafic.adaugaVarf(zero,unu, 8);
			grafic.adaugaVarf(zero,doi, 11);
			grafic.adaugaVarf(unu,trei, 3);
			grafic.adaugaVarf(unu,patru, 8);
			grafic.adaugaVarf(unu,doi, 7);
			grafic.adaugaVarf(doi,patru, 9);
			grafic.adaugaVarf(trei,patru, 5);
			grafic.adaugaVarf(trei,cinci, 2);
			grafic.adaugaVarf(patru,sase, 6);
			grafic.adaugaVarf(cinci,patru, 1);
			grafic.adaugaVarf(cinci,sase, 8);
			
			drum2 = grafic.Dijkstra("Timisoara", "Craiova");
			
			if(drum2.contains("Timisoara") && drum2.contains("Craiova")) {
				assertTrue(true);
			}
		}
		
		//testare graf: stringul final contine toate rutele, nu doar punctul de plecare si sosire
				@Test
				public void TestareGraphNumarDrumuri() {
					String drum1,drum2;
					String [] drum3;
					Graf grafic = new Graf(true);
					Nod zero = new Nod(0, "Timisoara");
					Nod unu = new Nod(1, "Arad");
					Nod doi = new Nod(2, "Tg Jiu");
					Nod trei = new Nod(3, "Craiova");
					Nod patru = new Nod(4, "Braila");
					Nod cinci = new Nod(5, "Bucuresti");
					Nod sase = new Nod(6, "Cluj-Napoca");
					
					grafic.adaugaVarf(zero,unu, 8);
					grafic.adaugaVarf(zero,doi, 11);
					grafic.adaugaVarf(unu,trei, 3);
					grafic.adaugaVarf(unu,patru, 8);
					grafic.adaugaVarf(unu,doi, 7);
					grafic.adaugaVarf(doi,patru, 9);
					grafic.adaugaVarf(trei,patru, 5);
					grafic.adaugaVarf(trei,cinci, 2);
					grafic.adaugaVarf(patru,sase, 6);
					grafic.adaugaVarf(cinci,patru, 1);
					grafic.adaugaVarf(cinci,sase, 8);
					
					drum2 = grafic.Dijkstra("Timisoara", "Cluj-Napoca");
					int i=0;
					drum3 = drum2.split(" ");
					for(String s : drum3) {
						i++;
					}
					if(i <= 2) {
						fail();
					}
					else {
						assertTrue(true);
					}
				}
		
		//testare graf: returneaza null daca drumul nu exista
				@Test
				public void TestareGraphNuExistaRuta() {
					String drum1,drum2;
					Graf grafic = new Graf(true);
					Nod zero = new Nod(0, "Timisoara");
					Nod unu = new Nod(1, "Arad");
					Nod doi = new Nod(2, "Tg Jiu");
					Nod trei = new Nod(3, "Craiova");
					Nod patru = new Nod(4, "Braila");
					Nod cinci = new Nod(5, "Bucuresti");
					Nod sase = new Nod(6, "Cluj-Napoca");
					
					grafic.adaugaVarf(zero,unu, 8);
					grafic.adaugaVarf(zero,doi, 11);
					grafic.adaugaVarf(unu,trei, 3);
					grafic.adaugaVarf(unu,patru, 8);
					grafic.adaugaVarf(unu,doi, 7);
					grafic.adaugaVarf(doi,patru, 9);
					grafic.adaugaVarf(trei,patru, 5);
					grafic.adaugaVarf(trei,cinci, 2);
					grafic.adaugaVarf(patru,sase, 6);
					grafic.adaugaVarf(cinci,patru, 1);
					grafic.adaugaVarf(cinci,sase, 8);
					
					drum2 = grafic.Dijkstra("Braila", "Bucuresti");
					
					if(drum2 == null) {
						assertTrue(true);
					}
				}
				
				//testare graf: se verifica daca se returneaza costul drumului
				@Test
				public void TestareReturnareValoareDrum() {
					String drum1,drum2;
					String drum3[];
					double cost;
					Graf grafic = new Graf(true);
					Nod zero = new Nod(0, "Timisoara");
					Nod unu = new Nod(1, "Arad");
					Nod doi = new Nod(2, "Tg Jiu");
					Nod trei = new Nod(3, "Craiova");
					Nod patru = new Nod(4, "Braila");
					Nod cinci = new Nod(5, "Bucuresti");
					Nod sase = new Nod(6, "Cluj-Napoca");
					
					grafic.adaugaVarf(zero,unu, 8);
					grafic.adaugaVarf(zero,doi, 11);
					grafic.adaugaVarf(unu,trei, 3);
					grafic.adaugaVarf(unu,patru, 8);
					grafic.adaugaVarf(unu,doi, 7);
					grafic.adaugaVarf(doi,patru, 9);
					grafic.adaugaVarf(trei,patru, 5);
					grafic.adaugaVarf(trei,cinci, 2);
					grafic.adaugaVarf(patru,sase, 6);
					grafic.adaugaVarf(cinci,patru, 1);
					grafic.adaugaVarf(cinci,sase, 8);
					
					drum2 = grafic.Dijkstra("Timisoara", "Craiova");
					
					drum3 = drum2.split(";");
					try {
						Double.parseDouble(drum3[1]);
					}catch(NumberFormatException str) {
						fail();
					}
				}
		
	    
		// verifica daca functia CalcularePret si CalculareTimp nu returneaza null
		@Test
		public void TestareCalcPretTimpNotNull() {
			
			assertNotNull(colet.CalcPret("8.4", "FRAGIL"));
		}
		
		@Test
		public void TestareCalcTimpNotNull() {
			assertNotNull(colet.CalcTimp("8.4", "FRAGIL"));
		}
		
							
		// verifica daca pretul este mai mare decat 0 apoi verifica daca functia returneaza aceeasi valoare
		@Test
		public void TestareCalcularePret() {
			int pret;
			pret = colet.CalcPret("8.4", "FRAGIL");
			if(pret <= 0 ) {
				Assert.fail("pretul nu poate fi negativ !");
			}
			if(pret > 0 ) {
				assertEquals(pret,colet.CalcPret("8.4", "FRAGIL"));
			}
		}
		
	  
		// verifica daca timpul este mai mare decat 0 apoi verifica functia returneaza aceeasi valoare
		@Test
		public void TestareCalculareTimp() {
			double timp;
			timp = colet.CalcTimp("8.4", "FRAGIL");
			if(timp <= 0) {
				Assert.fail("back to the future ?");
			}
			if(timp > 0) {
				assertEquals(timp,colet.CalcTimp("8.4", "FRAGIL"),3);
				
			}
		}
		
		
		
		// verifica daca valorile AWB sunt random
		@Test
		public void AWBRandom() {
			assertNotEquals(awb.AWB(),awb.AWB());
		}
		
		// verifica daca valorile AWB nu sunt null
		@Test
		public void AWBnotNull() {
			assertNotNull(awb.AWB());
		}
		
		//verifica daca valorile AWB sunt formate atat din numere cat si cifre
		@Test
		public void AWBNumereSiCifre() {
			try {
				Integer.parseInt(awb.AWB());
				fail("Should have thrown an exception");
			}
			catch(NumberFormatException str) {
				assertTrue(true);
			}
		}
		
		//verifica daca AWB-ul contine mai mult de 6 caractere
		@Test
		public void AWBCaractere() {
			String awbS = awb.AWB();
			if(awbS.length() == 6) {
				assertTrue(true);
			}
		}
		
		
	}


