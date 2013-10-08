package com.collectivebuying;

import java.util.ArrayList;
import java.util.List;

public class GerenteDeCadastro {

	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Fornecedor> fornecedores;

	public GerenteDeCadastro() {
		clientes = new ArrayList<Cliente>();
		//produtos = new ArrayList<Produto>();
		fornecedores = new ArrayList<Fornecedor>();
	}

	
	public Cliente cadastrarCliente(Cliente c) {

		boolean verificado = verificarCpfExistente(c);
		if (verificado == true) {
			clientes.add(c);
			return c;
		}
		return null;

	}

	private boolean verificarCpfExistente(Cliente c) {

		boolean verificado = true;
		int i = 0;
		if (clientes != null) {
			while (i < clientes.size() && verificado != false) {
				if (clientes.get(i).getCpf().equals(c.getCpf())) {
					verificado = false;
				}
				i++;
			}
		}
		return verificado;

	}

	

	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	public boolean excluirCliente(Cliente c) {
		return clientes.remove(c);

	}
	public Produto cadastrarProduto(Produto p) {

		boolean verificado = verificarIDProdutoExistente(p);
		if (verificado == true) {
			return p;
		}
		return null;
	}


	private boolean verificarIDProdutoExistente(Produto p) {

		boolean verificado = true;
		int i = 0;
		if (produtos != null) {
			while (i < produtos.size() && verificado != false) {
				if (produtos.get(i).getID().equals(p.getID())) {
					verificado = false;
				}
				i++;
			}
		}
		return verificado;

	}


	public boolean cadastrarFornecedor(Fornecedor f) {

		boolean verificado = verificarCNPJExistente(f);
		if (verificado == true) {
			fornecedores.add(f);
		}
		return verificado;

	}

	private boolean verificarCNPJExistente(Fornecedor f) {

		boolean verificado = true;
		int i = 0;
		if (fornecedores != null) {
			while (i < fornecedores.size() && verificado != false) {
				if (fornecedores.get(i).getCNPJ().equals(f.getCNPJ())) {
					verificado = false;
				}
				i++;
			}
		}
		return verificado;
	}
	public boolean excluirCliente(Fornecedor f) {
		return fornecedores.remove(f);
	}
	public Fornecedor buscarFornecedor(String cnpj) {

		Fornecedor f2 = null;
		boolean verificado = true;
		int i = 0;
		if (fornecedores != null) {
			while (i < fornecedores.size() && verificado != false) {
				if (fornecedores.get(i).getCNPJ().equals(cnpj)) {
					f2 = fornecedores.get(i);
					verificado = false;
				}
				i++;
			}
		}

		return f2;
	}


	public Cliente buscarCliente(String cpf) {
		Cliente f2 = null;
		boolean verificado = true;
		int i = 0;
		if (clientes != null) {
			while (i < clientes.size() && verificado != false) {
				if (clientes.get(i).getCpf().equals(cpf)) {
					f2 = clientes.get(i);
					verificado = false;
				}
				i++;
			}
		}

		return f2;
	}

}