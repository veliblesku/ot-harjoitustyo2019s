/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.budjetointisovellus.domain;

/**
 *
 * @author blesku
 */
public class MainForTesting {

    public static void main(String[] args) throws Exception {
        
        // file for testing stuff
        
        
        User user = new User();
        Income income = new Income();
        Expenses expenses = new Expenses();
        
        Budget budget = new Budget();
        
        income.setInvestments(1000.0);
        income.setPayroll(2600.0);
        budget.setExpenses(expenses);

        user.setBudget(new Budget(income, expenses));
        
        System.out.println("income.getinvestments");
        System.out.println(income.getInvestments());
        System.out.println("usertoString");
        System.out.println(user.toString());
        System.out.println("user.getBudget");
        System.out.println(user.getBudget());
        System.out.println("user.getbudget.gettotalincome");
        System.out.println(user.getBudget().getTotalIncome());
    }
}