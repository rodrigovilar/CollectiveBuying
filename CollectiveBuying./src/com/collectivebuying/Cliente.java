package com.collectivebuying;

public class Cliente {
	private String nome;
	private String sobreNome;
	private String cpf;
	private String endereco;
	private String numero;
	private String cidade;
	private String estado;
	private String cep;
	private String email;
	private String telefone;
	private float saldo;
	
	
	public String getSobreNome() {
		return sobreNome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getNumero() {
		return numero;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getCep() {
		return cep;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;	
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setEmail(String email) {
		this.email = email;
		
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return this.cpf;
	}
	public String getNome() {
		return this.nome;
	}
	

	
}
