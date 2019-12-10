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
        income.setTotalIncome(12021.3);
    }

    @Test
    public void budjettiOnAlustettuOikein() {
        assertEquals(12021.3, income.getTotalIncome(), 0.00001);
    }

    @Test
    public void setIncomeToimii() {
        income.setTotalIncome(2000.0);
        assertEquals(2000.0, income.getTotalIncome(), 0.000012);
    }

    @Test
    public void getIncomeToimii() {
        assertEquals(income.getTotalIncome(), income.getTotalIncome(), 0.000012);
    }

    @Test
    public void getIncomeToStringToimii() {

        assertEquals("Income(totalIncome=12021.3)", income.toString());
    }

}
