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
public class ExpensesTest {

    Expenses expenses = new Expenses();
    

    @Before
    public void setUp() {
        expenses.setBills(600);
        expenses.setFood(210);
        expenses.setEntertainment(200);
        expenses.setLoan(20000);
    }

    @Test
    public void budjettiOnAlustettuOikein() {
        assertEquals(600.0, expenses.getBills(), 0.00001);
        assertEquals(200.0, expenses.getEntertainment(), 0.00001);
        assertEquals(210.0, expenses.getFood(), 0.00001);
        assertEquals(20000.0, expenses.getLoan(), 0.00001);
    }

}
