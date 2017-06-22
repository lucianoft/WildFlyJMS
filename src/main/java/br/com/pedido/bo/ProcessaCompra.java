package br.com.pedido.bo;

import javax.ejb.Stateless;

import br.com.pedido.domain.Compra;
import br.com.pedido.domain.Item;

@Stateless
public class ProcessaCompra {

	public Compra fecharCompra(Compra compra){
		
		System.out.println(compra.getNome());
        System.out.println(compra.getNumeroCartao());
        
        System.out.println("--- Itens --- ");
        
        float precoTotal = 0;
        for (Item item : compra.getItens()) {
        	System.out.println(item.getNome());
        	precoTotal += item.getPreco() * item.getQuantidade();
        }
        System.out.println("Total: " + precoTotal);
        

		return compra;
	}
}
