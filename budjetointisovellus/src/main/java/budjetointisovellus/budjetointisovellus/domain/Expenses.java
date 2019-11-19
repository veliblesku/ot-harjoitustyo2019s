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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expenses {

    
    //Täältä pitää hieroa setterit ja getterit kuntoon
    
    private double food;
    private double bills;
    private double entertainment;
    private double loan;
    private double totalExpenses = this.bills + this.food + this.entertainment + this.loan;
    


}
