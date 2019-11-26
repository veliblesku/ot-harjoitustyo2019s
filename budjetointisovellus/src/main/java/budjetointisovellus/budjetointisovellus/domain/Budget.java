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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Budget {

    private Income income;
    private Expenses expenses;

    public double getTotalIncome() {
        return this.income.getTotalIncome();
    }

    public double getTotalExpenses() {
        return this.expenses.getTotalExpenses();
    }
}
