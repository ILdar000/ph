package sample;

import com.sun.prism.impl.shape.MaskData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.LoadException;

import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Catalog implements Initializable {

    private final ObservableList<Product> productData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane productTabel;

    @FXML
    private TableView<Product> catalogTabel;

    @FXML
    private TableColumn<Product, String> productId;

    @FXML
    private TableColumn<Product, String> productSum;

    @FXML
    private TableColumn<Product, String> productName;

    @FXML
    private TableColumn<Product, String> productCount;

    @FXML
    private TableColumn<Product, ImageView> productImage;

    @FXML
    private Label productIdLabel;

    @FXML
    private Label productNameLabel;

    @FXML
    private Label productCountLabel;

    @FXML
    private Label productSumLabel;


    @FXML
    private void handleDeleteProduc() {
        int selectedIndex = catalogTabel.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            catalogTabel.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран товар");
            alert.setContentText("Выберите товар в таблице");

            alert.showAndWait();
        }
    }


    @FXML
    private void handleNewProduct() throws IOException {
        Product tempProduct = new Product();
        boolean okClicked = this.showProdoctEditDialog(tempProduct);
        if (okClicked) {
            productData.add(tempProduct);
        }
    }

    public boolean showProdoctEditDialog(Product product) {
        try {
//          Загружаем fxml-файл и создаем новую сцену для
//          для всплывающего диалогового окна
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditSceneController.class.getResource("EditSceneController.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

//    Создаем диалоговое окно Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Product");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
//    Передаём адресата в контроллер.
            EditSceneController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(product);
// диалоговое окно и ждет, пока пользователь его не закроет
            dialogStage.showAndWait();
            return controller.isOkKlicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @FXML
    private void handleEditProduct() {
        Product selectedProduct = catalogTabel.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            boolean okClicked = showProdoctEditDialog(selectedProduct);
            if (okClicked) {
                showProductDetails(selectedProduct);
                int selectedIndex = catalogTabel.getSelectionModel().getSelectedIndex();
                productData.set(selectedIndex, selectedProduct);
            }

        } else {
//        Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Ничего не набрано");
            alert.setHeaderText("Нет продукта");
            alert.setContentText("Выберите продукт в таблице");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String put = "ruki2.png";
        Image img = new Image(getClass().getResource(put).toExternalForm());
        ImageView photo = new ImageView(img);
        productData.add(new Product(1, "Конфеты", 500.00, 23, photo));
        productData.add(new Product(2, "Торт", 300.00, 3, photo));
        productData.add(new Product(3, "Телевизор", 15000.00, 5, photo));
        productData.add(new Product(4, "Пульт", 200.00, 5, photo));
        productData.add(new Product(5, "Компьтер", 150000.00, 2, photo));
        productId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productSum.setCellValueFactory(new PropertyValueFactory<>("productSum"));
        productCount.setCellValueFactory(new PropertyValueFactory<>("productCount"));
        productImage.setCellValueFactory(new PropertyValueFactory<>("productImage"));
        catalogTabel.setItems(productData);

        catalogTabel.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showProductDetails(newValue));//Что тут происходит

    }

    private void showProductDetails(Product product) {
        if (product != null) {
            productIdLabel.setText(product.getProductId().toString());
            productNameLabel.setText(product.getProductName());
            productSumLabel.setText(product.getProductSum().toString());//Зачем toString()
            productCountLabel.setText(product.getProductCount().toString());
        } else {
            productIdLabel.setText("");
            productNameLabel.setText("");
            productSumLabel.setText("");
            productCountLabel.setText("");
        }
    }


}


