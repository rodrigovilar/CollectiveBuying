package com.collectivebuying;


import java.util.List;

public class GerarListaClientes implements Runnable{
	
	List<Cliente> clientes;
	
	public GerarListaClientes(List<Cliente> clientes){
		this.clientes = clientes;
	}
		
	@Override
	public void run() {
		if(clientes!=null){
		for (Cliente i:clientes) {
			System.out.println("Nome: "+i.getNome()+" CPF: "+i.getCpf());
		}
		
		}
		
	}

}
