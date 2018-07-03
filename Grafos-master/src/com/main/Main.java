package com.main;

import java.io.File;
import com.dijk.Dijkstra;
import com.dijk.Grafo;

public class Main {

	public static void main(String[] args) {
	
			Grafo grafo= new Grafo();
			grafo.leerArchivo(new File("entrada.in"));
			Dijkstra s= new Dijkstra(grafo,3);
			s.resolver();
			s.mostrarResultadoEnConsola();
	

	}

}
