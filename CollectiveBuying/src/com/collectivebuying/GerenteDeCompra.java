import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class GerenteDeCompra{

	private List<Produto> produtos = new ArrayList<Produto>();
	private List<Produto> produtosDisponíveis;
	
	public List<Produto> listarProdutosDisponiveis(){
		List<Produto> produtosDisponiveis = new ArrayList<Produto>();
		for(Produto p: produtos){
			if(produtoIsDisponivel(p)){produtosDisponiveis.add(p);}
		}
		return produtosDisponiveis;
	}
	
	public void atualizarProdutosDisponíveis(){
		produtosDisponíveis = listarProdutosDisponiveis();
	}
	
	public boolean validaData(Calendar dataDeVencimento){//retorna true caso a data seja após a data atual e false caso contrário
		Calendar cal = new GregorianCalendar();
		if((cal.get(cal.YEAR) < dataDeVencimento.get(dataDeVencimento.YEAR)))return true;
		if((cal.get(cal.YEAR) > dataDeVencimento.get(dataDeVencimento.YEAR)))return false;
		
		if((cal.get(cal.MONTH) < dataDeVencimento.get(dataDeVencimento.MONTH)))return true;
		if((cal.get(cal.MONTH) > dataDeVencimento.get(dataDeVencimento.MONTH)))return false;
		
		if((cal.get(cal.DAY_OF_MONTH) < dataDeVencimento.get(dataDeVencimento.DAY_OF_MONTH)))return true;
		if((cal.get(cal.DAY_OF_MONTH) > dataDeVencimento.get(dataDeVencimento.DAY_OF_MONTH)))return false;
		
		if((cal.get(cal.HOUR_OF_DAY) < dataDeVencimento.get(dataDeVencimento.HOUR_OF_DAY)))return true;
		if((cal.get(cal.HOUR_OF_DAY) > dataDeVencimento.get(dataDeVencimento.HOUR_OF_DAY)))return false;
		
		if((cal.get(cal.MINUTE) < dataDeVencimento.get(dataDeVencimento.MINUTE)))return true;
		if((cal.get(cal.MINUTE) > dataDeVencimento.get(dataDeVencimento.MINUTE)))return false;		
		
		
		return false;	
	}
	public boolean clienteComSaldo(Cliente c,double preco){
		if(c.getSaldo() < preco)return false;
		return true;
	}
	
	public boolean excluirProduto(Produto p) {
		return produtos.remove(p);

	}
	public boolean comprar(Cliente c, String id){
		Produto p = buscarProduto(id);
		if(produtoIsDisponivel(p)){
			p.setQuantidade(p.getQuantidade()-1);
			return true;
		}
		return false;
	}
	
	public Produto buscarProduto(String id) {
		Produto f2 = null;
		boolean verificado = true;
		int i = 0;
		if (produtos != null) {
			while (i < produtos.size() && verificado != false) {
				if (produtos.get(i).getID().equals(id)) {
					f2 = produtos.get(i);
					verificado = false;
				}
				i++;
			}
		}

		return f2;
	}
	
	public void addProduto(Produto p) {
		produtos.add(p);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public boolean produtoIsDisponivel(Produto produto){
		if(produto.getQuantidade() > 0) return true;
		return false;
	}


	
	
	
	
	
}