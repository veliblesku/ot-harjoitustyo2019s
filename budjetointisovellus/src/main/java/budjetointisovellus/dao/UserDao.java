/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budjetointisovellus.dao;
import java.util.*;
import java.sql.*;
import budjetointisovellus.budjetointisovellus.domain.User;
/**
 *
 * @author blesku
 */
public interface UserDao<T,K> {
    void create(T object) throws SQLException;
    T read(K key) throws SQLException;
    T update(T object) throws SQLException;
    void delete(K key) throws SQLException;
    List<T> list() throws SQLException;
    User findByUsername(String username) throws SQLException;
}
