/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking;

import java.sql.*;

/**
 *
 * @author fbarasa
 */
public class Customer {

    //Member variable declaration
    private String name;
    private String address;
    private int customerId;
    private String phone;
    private String dOb;

    //Constructor (s)
    Customer() {

    }

    //Member methods
    public void register(String uName, String password) {
        //Store the arguements in local variables
        int role = 0;
        //Instantiate DBConnection class to begin DB connection
        DBConnection dBConnect = new DBConnection();
        dBConnect.doConnection();
        try {
            //STEP 3. CREATE a Statement object to help access querry execution methods
            Statement stmt = dBConnect.con.createStatement();
            //STEP 4. Execute SQL Query
            // Execute a SELECT query
            String selectQuery = "INSERT INTO users(username, password,userrole) VALUES ('" + uName + "','" + password + "','"+role+"')";
            stmt.executeUpdate(selectQuery);
            //STEP 6. Close the DB Connection when done using it
            dBConnect.con.close();
            //Intantiate the Login class to access doLogin method
            System.out.println("Record saved");
            Login login = new Login();
            login.doLogin();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }

    }

    public int deposit(int x) {
        return x;
    }

    public int withdraw(int x) {
        return x;
    }
}
