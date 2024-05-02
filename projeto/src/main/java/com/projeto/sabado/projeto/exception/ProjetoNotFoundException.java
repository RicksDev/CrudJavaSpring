package com.projeto.sabado.projeto.exception;

public class ProjetoNotFoundException  extends RuntimeException{
	
	//identificador de versão
	//classe Serializable
	//final a variável é definida em uma unica vez
	//long => um int com maior quantidade de numeros disponiveis
	
	private static final long serialVersionUID = 1L;
	
	public ProjetoNotFoundException() {
		super();
	}
	public ProjetoNotFoundException(String mensagemCustomizada) {
		super(mensagemCustomizada);
	}
}
