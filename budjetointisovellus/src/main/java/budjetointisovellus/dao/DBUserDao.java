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

/**
 *
 * @author blesku
 */
public class DBUserDao implements UserDao {

    private String url = "postgres://eznwbwkq:8KG9v364qRAbidnHOA7FIlFclY9ziH4j@balarama.db.elephantsql.com:5432/eznwbwkq";
    private String apikey = "51e59c26-93d7-48b2-8c45-6b3a5108b866";
    private String user = "eznwbwkq";
    private String pw = "8KG9v364qRAbidnHOA7FIlFclY9ziH4j";
    private List<User> users;

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
