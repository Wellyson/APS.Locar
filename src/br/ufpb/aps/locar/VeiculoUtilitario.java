package br.ufpb.aps.locar;

import java.io.Serializable;

public class VeiculoUtilitario extends Veiculo implements Serializable {
	
	private final int QTDE_MAXIMA_DE_PASSAGEIRO = 2;
	public String numeroChasi;
	
	public VeiculoUtilitario(){
		super();
	}
	
	public VeiculoUtilitario(String marca, String numeracao, String placa){
		super(marca,numeracao,placa);
	}
	
	
	public int getQTDE_MAXIMA_DE_PASSAGEIRO(){
		return QTDE_MAXIMA_DE_PASSAGEIRO;
	}

	

	public void setNumeroChasi (String numeroChasi) {
		this.numeroChasi = numeroChasi;
	}
	
	public String getNumeroChasi () {
		return numeroChasi;
	}

}
