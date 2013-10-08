package com.collectivebuying;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GerenteDeCadastroTest {
	
	private ValidacaoDeEntradas validacao;
	private GerenteDeCadastro g;
	private GerenteDeCompra gerenteDeCompra;
	private Cliente c1, c2;
	private Produto p1, p2;
	private Fornecedor f1,f2;

	@Before
	public void criarGerente() {
		gerenteDeCompra = new GerenteDeCompra();
		g = new GerenteDeCadastro();
		validacao = new ValidacaoDeEntradas();
	}
	
	@Before
	public void criarClientes(){
		c1 = new Cliente();
		c1.setNome("Robson");
		c1.setSobreNome("Soares");
		c1.setCpf("08213929475");
		c1.setNumero("565");
		c1.setEndereco("Rua da Maria");
		c1.setCidade("Rio Tinto");
		c1.setEstado("Paraíba");
		c1.setCep("58303590");
		c1.setEmail("robson@robson.com.br");
		c1.setTelefone("08388120365");
		c1.setSaldo(1000);
		
		c2 = new Cliente();
		c2.setNome("Karinna");
		c2.setSobreNome("Silveira");
		c2.setCpf("08213929372");
		c2.setNumero("567");
		c2.setEndereco("Rua da Aurora");
		c2.setCidade("Santa Rita");
		c2.setEstado("Paraíba");
		c2.setCep("54308234");
		c2.setEmail("karinna@karinna.com.br");
		c2.setTelefone("08388344523");
		c2.setSaldo(0);
		
	}
	@Before
	public void criarProdutos(){
		p1 = new Produto();
		p1.setNome("Rapadura Monte Alegre");
		p1.setID("1282");
		p1.setFornecedor(f1);
		p1.setValor(1.50);
		p1.setQuantidade(10);
		
		
		p2 = new Produto();
		p2.setNome("Cachaça São Paulo");
		p2.setID("3481");
		p2.setFornecedor(f2);
		p2.setValor(2.20);
		p2.setQuantidade(0);
		
		gerenteDeCompra.addProduto(p1);
		gerenteDeCompra.addProduto(p2);
	}
	@Before
	public void criarFornecedores(){
		f1 = new Fornecedor();
		f1.setNome("Usina Monte Alegre");
		f1.setCNPJ("02998301000181");
		
		f2 = new Fornecedor();
		f2.setNome("Usina Japungu");
		f2.setCNPJ("02998301000182");
	}
	@Test
	public void validaCPF() { 
		Assert.assertTrue("Esperava CPF v�lido",
				validacao.validaCPF("08446924475"));
		Assert.assertFalse("Esperava CPF inv�lido(menor)",
				validacao.validaCPF("34825"));
		Assert.assertFalse("Esperava CPF inv�lido(maior)",
				validacao.validaCPF("3482592555454"));
		Assert.assertFalse("Esperava CPF inv�lido(letras)",
				validacao.validaCPF("ahsfehrgdtr"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",
				validacao.validaCPF("00000000000"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",
				validacao.validaCPF("11111111111"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",
				validacao.validaCPF("22222222222"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",
				validacao.validaCPF("33333333333"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",
				validacao.validaCPF("44444444444"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",
				validacao.validaCPF("55555555555"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",
				validacao.validaCPF("66666666666"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",
				validacao.validaCPF("77777777777"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",
				validacao.validaCPF("88888888888"));
		Assert.assertFalse("Esperava CPF inv�lido(repetidos)",
				validacao.validaCPF("99999999999"));
	}
	@Test
	public void validaDataDeNascimento() {
		Assert.assertTrue("Esperava data v�lida",
				validacao.validaDataNascimento("15/02/2002"));
		Assert.assertFalse("Esperava data inv�lida ano",
				validacao.validaDataNascimento("10/02/20001"));
		Assert.assertFalse("Esperava data invalida(sem barra)",
				validacao.validaDataNascimento("10/0220001"));
		Assert.assertFalse("Esperava data invalida(sem barra)",
				validacao.validaDataNascimento("1002/20001"));
		Assert.assertFalse("Esperava data invalida(espaço)",
				validacao.validaDataNascimento(" "));
		Assert.assertFalse("Esperava data invalida(letras)",
				validacao.validaDataNascimento("aa/bb/bbbb"));
	}
	@Test
	public void validaCNPJ() {
		Assert.assertFalse("Esperava CNPJ v�lido",
				validacao.validaCNPJ("02998301000181"));

		Assert.assertTrue("Esperava CNPJ inv�lido(menor)",
				validacao.validaCNPJ("24827"));
		Assert.assertTrue("Esperava CNPJ inv�lido(maior)",
				validacao.validaCNPJ("029983010001813"));
		Assert.assertTrue("Esperava CNPJ inv�lido(letras)",
				validacao.validaCNPJ("ahsfehrgdtr"));
		Assert.assertTrue("Esperava CNPJ inv�lido(repetidos)",
				validacao.validaCNPJ("00000000000000"));
		Assert.assertTrue("Esperava CNPJ inv�lido(repetidos)",
				validacao.validaCNPJ("11111111111111"));
		Assert.assertTrue("Esperava CNPJ inv�lido(repetidos)",
				validacao.validaCNPJ("22222222222222"));
		Assert.assertTrue("Esperava CNPJ inv�lido(repetidos)",
				validacao.validaCNPJ("33333333333333"));
		Assert.assertTrue("Esperava CNPJ inv�lido(repetidos)",
				validacao.validaCNPJ("44444444444444"));
		Assert.assertTrue("Esperava CNPJ inv�lido(repetidos)",
				validacao.validaCNPJ("55555555555555"));
		Assert.assertTrue("Esperava CNPJ inv�lido(repetidos)",
				validacao.validaCNPJ("66666666666666"));
		Assert.assertTrue("Esperava CNPJ inv�lido(repetidos)",
				validacao.validaCNPJ("77777777777777"));
		Assert.assertTrue("Esperava CNPJ inv�lido(repetidos)",
				validacao.validaCNPJ("88888888888888"));
		Assert.assertTrue("Esperava CNPJ inv�lido(repetidos)",
				validacao.validaCNPJ("99999999999999"));
	}
	@Test
	public void validaEmail(){
		Assert.assertTrue("Esperava email valido",
				validacao.validaEmail("robson@robson.com"));
		Assert.assertFalse("Esperava email invalido",
				validacao.validaEmail("robson.robson.com"));
	}
	@Test
	public void validaCEP(){
		Assert.assertFalse("Esperava CEP válido",
				validacao.validaCEP("58303480"));
		Assert.assertTrue("Esperava CEP inv�lido(menor)",
				validacao.validaCEP("5830348"));
		Assert.assertTrue("Esperava CEP inv�lido(maior)",
				validacao.validaCEP("583034803"));
		Assert.assertTrue("Esperava CEP inv�lido(letras)",
				validacao.validaCEP("00000a0s"));
		Assert.assertTrue("Esperava CEP inv�lido(repetidos)",
				validacao.validaCEP("00000000"));
		Assert.assertTrue("Esperava CEP inv�lido(repetidos)",
				validacao.validaCEP("11111111"));
		Assert.assertTrue("Esperava CEP inv�lido(repetidos)",
				validacao.validaCEP("22222222"));
		Assert.assertTrue("Esperava CEP inv�lido(repetidos)",
				validacao.validaCEP("33333333"));
		Assert.assertTrue("Esperava CEP inv�lido(repetidos)",
				validacao.validaCEP("44444444"));
		Assert.assertTrue("Esperava CEP inv�lido(repetidos)",
				validacao.validaCEP("55555555"));
		Assert.assertTrue("Esperava CEP inv�lido(repetidos)",
				validacao.validaCEP("66666666"));
		Assert.assertTrue("Esperava CEP inv�lido(repetidos)",
				validacao.validaCEP("77777777"));
		Assert.assertTrue("Esperava CEP inv�lido(repetidos)",
				validacao.validaCEP("88888888"));
		Assert.assertTrue("Esperava CEP inv�lido(repetidos)",
				validacao.validaCEP("99999999"));
	}
	@Test
	public void validaNome(){
		Assert.assertFalse("Esperava invalido(caracteres especiais)",
				validacao.validaNome("@rob%son"));
		Assert.assertTrue("Esperava nome valido",
				validacao.validaNome("Robson"));
		Assert.assertFalse("Esperava nome invalido(numeros)",
				validacao.validaNome("Robson123"));
	}
	@Test
	public void validaSobreNome(){
		Assert.assertFalse("Esperava erro(caracteres especiais)",
				validacao.validaSobreNome("@rob%son"));
		Assert.assertTrue("Esperava válido",
				validacao.validaCidade("Soares De Lima"));
	}
	@Test
	public void validaCidade(){
		Assert.assertFalse("Esperava erro(caracteres especiais)",
				validacao.validaCidade("{Rio tinto}"));
		Assert.assertTrue("Esperava válido",
				validacao.validaCidade("Rio tinto"));
	}
	@Test
	public void validaEstado(){
		Assert.assertFalse("Esperava erro(caracteres especiais)",
				validacao.validaEstado("Paraíba100%"));
		Assert.assertTrue("Esperava válido",
				validacao.validaCidade("Rio De Janeiro"));
	}
	@Test
	public void cadastrarCliente(){
		Assert.assertEquals("Esperava cadastrado",g.cadastrarCliente(c1),c1);
		Assert.assertEquals("Esperava cadastrado",g.cadastrarCliente(c2),c2);
	}
	

	@Test
	public void verificarClienteAdicionado(){
		Assert.assertEquals("Esperava cadastrado",g.cadastrarCliente(c1),c1);
		Assert.assertEquals("Esperava cadastrado",g.cadastrarCliente(c2),c2);
		
		Assert.assertEquals(c1.getNome(), g.getClientes().get(0).getNome());
		Assert.assertEquals(c1.getCpf(), g.getClientes().get(0).getCpf());
		Assert.assertEquals(c1.getCep(), g.getClientes().get(0).getCep());
		Assert.assertEquals(c1.getCidade(), g.getClientes().get(0).getCidade());
		Assert.assertEquals(c1.getEmail(), g.getClientes().get(0).getEmail());
		Assert.assertEquals(c1.getEndereco(), g.getClientes().get(0).getEndereco());
		Assert.assertEquals(c1.getEstado(), g.getClientes().get(0).getEstado());
		Assert.assertEquals(c1.getNumero(), g.getClientes().get(0).getNumero());
		Assert.assertEquals(c1.getSobreNome(), g.getClientes().get(0).getSobreNome());
		
		
		
		Assert.assertEquals(c2.getNome(), g.getClientes().get(1).getNome());
		Assert.assertEquals(c2.getCpf(), g.getClientes().get(1).getCpf());
		Assert.assertEquals(c2.getCep(), g.getClientes().get(1).getCep());
		Assert.assertEquals(c2.getCidade(), g.getClientes().get(1).getCidade());
		Assert.assertEquals(c2.getEmail(), g.getClientes().get(1).getEmail());
		Assert.assertEquals(c2.getEndereco(), g.getClientes().get(1).getEndereco());
		Assert.assertEquals(c2.getEstado(), g.getClientes().get(1).getEstado());
		Assert.assertEquals(c2.getNumero(), g.getClientes().get(1).getNumero());
		Assert.assertEquals(c2.getSobreNome(), g.getClientes().get(1).getSobreNome());
		
	}

@Test
	public void excluirCliente(){
		Assert.assertEquals("Esperava cadastrado",g.cadastrarCliente(c1),c1);
		Assert.assertEquals("Esperava cadastrado",g.cadastrarCliente(c2),c2);
		Assert.assertTrue("Esperava removido",g.excluirCliente(c2));
		Assert.assertFalse("Esperava erro remoção(cliente inexistente)",g.excluirCliente(c2));
		
	}

@Test
	public void procurarCliente(){
		Assert.assertEquals("Esperava cadastrado",g.cadastrarCliente(c1),c1);
		Assert.assertEquals("Esperava cliente encontrado",c1,g.buscarCliente("08213929475"));
		
	}
@Test
	public void cadastrarProduto(){
		Assert.assertEquals("Esperava cadastrado",g.cadastrarProduto(p1),p1);
		Assert.assertEquals("esperava cadastrado",g.cadastrarProduto(p2),p2);	
	}
@Test
	public void excluirProduto(){	
		Assert.assertEquals("Esperava cadastrado",g.cadastrarProduto(p1),p1);
		Assert.assertEquals("esperava cadastrado",g.cadastrarProduto(p2),p2);
		Assert.assertTrue("Esperava excluído",gerenteDeCompra.excluirProduto(p1));
		Assert.assertFalse("Esperava inexistente",gerenteDeCompra.excluirProduto(p1));
	}
@Test
	public void procurarProduto(){
		gerenteDeCompra.addProduto(p1);
		gerenteDeCompra.addProduto(p2);
		Assert.assertEquals("Esperava encontrado",p1,gerenteDeCompra.buscarProduto("1282"));
		Assert.assertEquals("Esperava encontrado",p2,gerenteDeCompra.buscarProduto("3481"));
	}
	@Test
	public void cadastrarFornecedor(){
		Assert.assertTrue("Esperava cadastrado",g.cadastrarFornecedor(f1));
		Assert.assertTrue("Esperava cadastrado",g.cadastrarFornecedor(f2));
		Assert.assertFalse("Esperava já cadastrado",g.cadastrarFornecedor(f2));
	}
	@Test
	public void excluirFornecedor(){
		Assert.assertTrue("Esperava cadastrado",g.cadastrarFornecedor(f1));
		Assert.assertTrue("Esperava cadastrado",g.cadastrarFornecedor(f2));
		Assert.assertTrue("Esperava excluído!",g.excluirCliente(f1));
		Assert.assertFalse("Esperava INEXISTENTE!",g.excluirCliente(f1));
	}
	@Test
	public void procurarFornecedor(){
		Assert.assertTrue("Esperava cadastrado",g.cadastrarFornecedor(f1));
		Assert.assertEquals("Esperava encontrado",f1,g.buscarFornecedor("02998301000181"));
	}
	@Test
	public void comprarTest(){
		Assert.assertTrue(gerenteDeCompra.comprar(c1, p1.getID()));
		Assert.assertTrue(gerenteDeCompra.getProdutos().get(0).getQuantidade() == 9);
		Assert.assertTrue(gerenteDeCompra.comprar(c1, p1.getID()));
		Assert.assertTrue(gerenteDeCompra.getProdutos().get(0).getQuantidade() == 8);
		
		Assert.assertFalse(gerenteDeCompra.comprar(c1, p2.getID()));
		gerenteDeCompra.getProdutos().get(1).setQuantidade(1);
		Assert.assertTrue(gerenteDeCompra.comprar(c1, p2.getID()));
		Assert.assertTrue(gerenteDeCompra.getProdutos().get(1).getQuantidade() == 0);
		
	}
	@Test
	public void listarProdutosDisponiveisTest(){
		
		List<Produto> produtosDisponiveis = gerenteDeCompra.listarProdutosDisponiveis();
		
		Assert.assertEquals(produtosDisponiveis.size() , 1);
		Assert.assertEquals(p1, produtosDisponiveis.get(0));
		gerenteDeCompra.getProdutos().get(1).setQuantidade(1);
		
		produtosDisponiveis = gerenteDeCompra.listarProdutosDisponiveis();
		p2.setQuantidade(1);
		Assert.assertEquals(produtosDisponiveis.size() , 2);
		Assert.assertEquals(p2, produtosDisponiveis.get(1));
		
	}
	@Test
	public void produtoIsDisponivelTest(){
		Assert.assertTrue(gerenteDeCompra.produtoIsDisponivel(p1));
		Assert.assertFalse(gerenteDeCompra.produtoIsDisponivel(p2));
		p1.setQuantidade(0);
		p2.setQuantidade(10);
		Assert.assertTrue(gerenteDeCompra.produtoIsDisponivel(p2));
		Assert.assertFalse(gerenteDeCompra.produtoIsDisponivel(p1));
		
	}
	@Test
	public void clienteComSaldo(){
	
		Assert.assertTrue(gerenteDeCompra.clienteComSaldo(c1, p1.getValor()));
		c1.setSaldo((float) 1.50);
		Assert.assertTrue(gerenteDeCompra.clienteComSaldo(c1, p1.getValor()));
		c1.setSaldo(0);
		Assert.assertFalse(gerenteDeCompra.clienteComSaldo(c1, p1.getValor()));
		
		Assert.assertFalse(gerenteDeCompra.clienteComSaldo(c2, p1.getValor()));
		c2.setSaldo((float) 1.50);
		Assert.assertTrue(gerenteDeCompra.clienteComSaldo(c2, p1.getValor()));
		c2.setSaldo(0);
		Assert.assertFalse(gerenteDeCompra.clienteComSaldo(c2, p1.getValor()));
		
		c1.setSaldo(10);
		Assert.assertTrue(gerenteDeCompra.clienteComSaldo(c1, p2.getValor()));
		c1.setSaldo((float) 2.20);
		Assert.assertTrue(gerenteDeCompra.clienteComSaldo(c1, p2.getValor()));
		c1.setSaldo(0);
		Assert.assertFalse(gerenteDeCompra.clienteComSaldo(c1, p2.getValor()));
		
		c2.setSaldo(0);
		Assert.assertFalse(gerenteDeCompra.clienteComSaldo(c2, p2.getValor()));
		c2.setSaldo((float) 2.20);
		Assert.assertTrue(gerenteDeCompra.clienteComSaldo(c2, p2.getValor()));
		c2.setSaldo(0);
		Assert.assertFalse(gerenteDeCompra.clienteComSaldo(c2, p2.getValor()));
		
	}
	@Test
	public void dataLimite(){
		Calendar cal = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();
		
		cal2.set(cal.YEAR+1,cal.MONTH,cal.DAY_OF_MONTH,cal.HOUR_OF_DAY,cal.MINUTE);
		Assert.assertFalse(gerenteDeCompra.validaData(cal2));
		cal2.set(cal.YEAR,cal.MONTH+1,cal.DAY_OF_MONTH,cal.HOUR_OF_DAY,cal.MINUTE);
		Assert.assertFalse(gerenteDeCompra.validaData(cal2));
		cal2.set(cal.YEAR,cal.MONTH,cal.DAY_OF_MONTH+1,cal.HOUR_OF_DAY,cal.MINUTE);
		Assert.assertFalse(gerenteDeCompra.validaData(cal2));
		cal2.set(cal.YEAR,cal.MONTH,cal.DAY_OF_MONTH,cal.HOUR_OF_DAY+1,cal.MINUTE);
		Assert.assertFalse(gerenteDeCompra.validaData(cal2));
		cal2.set(cal.YEAR,cal.MONTH,cal.DAY_OF_MONTH,cal.HOUR_OF_DAY,cal.MINUTE+1);
		Assert.assertFalse(gerenteDeCompra.validaData(cal2));
		
	}
	
	

}