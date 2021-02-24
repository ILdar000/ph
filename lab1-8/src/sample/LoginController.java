package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class LoginController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink register;

    @FXML
    private Button lodinButton;

    @FXML
    private TextField loginText;

    @FXML
    private TextField passwordText;

    @FXML
    private Button lodinCanselButton;
    public static String Name;
    public static String Surname;

//    @FXML
//    void initialize() {
//        lodinCanselButton.setOnAction(event -> {
//            loginText.clear();
//            passwordText.clear();
//        });
//
//
//        register.setOnAction(event -> {
//            register.getScene().getWindow().getOnCloseRequest();//прячем наше первое окно Взамен следующей
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/sample/registerFile.fxml")); // позволяет указать расположение  нужного нам файла
//
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Parent root = loader.getRoot(); //путь к необходимой сцены передали переменной
//            Stage stage = new Stage();
//            stage.setTitle("Регистрация");
//            stage.setScene(new Scene(root));//указываем необходимую нам сцену
//            register.getScene().getWindow().hide();
////            stageLogin.close();
//
//            stage.show();//показать и подаждать пока появится сцена
//
//        });
//
//        lodinButton.setOnAction(event -> {
//            boolean zanyat = true;
//            boolean nePravilno = false;
//            try (Scanner scan = new Scanner(new File("C:\Users\79534\Desktop\untitled3\src\sample\test.txt"))) {
//                while (scan.hasNextLine() && zanyat) {
//                    String[] logon = scan.nextLine().split(",");
//                    if (logon[0].equals(loginText.getText()) && logon[1].equals(passwordText.getText())) {
//                        zanyat = false;
//                        nePravilno = false;
//                        UserData userData = new UserData();
//                        userData.setSurname(logon[3]);
//                        userData.setName(logon[2]);
//                        LKController lkController = new LKController();
//                        lkController.SetInfo(logon[2],logon[3]);
//                    } else {
//                        nePravilno = true;
//                    }
//
//                }
//
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//
//
//            if (nePravilno) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                System.out.println("Пароль или логин неверно введены");
//
//                alert.setTitle("Ошибка");
//
//                alert.setHeaderText("Сообщение об ошибке");
//
//                alert.setContentText("Проверьте введенные логин и пароль");
//
//                alert.showAndWait();
//            } else {
//
//                Stage stage = new Stage();
//                stage.setTitle("LK");
//                Parent root = null;
//                try {
//                    root = FXMLLoader.load(getClass().getResource("/sample/LK.fxml"));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//
//                Stage stage1 = (Stage) lodinButton.getScene().getWindow();
//                stage1.close();
////                UserData userData = new UserData();
////                FXMLLoader loader = new FXMLLoader();
////                Stage dialogStage = new Stage();
////                LKController controller = loader.getController();
////                controller.setLK(dialogStage);
////                controller.setUserData(userData);
//
//
//
////                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
////                System.out.println("Вход в учетную запись прошла успешно !!!Мои поздравления *****");
////
////                alert1.setTitle("Ты супер!");
////
////                alert1.setHeaderText("Сообщение об успехе");
////
////                alert1.setContentText("Вход в учетную запись прошла успешно !!!Мои поздравления *****");
////
////                alert1.showAndWait();
//
//
//            }
//        });
//    }

    private String Dostup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lodinCanselButton.setOnAction(event -> {
            loginText.clear();
            passwordText.clear();
        });


        register.setOnAction(event -> {
            register.getScene().getWindow().getOnCloseRequest();//прячем наше первое окно Взамен следующей
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/registerFile.fxml")); // позволяет указать расположение  нужного нам файла

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot(); //путь к необходимой сцены передали переменной
            Stage stage = new Stage();
            stage.setTitle("Регистрация");
            stage.setScene(new Scene(root));//указываем необходимую нам сцену
            register.getScene().getWindow().hide();
//            stageLogin.close();

            stage.show();//показать и подаждать пока появится сцена

        });

        lodinButton.setOnAction(event -> {
            boolean zanyat = true;
            boolean nePravilno = false;
            try (Scanner scan = new Scanner(new File("C:\\Users\\79534\\Desktop\\untitled3\\src\\sample\\test.txt"))) {
                while (scan.hasNextLine() && zanyat) {
                    String[] logon = scan.nextLine().split(",");
                    if (logon[0].equals(loginText.getText()) && logon[1].equals(passwordText.getText())) {
                        zanyat = false;
                        nePravilno = false;
                        UserData userData = new UserData();
                        userData.setSurname(logon[3]);
                        userData.setName(logon[2]);
                        Surname = logon[3];
                        Name = logon[2];
                        Dostup = logon[4];
                        System.out.println(Dostup);
                    } else {
                        nePravilno = true;
                    }

                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }


            if (nePravilno) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                System.out.println("Пароль или логин неверно введены");

                alert.setTitle("Ошибка");

                alert.setHeaderText("Сообщение об ошибке");

                alert.setContentText("Проверьте введенные логин и пароль");

                alert.showAndWait();
            } else {
                System.out.println(Dostup);
                if (Dostup.equals("1")) {
                    Stage stage = new Stage();

                    stage.setTitle("LK");
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/sample/MainMenu.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    Stage stage = new Stage();

                    stage.setTitle("LK");
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/sample/catalog.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

                Stage stage1 = (Stage) lodinButton.getScene().getWindow();
                stage1.close();
//                UserData userData = new UserData();
//                FXMLLoader loader = new FXMLLoader();
//                Stage dialogStage = new Stage();
//                LKController controller = loader.getController();
//                controller.setLK(dialogStage);
//                controller.setUserData(userData);


//                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//                System.out.println("Вход в учетную запись прошла успешно !!!Мои поздравления *****");
//
//                alert1.setTitle("Ты супер!");
//
//                alert1.setHeaderText("Сообщение об успехе");
//
//                alert1.setContentText("Вход в учетную запись прошла успешно !!!Мои поздравления *****");
//
//                alert1.showAndWait();


            }
        });
    }
}

