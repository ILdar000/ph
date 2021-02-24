package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductInfoOrder {
    private StringProperty productName;
    private StringProperty producCount;
    private StringProperty producSumm;

    public ProductInfoOrder(String productName, String producCount, String producSumm) {
        this.productName = new SimpleStringProperty(productName);
        this.producCount = new SimpleStringProperty(producCount);
        this.producSumm = new SimpleStringProperty(producSumm);
    }

    public ProductInfoOrder() {
    }

    public String getproducSumm() {
        return this.producSumm.get();
    }

    public void setproducSumm(String producSumm) {
        this.producSumm.set(producSumm);
    }

    public StringProperty producSummProperty() {
        return this.producSumm;
    }

    //    ------------------------
    public String getproducCount() {
        return this.producCount.get();
    }

    public void setproducCount(String producCount) {
        this.producCount.set(producCount);
    }

    public StringProperty producCountProperty() {
        return this.producCount;
    }

    //    ------------------------
    public String getproductName() {
        return this.productName.get();
    }

    public void setproductName(String productName) {
        this.productName.set(productName);
    }

    public StringProperty productNameProperty() {
        return this.productName;
    }
    //    ------------------------
}
