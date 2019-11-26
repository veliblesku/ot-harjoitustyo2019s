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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.Builder;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Income {
    private double totalIncome;
}
