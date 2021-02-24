package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {
    private StringProperty orderId;
    private StringProperty orderFIO;

    public Order() {
    }

    public Order(String orderId, String orderFIO) {
        this.orderId = new SimpleStringProperty(orderId);
        this.orderFIO = new SimpleStringProperty(orderFIO);
    }

    public String getorderId() {
        return this.orderId.get();
    }

    public void setorderId(String orderId) {
        this.orderId.set(orderId);
    }

    public StringProperty orderIdProperty() {
        return this.orderId;
    }

    //    ----------------------
    public String getorderFIO() {
        return this.orderFIO.get();
    }

    public void setorderFIO(String orderFIO) {
        this.orderFIO.set(orderFIO);
    }

    public StringProperty orderFIOProperty() {
        return this.orderFIO;
    }


}
