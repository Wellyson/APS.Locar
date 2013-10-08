package br.ufpb.aps.locar;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static int quantidade;	
	public String CEP;
	
	/* @J�ssyca */
	private int pontos;
	
	public Cliente(){
		super();
		quantidade++;
	}
	
	/* @J�ssyca */
	public Cliente(String nome, String cpf) {
		super(nome, cpf);
		pontos = 0;		
		
		/* tive que repetir para n�o causar problemas nos outros testes, mas n�o vejo necessidade. */
		quantidade++;
	}
	
	public void setCEP (String CEP) {
		this.CEP = CEP;
	}
	
	public String getCEP () {
		return CEP;
	}	
	
	public void setPontos (int _pontos) {
		this.pontos = _pontos;
	}
	
	public int getPontos () {
		return pontos;
	}

}


