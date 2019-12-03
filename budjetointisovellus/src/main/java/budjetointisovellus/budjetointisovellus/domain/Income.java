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

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.Builder;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Income extends AbstractPersistable<Long> {
    private double totalIncome;
}
