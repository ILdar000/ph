package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class MainMenuController implements Initializable {

    private final ObservableList<Purchases> purchasesData = FXCollections.observableArrayList();
    private final ObservableList<Order> ordersData = FXCollections.observableArrayList();
    private final ObservableList<ProductInfoOrder> ProductInfoOrderData = FXCollections.observableArrayList();

    @FXML
    private Menu Файл;

    @FXML
    private MenuItem Закрыть;

    @FXML
    private Menu Заказы;

    @FXML
    private MenuItem Посмотреть;

    @FXML
    private Menu Товары;

    @FXML
    private Tab catalogtab;

    @FXML
    private TabPane tabPane;

    @FXML
    private TableColumn<Order, String> productId;

    @FXML
    private TableColumn<Order, String> productFIO;

    @FXML
    private Label productIdLabel;

    @FXML
    private Label productAllSumLabel;

    @FXML
    private TableColumn<ProductInfoOrder, String> productName;

    @FXML
    private TableColumn<ProductInfoOrder, String> productCount;

    @FXML
    private TableColumn<ProductInfoOrder, String> productSum;

    @FXML
    private TableView<Order> OrderTabel;

    @FXML
    private TableView<ProductInfoOrder> productTabel;
    //    -----------------ПОЧЕМУ НЕ РАБОТАЕТ ПРИ ДОБАВЛЕНИИ ActionEvent event------------------------------
//    @FXML
//    private void selectCatalogTab(ActionEvent event) {
//        tabPane.getSelectionModel().select(catalogtab);
//    }
//    --------------------------------------------------------------------------------------------
    static String data;
    static String output;
    static String dataorder;

    private void showTableOrderString() {
        ordersData.add(new Order("123", "Хусаенов А.И."));
        ordersData.add(new Order("743", "Алибасов С.С."));
        productId.setCellValueFactory(data -> data.getValue().orderIdProperty());
        productFIO.setCellValueFactory(data -> data.getValue().orderFIOProperty());

        OrderTabel.setItems(ordersData);

        OrderTabel.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showProductDetails(newValue));//Что тут происходит
    }

    private void showProductDetails(Order order) {
        if (order.getorderId().equals("123")) {
            ProductInfoOrderData.add(new ProductInfoOrder("Конфеты", "23", "500.00"));
            ProductInfoOrderData.add(new ProductInfoOrder("Торт", "3", "300.00"));
            productName.setCellValueFactory(data -> data.getValue().productNameProperty());
            productCount.setCellValueFactory(data -> data.getValue().producCountProperty());
            productSum.setCellValueFactory(data -> data.getValue().producSummProperty());

            productTabel.setItems(ProductInfoOrderData);
            System.out.println(order.getorderId() + order.getorderFIO());
            productIdLabel.setText(order.getorderId());
            int resulSumm = parseInt("23") * parseInt("500") + parseInt("3") * parseInt("300");
            String resulSummString = Integer.toString(resulSumm);
            productAllSumLabel.setText(resulSummString);
            productIdLabel.setText(order.getorderId());
            data = "123" + "," + "Конфеты" + "," + "23" + "," + "500.00" + "\n";
            dataorder = order.getorderId() + "," + order.getorderFIO() + ",";
        } else {
            ProductInfoOrderData.add(new ProductInfoOrder("Телевизор", "5", "15000.00"));
            ProductInfoOrderData.add(new ProductInfoOrder("Пульт", "5", "200.00"));
            productName.setCellValueFactory(data -> data.getValue().productNameProperty());
            productCount.setCellValueFactory(data -> data.getValue().producCountProperty());
            productSum.setCellValueFactory(data -> data.getValue().producSummProperty());

            productTabel.setItems(ProductInfoOrderData);

            productIdLabel.setText(order.getorderId());
            int resulSumm = parseInt("5") * parseInt("15000") + parseInt("5") * parseInt("200");
            String resulSummString = Integer.toString(resulSumm);
            productAllSumLabel.setText(resulSummString);
            productIdLabel.setText(order.getorderId());
        }
    }
    @FXML
    private void handleShowOrdersStatistics() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ShowDiagram.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Статистика продаж");
        dialogStage.initModality(Modality.WINDOW_MODAL);

        dialogStage.initOwner(null);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        ShowDiagramController controller = loader.getController();
        controller.setProductData(ordersData);

        dialogStage.show();
    }

    @FXML
    private void addOrder() {
        OutputStream os = null;
        output = combobox1.getSelectionModel().getSelectedItem().toString();
        dataorder = dataorder + output + "\n";
        System.out.println(data);
        try {
            //в конструкторе FileOutputStream используем флаг true, который обозначает обновление содержимого файла
            os = new FileOutputStream(new File("Order.txt"), true);
            os.write(dataorder.getBytes("UTF8"), 0, dataorder.getBytes("UTF8").length);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            System.out.println("Заказ сохранен");

            alert.setTitle("Заказ внесен в базу данных");

            alert.setHeaderText("Сообщение об успехе");

            alert.setContentText("Заказ успешно внесен в базу данных");

            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //в конструкторе FileOutputStream используем флаг true, который обозначает обновление содержимого файла
            os = new FileOutputStream(new File("OrderProduct.txt"), true);
            os.write(data.getBytes("UTF8"), 0, data.getBytes("UTF8").length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private ComboBox<String> combobox1;

    ObservableList<String> list = FXCollections.observableArrayList();

    @FXML
    private void selectCatalogTab() {
        tabPane.getSelectionModel().select(catalogtab);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showTableOrderString();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("catalog.fxml"));
        try {
            catalogtab.setContent(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.add("Доставлено");
        list.add("Оплачено");
        combobox1.setItems(list);
        combobox1.setDisable(false);
    }

    @FXML
    private void ShowCatalogWindow() {
        try {
//          Загружаем fxml-файл и создаем новую сцену для
//          для всплывающего диалогового окна
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditSceneController.class.getResource("catalog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

//    Создаем диалоговое окно Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Catalog");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
// диалоговое окно и ждет, пока пользователь его не закроет
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ShowHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(null);
        alert.setTitle("Помощь");
        alert.setContentText("Программа Учебная. версия 1.0.");

        alert.showAndWait();
    }
}
