package Clase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


//CLASA PENTRU GENERARE DE GRAFURI
public class Graph{
	//CLASA PENTRU NODURILE GRAFULUI
public static class Nod{
		int n;
		String nume;
		boolean vizitat;
		
		LinkedList<VarfPonderat> varfuri;

		public Nod(int n, String nume) {
			
			this.n = n;
			this.nume = nume;
			vizitat = false;
			varfuri = new LinkedList<>();
		}
		
		boolean eVizitat() {
			return vizitat;
		}
		
		void vizitat() {
			vizitat = true;
		}
		void nevizitat() {
			vizitat = false;
		}
	}
	
public static class VarfPonderat implements Comparable<VarfPonderat> {
		Nod sursa;
		Nod destinatie;
		double distanta;
		
		VarfPonderat(Nod s, Nod d, double w){
			sursa = s;
			destinatie = d;
			distanta = w;
		}

		@Override
		public String toString() {
			return "VarfPonderat [sursa=" + sursa + ", destinatie=" + destinatie + ", distanta=" + distanta + "]";
		}

		@Override
		public int compareTo(VarfPonderat altul) {
			if(this.distanta > altul.distanta) {
				return 1;
			}
			else return -1;
		}
	
}
	
	
	
	//CLASA PENTRU GRAFURI
	public static class Graf{
		private Set<Nod> noduri;
		boolean directie;
		String path;
		public Graf(boolean d){
			this.directie = d;
			noduri = new HashSet<>();
		}
		public void adaugaNod(Nod n) {
			noduri.addAll(Arrays.asList(n));
		}
		
		public void adaugaVarf(Nod sursa, Nod destinatie, double distanta ) {
			noduri.add(sursa);
			noduri.add(destinatie);
			
			addAjutorVarf(sursa,destinatie,distanta);
			
			if(!directie && sursa != destinatie) {
				addAjutorVarf(destinatie,sursa,distanta);
			}
		}
		
		public void addAjutorVarf(Nod a, Nod b, double distanta ) {
			for(VarfPonderat varf : a.varfuri) {
				if(varf.sursa == a && varf.destinatie == b) {
					varf.distanta = distanta;
					return;
				}
			}
			a.varfuri.add(new VarfPonderat(a,b,distanta));
		}
		
		public void printVarfuri() {
			for(Nod nod : noduri) {
				LinkedList<VarfPonderat> varfuri = nod.varfuri;
				if(noduri.isEmpty()) {
					System.out.println("Nodul " + nod.nume + " nu are alte rute");
					continue;
				}
				System.out.println("Nodul " + nod.nume + " are rute la: ");
				for(VarfPonderat varf : varfuri) {
					System.out.println(varf.destinatie.nume + " (" + varf.distanta + ")");
				}
				System.out.println();
			}
		}
		
		public boolean areVarf(Nod sursa, Nod destinatie) {
			LinkedList<VarfPonderat> varfuri = sursa.varfuri;
			for(VarfPonderat varf : varfuri) {
				if(varf.destinatie == destinatie) {
					return true;
				}
			}
			return false;
		}
		
		public void resetareNoduriVizitate() {
			for(Nod nod : noduri) {
				nod.nevizitat();
			}
		}
		
		Nod cmrDrumNevizitat(HashMap<Nod,Double> celmaiscurtDrum) {
			double distantaS = Double.POSITIVE_INFINITY;
			Nod celmaiaproapenod = null;
			for(Nod nod: noduri) {
				if(nod.eVizitat()) 
					continue;
				
				
				double distantacurenta = celmaiscurtDrum.get(nod);
				
				if(distantacurenta == Double.POSITIVE_INFINITY) {
					continue;
				}
				if(distantacurenta < distantaS) {
					distantaS = distantacurenta;
					celmaiaproapenod = nod;
				}
			}
			return celmaiaproapenod;
		}
		
