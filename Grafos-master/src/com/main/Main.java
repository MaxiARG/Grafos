package com.main;

import java.io.IOException;

import com.grafos.DFS;
import com.grafos.GrafoNDNP;

public class Main {

	public static void main(String[] args) {
		try {
			GrafoNDNP grafo= new GrafoNDNP("entrada.in");
			DFS dfs= new DFS(grafo,0);
			dfs.ejecutar();
			dfs.escribirSolucionEnConsola();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
