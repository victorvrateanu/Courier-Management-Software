package Clase;

import Clase.Graph.Graf;

public class TestGraph {

	public static void main(String[] args) {
		String drum1,drum2;
		Graf grafic = new Graf(true);
		grafic.CreateGraph(grafic);
		drum2 = grafic.Dijkstra("Timisoara", "Iasi");
		
		
		System.out.println("******************");
		//System.out.println(drum1);
		System.out.println(drum2);
		System.out.println("******************");
	}

}

