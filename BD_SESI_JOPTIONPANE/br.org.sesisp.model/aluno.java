package br.org.sesisp.model;

public class aluno {
	//atributos 
	private int ra;
	private String nome;
	private int idade;
	
	//construtor padrao
	public aluno() {
		
	}
	
	//metodo get e set
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
