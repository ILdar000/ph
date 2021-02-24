package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Product {
    String productName;
    Integer productId;
    Integer productCount;
    Double productSum;
    ImageView productImage;

    public void setProductImage(ImageView productImage) {
        this.productImage = productImage;
    }

    public ImageView getProductImage() {
        return productImage;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public void setProductSum(Double productSum) {
        this.productSum = productSum;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public Double getProductSum() {
        return productSum;
    }

    public Product(Integer productId, String productName, Double productSum, Integer productCount, ImageView productImage) {
        this.productId = productId;
        this.productName = productName;
        this.productSum = productSum;
        this.productCount = productCount;
        this.productImage = productImage;
    }

    public static void addProduct(Product product) {

    }

    public Product() {

    }
}

