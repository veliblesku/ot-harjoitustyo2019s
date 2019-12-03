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
import javafx.application.HostServices;
import java.sql.*;

import budjetointisovellus.dao.DBUserDao;
import static javafx.application.Application.launch;

import budjetointisovellus.budjetointisovellus.domain.User;
import budjetointisovellus.budjetointisovellus.domain.Income;
import budjetointisovellus.budjetointisovellus.domain.Expenses;
import budjetointisovellus.budjetointisovellus.domain.Budget;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;



/**
 *
 * @author blesku
 */

public class BudgetingUI extends Application {

    //Income income = new Income(2000);
    private Label menuLabel = new Label();
    
    private Scene budgetingScene;
    private Scene newUserScene;
    private Scene loginScene;
    private Scene loggedInScene;
    private ConfigurableApplicationContext context;

    @Override
    public void init() throws SQLException {
        ApplicationContextInitializer<GenericApplicationContext> initializer =
                ac->{
                  ac.registerBean(Application.class, () -> BudgetingUI.this);
                  ac.registerBean(Parameters.class, this::getParameters);
                  ac.registerBean(HostServices.class, this::getHostServices);
                };
        this.context = new SpringApplicationBuilder()
                .sources(budjetointisovellus.budjetointisovellus.domain.MainForTesting.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        /// Login Scene
        
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

            if (username.equals("as")) {
                loginMessage.setText("");
                System.out.println("haku onnistui");
                primaryStage.setScene(budgetingScene);
                usernameInput.setText("Tervetuloa");
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
        
        
        ///// New User Scene__ __ __ 

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
        Label newNameLabel = new Label("password");
        newNameLabel.setPrefWidth(100);
        newNamePane.getChildren().addAll(newNameLabel, newNameInput);

        Label userCreationMessage = new Label();

        Button createNewUserButton = new Button("create");
        createNewUserButton.setPadding(new Insets(10));

        newUserPanel.getChildren().addAll(userCreationMessage, newUsernamePanel, newNamePane, createNewUserButton);

        newUserScene = new Scene(newUserPanel, 300, 250);

        ///////////////  Budgeting Scene
        
        VBox newUserPanelsss = new VBox(10);

        HBox newUsernamePanelvvv = new HBox(10);
        newUsernamePanel.setPadding(new Insets(10));
        TextField budjetinSyotto = new TextField();
        Label budjetinSyottoLabel = new Label("income");
        budjetinSyottoLabel.setPrefWidth(100);
        newUsernamePanelvvv.getChildren().addAll(budjetinSyottoLabel, budjetinSyotto);

        HBox newNamePaneggg = new HBox(10);
        newNamePaneggg.setPadding(new Insets(10));
        TextField newNameInputhhh = new TextField();
        Label newNameLabelhhh = new Label("expenses");
        newNameLabelhhh.setPrefWidth(100);
        newNamePaneggg.getChildren().addAll(newNameLabelhhh, newNameInputhhh);

        Label loginMEssage = new Label();

        Button calculatebudgetButton = new Button("calculate");
        calculatebudgetButton.setPadding(new Insets(10));

        newUserPanelsss.getChildren().addAll(loginMEssage, newUsernamePanelvvv, calculatebudgetButton);

        budgetingScene = new Scene(newUserPanelsss, 500, 600);
        
       ///////////////
       
        primaryStage.setTitle("Budjetointisovellus");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        SpringApplication.run(BudgetingUI.class, args);
//    }

}
