/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.dao;

import java.util.*;
import java.sql.*;
import budjetointisovellus.budjetointisovellus.domain.User;
import budjetointisovellus.budjetointisovellus.domain.Budget;
import budjetointisovellus.dao.UserDao;
import budjetointisovellus.budjetointisovellus.domain.Income;
import budjetointisovellus.budjetointisovellus.domain.Expenses;
import budjetointisovellus.budjetointisovellus.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 *
 * @author blesku
 */
public class DBUserDao implements UserDao {

//    @Autowired
//    private UserRepository itemRepository;
    private List<User> users;

//    @Autowired
//    private UserDao userdao;
//    ////////
//    @Override
//    public List<User> list() throws SQLException {
//        return itemRepository.findAll();
//    }
//
//    public void create(User user) throws SQLException {
//        itemRepository.save(user);
//    }
    //// ^^^^^^^^^
    @Override
    public List<User> list() throws SQLException {
        return users;

    }

    @Override
    public User findByUsername(String username) throws SQLException {

        return null;
    }

    @Override
    public void create(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object read(Object key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object update(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
