/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import budjetointisovellus.budjetointisovellus.domain.Budget;
import budjetointisovellus.budjetointisovellus.domain.Expenses;
import budjetointisovellus.budjetointisovellus.domain.Income;
import budjetointisovellus.budjetointisovellus.domain.User;
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
    Income income = new Income();
    Expenses expenses = new Expenses();
    Budget budget;

    @Before
    public void setUp() {
        this.income.setTotalIncome(12123.4);
        expenses.setTotalExpenses(11341.3);
        this.user = new User(1, "Jani", new Budget(income, expenses));
    }

    @Test
    public void budjettiOnAlustettuOikein() {
        assertEquals(12123.4, user.getBudget().getTotalIncome(), 0.00001);
        assertEquals(11341.3, user.getBudget().getTotalExpenses(), 0.00001);
    }
}
