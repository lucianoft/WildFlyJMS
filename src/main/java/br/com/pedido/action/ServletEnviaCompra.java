package br.com.pedido.action;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pedido.bo.EnviaCompra;
import br.com.pedido.domain.Compra;
import br.com.pedido.domain.Item;
 

 
@WebServlet("/enviaCompra")
public class ServletEnviaCompra extends HttpServlet {
    private static final long serialVersionUID = -973490316445738120L;
 
    @EJB
    private EnviaCompra enviaCompra;
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	System.out.println("--- Criando mensagem de teste ---");
        
        Compra compra = new Compra();
        compra.setNome("Luiz");
        compra.setNumeroCartao("8524553");
        
        Item item1 = new Item();
        item1.setNome("Livro");
        item1.setPreco(50);
        item1.setQuantidade(3);
        
        Item item2 = new Item();
        item2.setNome("TV");
        item2.setPreco(2000);
        item2.setQuantidade(3);
        
        Item item3 = new Item();
        item3.setNome("Geladeira");
        item3.setPreco(700);
        item3.setQuantidade(2);
        
        compra.getItens().add(item1);
        compra.getItens().add(item2);
        compra.getItens().add(item3);
        
        enviaCompra.enviarMensagem(compra);
    }
 
}