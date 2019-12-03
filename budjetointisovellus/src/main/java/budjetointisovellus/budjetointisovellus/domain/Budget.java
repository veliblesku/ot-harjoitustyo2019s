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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Budget extends AbstractPersistable<Long> {
    @OneToOne(cascade = {CascadeType.ALL})
    private Income income;
    @OneToOne(cascade = {CascadeType.ALL})
    private Expenses expenses;

    public double getTotalIncome() {
        return this.income.getTotalIncome();
    }

    public double getTotalExpenses() {
        return this.expenses.getTotalExpenses();
    }
}
