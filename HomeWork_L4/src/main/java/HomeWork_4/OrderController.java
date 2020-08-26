package HomeWork_4;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class OrderController implements Serializable {

    @Inject
    private OrderRepository orderRepository;
    private Ordering ordering;

    public Ordering getOrdering () {
        return ordering;
    }

    public void setOrdering (Ordering ordering) {
        this.ordering = ordering;
    }

    public List <Ordering> getAllOrder() {
        return orderRepository.findAll();
    }

    public String editOrder(Ordering ordering) {
        this.ordering = ordering;
        return "/admin_order.xhtml?faces-redirect=true";
    }

    public void deleteOrder(Ordering ordering) {
        orderRepository.deleteOrd (ordering.getOrder_id ());
    }

    public String createOrder() {
        this.ordering = new Ordering ();
        return "/admin_order.xhtml?faces-redirect=true";
    }

    public String saveOrder() {
        if (ordering.getOrder_id () != null) {
            orderRepository.updateOrd (ordering);
        } else {
            orderRepository.insertOrd (ordering);
        }
        return "/order.xhtml?faces-redirect=true";
    }
}
