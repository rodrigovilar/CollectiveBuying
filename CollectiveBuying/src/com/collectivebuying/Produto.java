package com.collectivebuying;

import java.util.Calendar;

public class Produto {
	
	private String id;
	private String nome;
	private Fornecedor fornecedor;
	private double valor;
	private int quantidade;
	private Calendar dataLimite;

	public double getValor() {
		return valor;
	}
	public Calendar getDataLimite() {
		return dataLimite;
	}
	public void setDataLimite(Calendar dataLimite) {
		this.dataLimite = dataLimite;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setID(String id){
		this.id = id;
	}
	public String toString(){
		String s = "";
		s += "\nNome: "+nome;
		s += "\nID: "+id;
		s += "\nFornecedor: "+fornecedor;
		s += "\nQuantidade: "+quantidade;
		s += "\nValor: "+valor;
		return s;
	}
	public String getID() {
		return this.id;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setFornecedor(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
	}
	public void setValor(double d){
		this.valor = d;
	}

}