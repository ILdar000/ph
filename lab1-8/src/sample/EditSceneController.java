package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditSceneController implements Initializable {


    @FXML
    private TextField productIdField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productSumField;

    @FXML
    private TextField productCountField;

    private Stage dialogStage;
    private Product product;
    private boolean okKlicked = false;

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            product.setProductId(Integer.parseInt(productIdField.getText()));
            product.setProductName(productNameField.getText());
            product.setProductSum(Double.parseDouble(productSumField.getText()));
            product.setProductCount(Integer.parseInt(productCountField.getText()));

            Product.addProduct(product);
            okKlicked = true;
            dialogStage.close();
        }
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setProduct(Product product) {
        this.product = product;

        productIdField.setText(product.getProductId() != null ? product.getProductId().toString() : "");
        productNameField.setText(product.getProductName() != null ? product.getProductName() : "");
        productSumField.setText(product.getProductSum() != null ? product.getProductSum().toString() : "");
        productCountField.setText(product.getProductCount() != null ? product.getProductCount().toString() : "");
    }

    public boolean isOkKlicked() {
        return okKlicked;
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    private boolean isInputValid() {
        String errorMessage = "";
        if (productIdField.getText() == null || productIdField.getText().length() == 0) {
            errorMessage += "Нет доступного артикула\n";
        }
        if (productNameField.getText() == null || productNameField.getText().length() == 0) {
            errorMessage += "Нет доступного наименования товара\n";
        }
        if (productSumField.getText() == null || productSumField.getText().length() == 0) {
            errorMessage += "Нет доступной сувары\n";
        }
        if (productCountField.getText() == null || productCountField.getText().length() == 0) {
            errorMessage += "Нет количества\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
// Показывает сообщение об ошибке
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Некорректные поля");
            alert.setHeaderText("Внесите корректную информацию");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}