		public String Dijkstra(String startS, String finalulS) {
			Nod start = null,finalul = null;
			for(Nod nod : noduri ) {
				if(nod.nume.compareTo(startS) == 0) {
					start = nod;
				}
				if(nod.nume.compareTo(finalulS) == 0) {
					finalul = nod;
				}
				
			}
			
			
			HashMap<Nod,Nod> schimbare = new HashMap<>();
			schimbare.put(start, null);
			
			
			HashMap<Nod, Double> celmaiscurtDrum = new HashMap<>();
			
			for(Nod nod : noduri) {
				if(nod == start) {
					celmaiscurtDrum.put(start, 0.0);
				}
				else {
					celmaiscurtDrum.put(nod, Double.POSITIVE_INFINITY);
				}
			}
			
			for(VarfPonderat varf : start.varfuri) {
				celmaiscurtDrum.put(varf.destinatie, varf.distanta);
				schimbare.put(varf.destinatie, start);
			}
			start.vizitat();
			
			while(true) {
				Nod curent = cmrDrumNevizitat(celmaiscurtDrum);
				if(curent == null) {
					
					System.out.println("Nu exista drum intre" + start.nume + " si " + finalul.nume);
					return path;
				}
				
				if(curent == finalul) {
					System.out.println("Cel mai rapid drum : ");
				
				
				Nod copil = finalul;
				path = finalul.nume;
				while(true) {
					Nod parinte = schimbare.get(copil);
					if(parinte == null) {
						break;
					}
					path = parinte.nume + " " + path+";"+celmaiscurtDrum.get(finalul);
					copil = parinte;
				}
				System.out.println(path);
				//System.out.println("Drumul costa: " + celmaiscurtDrum.get(finalul));
				return path;
				}
			curent.vizitat();
			for(VarfPonderat varf: curent.varfuri) {
				if(varf.destinatie.eVizitat()) {
					continue;
				}
				if(celmaiscurtDrum.get(curent) + varf.distanta < celmaiscurtDrum.get(varf.destinatie)) {
					celmaiscurtDrum.put(varf.destinatie, celmaiscurtDrum.get(curent) + varf.distanta);
					schimbare.put(varf.destinatie, curent);
					}
				}
		
			}
			
		}	
		
		//FUNCTIA CARE CREEAZA UN GRAF
		public void CreateGraph(Graf grafic)
		{
			//grafic=new Graf(true);
			Nod Timisoara=new Nod(0,"Timisoara");
			Nod Arad=new Nod(1,"Arad");
			Nod Iasi=new Nod(2,"Iasi");
			Nod Bucuresti=new Nod(3,"Bucuresti");
			Nod Craiova=new Nod(4,"Craiova");
			Nod Cluj=new Nod(5,"Cluj");
			Nod Constanta=new Nod(6,"Constanta");
			Nod Suceava=new Nod(7,"Suceava");
			Nod Brasov=new Nod(8,"Brasov");
			Nod Sibiu=new Nod(9,"Sibiu");
			
			
			grafic.adaugaVarf(Timisoara, Arad, 2);
			grafic.adaugaVarf(Timisoara, Craiova, 4);
			grafic.adaugaVarf(Arad, Timisoara, 2);
			grafic.adaugaVarf(Arad,Cluj,5);
			grafic.adaugaVarf(Arad, Sibiu,5 );
			grafic.adaugaVarf(Craiova,Timisoara, 4);
			grafic.adaugaVarf(Craiova,Sibiu,6);
			grafic.adaugaVarf(Craiova, Bucuresti, 6);
			grafic.adaugaVarf(Cluj, Arad, 5);
			grafic.adaugaVarf(Cluj, Sibiu, 3);
			grafic.adaugaVarf(Cluj,Suceava, 6);
			grafic.adaugaVarf(Sibiu, Cluj, 3);
			grafic.adaugaVarf(Sibiu, Arad, 5);
			grafic.adaugaVarf(Sibiu, Craiova, 6);
			grafic.adaugaVarf(Sibiu, Brasov, 2);
			grafic.adaugaVarf(Suceava, Cluj, 6);
			grafic.adaugaVarf(Suceava, Iasi, 4);
			grafic.adaugaVarf(Iasi, Suceava, 4);
			grafic.adaugaVarf(Iasi, Brasov, 4);
			grafic.adaugaVarf(Iasi, Constanta, 6);
			grafic.adaugaVarf(Brasov, Sibiu, 2);
			grafic.adaugaVarf(Brasov, Iasi, 4);
			grafic.adaugaVarf(Brasov, Bucuresti, 3);
			grafic.adaugaVarf(Bucuresti,Craiova,6);
			grafic.adaugaVarf(Bucuresti, Brasov, 3);
			grafic.adaugaVarf(Bucuresti, Constanta, 6);
			grafic.adaugaVarf(Constanta, Iasi, 6);
			grafic.adaugaVarf(Constanta,Bucuresti,6);
		}
		}
	
	}

