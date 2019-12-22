/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import budjetointisovellus.domain.Expense;
import budjetointisovellus.domain.Income;
import budjetointisovellus.domain.User;
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
        income.setAmount(5);
        income.setName("pullojen palautus");
    }

    @Test
    public void budjettiOnAlustettuOikein() {
        assertEquals(5.0, income.getAmount(), 0.00001);
        assertEquals("pullojen palautus", income.getName());
    }

    @Test
    public void setIncomeToimii() {
        income.setAmount(2000.0);
        assertEquals(2000.0, income.getAmount(), 0.000012);
    }

    @Test
    public void getIncomeToimii() {
        assertEquals(5.0, income.getAmount(), 0.000012);
    }

    @Test
    public void getJaSetNameToimii() {
        income.setName("kivisaksetpaperi");
        assertEquals("kivisaksetpaperi", income.getName());
    }

}
