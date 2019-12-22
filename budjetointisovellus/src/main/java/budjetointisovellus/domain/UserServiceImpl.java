package budjetointisovellus.domain;

import budjetointisovellus.domain.Expense;
import budjetointisovellus.domain.ExpenseRepository;
import budjetointisovellus.domain.Income;
import budjetointisovellus.domain.IncomeRepository;
import budjetointisovellus.domain.User;
import budjetointisovellus.domain.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author blesku
 */
@Service
@RequiredArgsConstructor
//@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    //@Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    //@Transactional
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    //@Transactional
    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }
    @Override
    public List<Income> findAllIncomes(){
        return incomeRepository.findAll();
    }

    @Override
    public long countUsers() {
        return userRepository.count();
    }

}
