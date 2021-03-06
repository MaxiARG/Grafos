package com.dijk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private int cantAristas;
	private int cantNodos;
	private MatrizSimetrica matrizNodos;
	private List<Nodo> nodos;

	
	public void leerArchivo(File f){
		FileReader fr = null;
		BufferedReader br = null;
		
		try{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
			String linea;
			linea = br.readLine();
			String[] valores = linea.split(" ");
			this.cantNodos = Integer.valueOf(valores[0]);
			matrizNodos = new MatrizSimetrica(cantNodos);
			this.cantAristas =  Integer.valueOf(valores[1]);
			int i = 0;
			nodos = new ArrayList<>(cantNodos);
			for(i = 0 ; i<cantNodos ; i++){
				nodos.add(new Nodo(i));
			}

			while((linea=br.readLine())!=null){
				valores = linea.split(" ");
			
				Integer nodoInicio = Integer.valueOf(valores[0]);
				Integer nodoDestino = Integer.valueOf(valores[1]);
				Integer costo = Integer.valueOf(valores[2]);
				if(nodoInicio<nodoDestino) {
					matrizNodos.insertarEnVector(nodoInicio, nodoDestino , costo);
 				
				}else {
					matrizNodos.insertarEnVector(nodoDestino, nodoInicio , costo);
 				
				}
 				
 				Nodo nuevoNodoDestino = new Nodo(nodoDestino);
 				Nodo nuevoNodoInicial = new Nodo(nodoInicio);
 				nodos.get(nodoInicio).agregarVecino(nuevoNodoDestino);
 				//nodos.get(nodoDestino).agregarVecino(nuevoNodoInicial);
 				
			}
	
		}catch(IOException ioex){
			ioex.printStackTrace();
		}
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public MatrizSimetrica getMatrizNodos() {
		return matrizNodos;
	}

	public void setMatrizNodos(MatrizSimetrica matrizNodos) {
		this.matrizNodos = matrizNodos;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}
	public List<Nodo> conseguirNodosVecinos(int nodoActual){
		return nodos.get(nodoActual).conseguirVecinos();
	}
}
