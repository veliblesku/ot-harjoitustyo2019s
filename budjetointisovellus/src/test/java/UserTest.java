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
        this.income.setInvestments(1000.0);
        this.income.setPayroll(2600.0);
        this.income.setSavings(12000);
        this.income.setSellingStuff(20);
        expenses.setBills(600);
        expenses.setFood(200);
        expenses.setEntertainment(200);
        expenses.setLoan(20000);
        this.user = new User(1, "Jani",new Budget(income, expenses));

    }

    @Test
    public void budjettiOnAlustettuOikein() {
        assertEquals(15620.0, user.getBudget().getTotalIncome(), 0.00001);
        assertEquals(15620.0, user.getBudget().getTotalIncome(), 0.00001);
        assertEquals(15620.0, user.getBudget().getTotalIncome(), 0.00001);
        assertEquals(15620.0, user.getBudget().getTotalIncome(), 0.00001);

    }
}
