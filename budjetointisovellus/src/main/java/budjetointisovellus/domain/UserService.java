/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.domain;

import budjetointisovellus.domain.Expense;
import budjetointisovellus.domain.Expense;
import budjetointisovellus.domain.Income;
import budjetointisovellus.domain.Income;
import budjetointisovellus.domain.User;
import budjetointisovellus.domain.User;
import java.util.List;

/**
 *
 * @author blesku
 */
public interface UserService {

    User createUser(User User);

    User getUser(Long id);

    User findUserByUsername(String username);

    User editUser(User user);

    void deleteUser(User user);

    List findAllUsers();

    List findAllExpenses();

    List findAllIncomes();

    long countUsers();

    Expense createExpense(Expense expense);

    Income createIncome(Income income);
}
