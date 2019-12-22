///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import budjetointisovellus.budjetointisovellus.domain.Budget;
//import budjetointisovellus.budjetointisovellus.domain.Expenses;
//import budjetointisovellus.budjetointisovellus.domain.Income;
//import budjetointisovellus.budjetointisovellus.domain.User;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author blesku
// */
//public class ExpensesTest {
//
//    Expenses expenses = new Expenses();
//
//    @Before
//    public void setUp() {
//        expenses.setTotalExpenses(12210.1);
//    }
//
//    @Test
//    public void expensesOnAlustettuOikein() {
//        assertEquals(12210.1, expenses.getTotalExpenses(), 0.00001);
//    }
//
//    @Test
//    public void getExpensesToimii() {
//        assertEquals(12210.1, expenses.getTotalExpenses(), 0.00001);
//    }
//
//    @Test
//    public void setExpensesToimii() {
//        expenses.setTotalExpenses(2000.0);
//        assertEquals(2000.0, expenses.getTotalExpenses(), 0.00001);
//    }
//
//    @Test
//    public void expensesToStringToimii() {
//        assertEquals("Expenses(totalExpenses=12210.1)", expenses.toString());
//    }
//
//}
