package br.ufpb.aps.locar;

public class NaoCadastradoNoSistemaException extends RuntimeException {
	
	public NaoCadastradoNoSistemaException () {
		super("N�o cadastrado no sistema, imposs�vel remover!");
	}
}
