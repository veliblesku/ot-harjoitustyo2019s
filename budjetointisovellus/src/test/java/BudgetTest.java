/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import budjetointisovellus.budjetointisovellus.domain.Budget;
import budjetointisovellus.budjetointisovellus.domain.User;
import budjetointisovellus.budjetointisovellus.domain.Income;
import budjetointisovellus.budjetointisovellus.domain.Expenses;

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
public class BudgetTest {

    Budget budget;
    User user;

    @Before
    public void setUp() {
        budget = new Budget(new Income(3000),new Expenses(2000));
    }

    @Test
    public void budjettiOnAlustettuOikein() {
        assertEquals(3000.0, budget.getTotalIncome(), 0.00001);
        assertEquals(2000.0, budget.getTotalExpenses(), 0.00001);
    }

}
