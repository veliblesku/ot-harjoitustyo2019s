/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author blesku
 */
public class DbConnection {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:./test";

    static final String USER = "";
    static final String PASS = "";

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:h2:." + fileName + ";INIT=CREATE SCHEMA IF NOT EXISTS TEST";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();      
        }
    }

    public static void createNewTable(String fileName) {
        // SQLite connection string
        String url = "jdbc:h2:" + fileName;

        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver 
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection 
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query 
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE   USERS "
                    + "(id INTEGER not NULL, "
                    + " username VARCHAR(255), "
                    + " password VARCHAR(255), "
                    + " budget OTHER, "
                    + " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

            // STEP 4: Clean-up environment 
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC 
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName 
            e.printStackTrace();
        } finally {
            //finally block used to close resources 
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            } // nothing we can do 
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try 
        } //end try 
        System.out.println("Goodbye!");
    }
}
