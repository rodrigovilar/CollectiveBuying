package com.collectivebuying;

import java.util.List;

public class GerenteDeInformacao {
	
	public void imprimirListaClientes(List<Cliente> clientes){ //Mini teste 9 (Robson Soares)
		GerarListaClientes g = new GerarListaClientes(clientes);
		g.run();
	}

}
