package com.collectivebuying;

import java.util.List;

public class GerenteDeInformacao {
	
	public void imprimirListaClientes(List<Cliente> clientes){
		GerarListaClientes g = new GerarListaClientes(clientes);
		g.run();
	}

}
