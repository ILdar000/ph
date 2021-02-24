package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class register {

    boolean zanyat = true;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registerButton;

    @FXML
    private Button cancelRegisterButton;

    @FXML
    private TextField loginLabel;

    @FXML
    private TextField passwordLabel;

    @FXML
    private TextField NameLabel;

    @FXML
    private TextField SurnameLabel;


    @FXML
    void initialize() throws IOException {
        registerButton.setOnAction(event -> {
            try (Scanner scan = new Scanner(new File("C:\\Users\\79534\\Desktop\\untitled3\\src\\sample\\test.txt"))) {
                while (scan.hasNextLine() && zanyat) {
                    String[] logon = scan.nextLine().split(",");
                    if (logon[0].equals(loginLabel.getText())) {
                        zanyat = false;
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
//                +NameLabel.getText()+","+SurnameLabel.getText()
            if (zanyat) {
                String data = loginLabel.getText() + "," + passwordLabel.getText() + "," + NameLabel.getText() + "," + SurnameLabel.getText() + "," + "1" + "\n";
                OutputStream os = null;
                try {
                    //в конструкторе FileOutputStream используем флаг true, который обозначает обновление содержимого файла
                    os = new FileOutputStream(new File("C:\\Users\\79534\\Desktop\\untitled3\\src\\sample\\test.txt"), true);
                    os.write(data.getBytes("UTF8"), 0, data.getBytes("UTF8").length);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                    System.out.println("Создание учетной записи прошла успешно !!!Мои поздравления *****");

                    alert.setTitle("Ты супер!");

                    alert.setHeaderText("Сообщение об успехе");

                    alert.setContentText("Создание учетной записи прошла успешно !!!Мои поздравления *****");

                    alert.showAndWait();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                registerButton.getScene().getWindow().getOnCloseRequest();//прячем наше первое окно Взамен следующей
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/loginFile.fxml")); // позволяет указать расположение  нужного нам файла

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Parent root = loader.getRoot(); //путь к необходимой сцены передали переменной
                Stage stage = new Stage();
                stage.setTitle("Регистрация");
                stage.setScene(new Scene(root));//указываем необходимую нам сцену
                registerButton.getScene().getWindow().hide();
                //stageLogin.close();

                stage.close();//показать и подаждать пока появится сцена

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                System.out.println("Логин занят");

                alert.setTitle("Ошибка");

                alert.setHeaderText("Сообщение об ошибке");

                alert.setContentText("Логин занят");

                alert.showAndWait();


            }

        });


    }
}

