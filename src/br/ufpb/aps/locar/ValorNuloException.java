package br.ufpb.aps.locar;

public class ValorNuloException extends RuntimeException {
	
	public ValorNuloException () {
		super("Valor nulo! Imposs�vel adicionar!");
	}
}
