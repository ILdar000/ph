package sample;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowDiagramController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart batChart;

    @FXML
    private CategoryAxis xAxis;

    final private ObservableList productNames = FXCollections.observableArrayList();


//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        String[] products = {"Стол", "Кресло", "Диван", "Стул", "Тумбочка"};
//
//        productNames.addAll(Arrays.asList(products));
//
//        xAxis.setCategories(productNames);
//    }
@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    try (Scanner scan = new Scanner(new File("OrderProduct.txt"))) {
        while (scan.hasNextLine()){
            String[] logon = scan.nextLine().split(",");
            productNames.addAll(logon[1]);
        }
    }catch (IOException ex) {
        ex.printStackTrace();
    }
    xAxis.setCategories(productNames);
}

//    public void setProductData(List<Order> orders) {
//        int[] productCounter = new int[productNames.size()];
//        int[] productCounter1 = {10,14,23,14,31};
//        for (Order o : orders) {
//        }
//        XYChart.Series series = new XYChart.Series<>();
//
//
//        for (int i = 0; i < productCounter.length; i++) {
//            series.getData().add(new XYChart.Data<>(productNames.get(i),productCounter1[i]));
//        }
//
//        batChart.getData().add(series);
//    }
public void setProductData(List<Order> orders) {
    ArrayList<Integer> productCounter1 = new ArrayList<>();
    int[] productCounter = new int[productNames.size()];
    try (Scanner scan = new Scanner(new File("OrderProduct.txt"))) {
        while (scan.hasNextLine()){
            String[] logon = scan.nextLine().split(",");
                productCounter1.add(Integer.parseInt(logon[2]));
            }
        }catch (IOException ex) {
        ex.printStackTrace();
    }
    XYChart.Series series = new XYChart.Series<>();


    for (int i = 0; i < productCounter.length; i++) {
        series.getData().add(new XYChart.Data<>(productNames.get(i),productCounter1.get(i)));
    }

    batChart.getData().add(series);
}
}

