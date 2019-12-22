/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import budjetointisovellus.domain.Expense;
import budjetointisovellus.domain.Income;
import budjetointisovellus.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author blesku
 */
public class UserTest {

    User user;
    List <Income> incomes = new ArrayList<>();
    List <Expense> expenses = new ArrayList<>();
    List<Income> incomesExpected = new ArrayList<>();
    List<Expense> expensesExpected = new ArrayList<>();
    List<Expense> expensesExpected1 = new ArrayList<>();
    List<Income> incomesExpected1 = new ArrayList<>();


    Expense expense;
    Income income;
    

    @Before
    public void setUp() {
        this.user = new User("Jani", "salasana", incomes, expenses);
        expense = new Expense("kalja", 10.6, user);
        income = new Income("pullot", 2.6, user);
        incomesExpected1.add(income);
        expensesExpected1.add(expense);
        

    }

    @Test
    public void userOnAlustettuOikein() {
        assertEquals("Jani", user.getName());
        assertEquals("salasana", user.getPassword());
        assertEquals(incomesExpected, user.getExpenses());
        assertEquals(expensesExpected, user.getIncomes());
    }
    
    
    @Test
    public void userAddListToimiiOikein() {
        user.getExpenses().add(expense);
        user.getIncomes().add(income);
        assertEquals(incomesExpected1, user.getIncomes());
        assertEquals(expensesExpected1, user.getExpenses());
    }
}
