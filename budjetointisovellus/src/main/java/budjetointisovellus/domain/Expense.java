/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.domain;

/**
 *
 * @author blesku
 */
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;
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
public class Expense extends AbstractPersistable<Long> {

    private String name;
    private double amount;

    @ManyToOne
    User user;

}
