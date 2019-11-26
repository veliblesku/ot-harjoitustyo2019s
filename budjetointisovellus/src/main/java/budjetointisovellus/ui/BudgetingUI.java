/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.sql.*;

import budjetointisovellus.dao.DBUserDao;
import static javafx.application.Application.launch;

/**
 *
 * @author blesku
 */
public class BudgetingUI extends Application {

    private Label menuLabel = new Label();

    private Scene budgetingScene;
    private Scene newUserScene;
    private Scene loginScene;

    @Override
    public void init() throws SQLException {

        DBUserDao userDao = new DBUserDao();
    }

    @Override
    public void start(Stage primaryStage) {

        VBox loginPane = new VBox(10);
        HBox inputPane = new HBox(10);
        loginPane.setPadding(new Insets(10));
        Label loginLabel = new Label("username");
        TextField usernameInput = new TextField();

        Label loginMessage = new Label();

        Button loginButton = new Button("login");
        Button createButton = new Button("create new user");
        inputPane.getChildren().addAll(loginLabel, usernameInput, loginButton, createButton);

        loginButton.setOnAction(e -> {
            String username = usernameInput.getText();
            System.out.println("Username on " + username);
            menuLabel.setText(username + " logged in...");

            if (username == "jani") {
                loginMessage.setText("");
                System.out.println("haku onnistui");
                primaryStage.setScene(budgetingScene);
                usernameInput.setText("");
            } else {
                loginMessage.setText("use does not exist");
                loginMessage.setTextFill(Color.RED);
            }
        });

        createButton.setOnAction(e -> {
            usernameInput.setText("");
            primaryStage.setScene(newUserScene);
//            try {
//            } catch (SQLException s){
//            }

        });

        loginPane.getChildren().addAll(loginMessage, inputPane, loginButton, createButton);

        loginScene = new Scene(loginPane, 300, 250);

        VBox newUserPanel = new VBox(10);

        HBox newUsernamePanel = new HBox(10);
        newUsernamePanel.setPadding(new Insets(10));
        TextField newUsernameInput = new TextField();
        Label newUsernameLabel = new Label("username");
        newUsernameLabel.setPrefWidth(100);
        newUsernamePanel.getChildren().addAll(newUsernameLabel, newUsernameInput);

        HBox newNamePane = new HBox(10);
        newNamePane.setPadding(new Insets(10));
        TextField newNameInput = new TextField();
        Label newNameLabel = new Label("name");
        newNameLabel.setPrefWidth(100);
        newNamePane.getChildren().addAll(newNameLabel, newNameInput);

        Label userCreationMessage = new Label();

        Button createNewUserButton = new Button("create");
        createNewUserButton.setPadding(new Insets(10));

        newUserPanel.getChildren().addAll(userCreationMessage, newUsernamePanel, newNamePane, createNewUserButton);

        newUserScene = new Scene(newUserPanel, 300, 250);

        primaryStage.setTitle("Budjetointisovellus");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
