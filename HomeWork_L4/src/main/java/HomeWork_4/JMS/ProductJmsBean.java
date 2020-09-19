package HomeWork_4.JMS;

import HomeWork_4.DAO.ProductDAO;
import HomeWork_4.DAO.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/productQueue"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "action = 'create'")
        })
public class ProductJmsBean implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(ProductJmsBean.class);

    @EJB
    private ProductService productService;

    @Override
    public void onMessage(Message message) {
        logger.info("New JMS message!");
        if(message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                ProductDAO productDAO = (ProductDAO) objectMessage.getObject();
                productService.insert(productDAO);
            } catch(JMSException e) {
                logger.error("", e);
            }
        }
    }
}
