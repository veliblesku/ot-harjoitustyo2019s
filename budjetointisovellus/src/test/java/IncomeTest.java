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
public class IncomeTest {

    Income income = new Income();

    @Before
    public void setUp() {
        income.setInvestments(1000.0);
        income.setPayroll(2600.0);
        income.setSavings(200);
        income.setSellingStuff(50);
    }

    @Test
    public void budjettiOnAlustettuOikein() {
        assertEquals(1000.0, income.getInvestments(), 0.00001);
        assertEquals(2600.0, income.getPayroll(), 0.00001);
        assertEquals(200.0, income.getSavings(), 0.00001);
        assertEquals(50.0, income.getSellingStuff(), 0.00001);
    }

}
