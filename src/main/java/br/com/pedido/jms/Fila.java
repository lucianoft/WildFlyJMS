package br.com.pedido.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.com.pedido.bo.ProcessaCompra;
import br.com.pedido.domain.Compra;
  
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/test") })
public class Fila implements MessageListener {
 
	@EJB
    private ProcessaCompra processaCompra;
 
    public void onMessage(Message message) {
        ObjectMessage objMsg = (ObjectMessage) message;
        try {
            System.out.println("--- Recebendo mensagem --- ");
            
            Compra compra = (Compra) objMsg.getObject();
            processaCompra.fecharCompra(compra);
         } catch (JMSException e) {
            e.printStackTrace();
        }
    }
 
}
