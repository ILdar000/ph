package sample;

public class Purchases extends Order {
    private String Id;
    private String login;
    private String date;
    private String products;

    public Purchases() {
    }

    public Purchases(String id, String login, String date, String products) {
        Id = id;
        this.login = login;
        this.date = date;
        this.products = products;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}
