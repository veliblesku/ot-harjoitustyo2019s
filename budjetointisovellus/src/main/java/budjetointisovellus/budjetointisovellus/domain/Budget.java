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
public class Budget {

    private Income income;
    private Expenses expenses;
    private double totalIncome;
    private double totalExpenses;

    public Budget() {
    }

    
    // Hiero getterit ja setterit kuntoon. 
    //   ___Kysy luokan perimisestä!___
    
    
    public Budget(Income income, Expenses expenses) {
        this.income = income;
        this.expenses = expenses;
        this.totalIncome = this.income.getInvestments() + this.income.getPayroll() + this.income.getSavings() + this.income.getSellingStuff();
    }

//    public double getDailyBudget(){
//        double dailyBudget;
//        dailyBudget = this.budget/30;
//        return dailyBudget;
//    }
//    public void addExtraIncome(double income){
//        this.income = this.income + income;
//    }
//    public void spend(double amount){
//        this.budget = this.budget - amount;
//    }
   
    
    public void setTotalIncome(){
        this.totalIncome = this.income.getInvestments() + this.income.getPayroll() + this.income.getSavings() + this.income.getSellingStuff();
    }
    public double getTotalIncome() {
        return this.totalIncome;
    }

    public double getTotalExpenses() {
        return this.income.getInvestments();
    }
//    public double getOutcome(){
//        return this.expenses;
//    }
//    public double getBudget(){
//        return this.budget;
//    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }
//    public void setBudget(double budget){
//        this.budget = budget;
//    }
}
