package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    // add products to the items list
    public void addItem(OrderItem item){
        items.add(item);
    }

    // remove products of the items list
    public void removeItem(OrderItem item){
        items.remove(item);
    }

    // total of the order
    public Double total(){
        double sum =0;
        for (OrderItem o : items){
            sum += o.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER MOMENT: ");
        sb.append(sdf.format(moment) +"\n");
        sb.append("ORDER STATUS: ");
        sb.append(status +"\n");
        sb.append("CLIENT: ");
        sb.append(client +"\n");
        sb.append("ORDER ITEMS: \n");
        for(OrderItem item : items){
            sb.append(item +"\n");
        }
        sb.append("TOTAL PRICE: ");
        sb.append(String.format("%.2f", total()));

        return sb.toString();
    }
}
