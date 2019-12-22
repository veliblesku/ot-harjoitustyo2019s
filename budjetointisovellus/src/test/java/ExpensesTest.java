/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import budjetointisovellus.domain.Expense;
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
public class ExpensesTest {

    Expense expense = new Expense();
    User user;

    @Before
    public void setUp() {
        expense.setAmount(600);
        expense.setName("tietokone");
        
    }

    @Test
    public void expenseOnAlustettuOikein() {
        assertEquals(600.0, expense.getAmount(), 0.00001);
        assertEquals("tietokone", expense.getName());
    }

    @Test
    public void setexpenseToimii() {
        expense.setAmount(2000.0);
        assertEquals(2000.0, expense.getAmount(), 0.000012);
    }

    @Test
    public void getexpenseToimii() {
        assertEquals(600.0, expense.getAmount(), 0.000012);
    }

    @Test
    public void getJaSetNameToimii() {
        expense.setName("kivisaksetpaperi");
        assertEquals("kivisaksetpaperi", expense.getName());
    }

}
