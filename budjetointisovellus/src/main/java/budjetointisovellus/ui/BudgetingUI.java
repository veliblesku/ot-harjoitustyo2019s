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
import static javafx.application.Application.launch;

import budjetointisovellus.domain.User;
import budjetointisovellus.domain.Income;
import budjetointisovellus.domain.Expense;
import budjetointisovellus.domain.ExpenseRepository;
import budjetointisovellus.domain.IncomeRepository;
import budjetointisovellus.domain.UserRepository;
import budjetointisovellus.domain.UserService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;

/**
 *
 * @author blesku
 */
@Controller
public class BudgetingUI extends Application {

    //Income income = new Income(2000);
    private Label menuLabel = new Label();

    private Scene budgetingScene;
    private Scene newUserScene;
    private Scene loginScene;
    private Scene loggedInScene;
    private ConfigurableApplicationContext context;
    private User user;
    private List<User> users = new ArrayList<>();
    private ObservableList<String> budgetExpenses = FXCollections.observableArrayList();
    private ObservableList<String> budgetIncomes = FXCollections.observableArrayList();

    private Long id;
    private List<Expense> expenses;
    private boolean loggedIn = false;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public void init() throws SQLException {
        ApplicationContextInitializer<GenericApplicationContext> initializer
                = ac -> {
                    ac.registerBean(Application.class, () -> BudgetingUI.this);
                    ac.registerBean(Parameters.class, this::getParameters);
                    ac.registerBean(HostServices.class, this::getHostServices);
                };
        this.context = new SpringApplicationBuilder()
                .sources(budjetointisovellus.domain.Main.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        /// Login Scene
        HBox loginPane = new HBox(10);
        VBox inputPane = new VBox(10);
        loginPane.setPadding(new Insets(10));
        Label loginLabel = new Label("username");
        TextField usernameInput = new TextField();
        Label pwLabel = new Label("password");
        TextField passwordInput = new TextField();

        Label loginMessage = new Label();

        Button loginButton = new Button("login");
        Button createButton = new Button("create new user");
        inputPane.getChildren().addAll(loginLabel, usernameInput, pwLabel, passwordInput, loginButton, createButton);

        loginButton.setOnAction((ActionEvent e) -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();

            //id = userRepository.findByName(username).toString();
            System.out.println("id == " + id);
            user = userService.findUserByUsername(username);

            //System.out.println("expenses " + expenses.toString());
            //System.out.println("user  " + userRepository.findByName(username).toString());
            if (user.getPassword().equals(password) && user.getName().equals(username)) {
                loginMessage.setText("");
                System.out.println("haku onnistui");
                usernameInput.setText("Tervetuloa");
                //user = userRepository.findByName(username);

                //System.out.println("user   " + user.toString());
                //this.users = userRepository.findAll();
                //System.out.println("user after login  =   " + user.toString());
                //budget = FXCollections.observableArrayList();
                //System.out.println(user.getExpenses().toString());
                //budget.add(user.getIncomes().iterator().hasNext());
                //System.out.println(budget.toString());
                //System.out.println("user to string loggin =   " + user.getExpenses().toString());
                this.expenses = userService.findAllExpenses();

                System.out.println("contains  " + expenses.contains(user));
                System.out.println("expenses size =" + expenses.size());
                int i = 0;
                List<Expense> usersExpense = new ArrayList<>();
                List<Income> usersIncome = new ArrayList<>();
                usersExpense = user.getExpenses();
                usersIncome = user.getIncomes();
                System.out.println("userexpense   " + usersExpense.size());
                //System.out.println(user.toString());
//                while (i < expenses.size()) {
//                    System.out.println(expenses.get(i).getName() + expenses.get(i).getUser().getName());
//                    i++;
//                }

                while (i < user.getExpenses().size()) {
                    budgetExpenses.add(usersExpense.get(i).getName() + ", " + String.valueOf(usersExpense.get(i).getAmount()));
                    System.out.println("budgetExpenses add???   ==  " + usersExpense.get(i).getName() + ", " + String.valueOf(usersExpense.get(i).getAmount()));
                    i++;
                }

                int j = 0;
                while (j < user.getIncomes().size()) {
                    budgetIncomes.add(usersIncome.get(i).getName() + ", " + String.valueOf(usersIncome.get(i).getAmount()));
                    System.out.println("budgetExpenses add???   ==  " + usersIncome.get(i).getName() + ", " + String.valueOf(usersIncome.get(i).getAmount()));
                    j++;
                }

                System.out.println("user expensessize = " + user.getExpenses().size());

                primaryStage.setScene(budgetingScene);
                menuLabel.setText(username + " logged in...");
                System.out.println("kirjaudutaan sisään");

            } else {
                loginMessage.setText("user does not exist");
                loginMessage.setTextFill(Color.RED);
            }
        });

        createButton.setOnAction(e -> {
            usernameInput.setText("");
            primaryStage.setScene(newUserScene);

        });

        loginPane.getChildren().addAll(loginMessage, inputPane, loginButton, createButton);

        loginScene = new Scene(loginPane, 400, 200);

        ///// New User Scene__ __ __ 
        VBox newUserPanel = new VBox(10);

        HBox newUsernamePanel = new HBox(10);
        newUsernamePanel.setPadding(new Insets(10));
        TextField newUsernameInput = new TextField();
        Label newUsernameLabel = new Label("username");
        newUsernameLabel.setPrefWidth(100);
        newUsernamePanel.getChildren().addAll(newUsernameLabel, newUsernameInput);

        HBox newPwPane = new HBox(10);
        newPwPane.setPadding(new Insets(10));
        TextField newPwInput = new TextField();
        Label newPwLabel = new Label("password");
        newPwLabel.setPrefWidth(100);
        newPwPane.getChildren().addAll(newPwLabel, newPwInput);

        Label userCreationMessage = new Label();

        Button createNewUserButton = new Button("create");

        createNewUserButton.setPadding(new Insets(10));

        createNewUserButton.setOnAction(e -> {

            String username = newUsernameInput.getText();
            String pw = newPwInput.getText();

            System.out.println("username = " + username);
            System.out.println("pw = " + pw);

            try {
                if (userService.findAllUsers().contains(username)) {
                    userCreationMessage.setText("Username taken, choose another.");
                } else {
                    //User user = new User(username, pw, new ArrayList(), new ArrayList());
                    User user = new User(username, pw, new ArrayList<>(), new ArrayList<>());

                    userService.createUser(user);
                    loginMessage.setText("New user has been created!");
                    //System.out.println("USER AFTER CREATING = " + user.toString());
                    primaryStage.setScene(loginScene);
                }
            } catch (Exception es) {
                System.out.println(es);
            }

        });

        newUserPanel.getChildren().addAll(userCreationMessage, newUsernamePanel, newPwPane, createNewUserButton);

        newUserScene = new Scene(newUserPanel, 400, 200);

        ///////////////  Budgeting Scene
        System.out.println("Hei, ");

        //System.out.println("users budget = " + user.toString());
        VBox incomeAndExpensesPanel = new VBox(10);

        HBox incomeAndExpensesAddPanel = new HBox(60);

        VBox incomePanel = new VBox(10);

        newUsernamePanel.setPadding(new Insets(10));
        Label incomeNameLabel = new Label("income name");
        incomeNameLabel.setPrefWidth(60);
        TextField incomeNameTextField = new TextField();
        Label incomeAmountLabel = new Label("income");
        incomeAmountLabel.setPrefWidth(60);
        TextField incomeAmountTextField = new TextField();
        Button addIncomeButton = new Button("Add");
        addIncomeButton.setPadding(new Insets(10));

        incomePanel.getChildren().addAll(incomeNameLabel, incomeNameTextField, incomeAmountLabel, incomeAmountTextField, addIncomeButton);

        //incomePanel.getChildren().addAll(incomeLabel, incomeTextField);
        //HBox expensesPanel = new HBox(10);
        VBox expensesPanel = new VBox(10);
        expensesPanel.setPadding(new Insets(10));
        TextField expensesNameTextField = new TextField();
        Label expensesNameLabel = new Label("expenses name");
        expensesNameLabel.setPrefWidth(60);
        TextField expensesAmountTextField = new TextField();
        Label expensesAmountLabel = new Label("expenses amount");
        expensesAmountLabel.setPrefWidth(60);
        Button addExpensesButton = new Button("Add");
        addExpensesButton.setPadding(new Insets(10));

        // add expenses button action controller
        addExpensesButton.setOnAction(e -> {
            String name = expensesNameTextField.getText();
            Double amount = Double.parseDouble(expensesAmountTextField.getText());
            Expense expense = new Expense();
            List<Expense> list = new ArrayList<>();

            //list = expenseRepository.findAll();
            //System.out.println("user = " + user.toString());
            //Hibernate.intialize(userRepository.getOne(user.getId()));
            expense.setName(name);
            expense.setAmount(amount);
            expense.setUser(user);
            list.add(expense);
            user.setExpenses(list);
            budgetExpenses.add(name + ", " + String.valueOf(amount));
            //list.removeAll(user1.getExpenses());
            //user1.setExpenses(list);

            userService.editUser(user);

            //userService.createExpense(expense);
        });
        // add income button
        addIncomeButton.setOnAction(e -> {
            String name = incomeNameTextField.getText();
            Double amount = Double.parseDouble(incomeAmountTextField.getText());
            Income income = new Income();
            List<Income> list = new ArrayList<>();
            income.setName(name);
            income.setAmount(amount);
            income.setUser(user);
            list.add(income);
            user.setIncomes(list);
            budgetIncomes.add(name + ", " + String.valueOf(amount));

            //list.removeAll(user1.getExpenses());
            //user1.setExpenses(list);
            userService.editUser(user);

            //userService.createExpense(expense);
        });

        expensesPanel.getChildren().addAll(expensesNameLabel, expensesNameTextField, expensesAmountLabel, expensesAmountTextField, addExpensesButton);
        Label loginMEssage = new Label();

        incomeAndExpensesAddPanel.getChildren().addAll(incomePanel, expensesPanel);
        HBox listPanel = new HBox();
        ListView expensesView = new ListView(budgetExpenses);
        ListView incomesView = new ListView(budgetIncomes);
        listPanel.getChildren().addAll(incomesView, expensesView);

        // list panel
//        int size = user.getExpenses().size();
//        int i = 0
//        while (i < size) {
//            listView.getItems().add(user.getExpenses().get(i).getAmount() + ", " + user.getExpenses().get(i).getName());
//            i++;
//        }
        incomeAndExpensesPanel.getChildren().addAll(loginMEssage, incomeAndExpensesAddPanel, listPanel);

        budgetingScene = new Scene(incomeAndExpensesPanel, 600, 600);

        ///////////////
        primaryStage.setTitle("Budjetointisovellus");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

}
