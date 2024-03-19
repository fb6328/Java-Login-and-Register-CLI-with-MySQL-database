/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking;

//import com.mysql.cj.xdevapi.Statement;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author fbarasa
 */
public class Login {
    //Member variable decalaration
    //Constructor
    Login() {
   }

    public void doLogin() {
System.out.println("....SIMPLE BANKING APPLICATION LOGIN....");
        String username;
        String password;
        //Ask user to enter username and password
     
        Scanner in = new Scanner(System.in);
        System.out.println("Enter username to register: ");
        username = in.nextLine();
        System.out.println("Enter password: ");
        password = in.nextLine();        

//Instantiate DBConnection class to begin DB connection
        DBConnection dBConnect = new DBConnection();
        dBConnect.doConnection();
        try {
            //STEP 3. CREATE a Statement object to help access querry execution methods
            Statement stmt = dBConnect.con.createStatement();

            //STEP 4. Execute SQL Query
            // Execute a SELECT query
            String selectQuery = "SELECT * FROM users";
            ResultSet resultSet = stmt.executeQuery(selectQuery);

            //STEP 5. Process the resultset
            // Process the ResultSet
            if (resultSet.next()) {
                //Get database values and store them in local variables
                String dbusername = resultSet.getString("username");
                String dbpassword = resultSet.getString("password");
                //String role = resultSet.getString("userrole");
                if (username.equalsIgnoreCase(dbusername) && password.equals(dbpassword)) {
                    System.out.println("Login successful");
                    System.out.println("Write the for Customer dashboard");
                } else {
                    System.out.println("Login failed. Incorrect username or password");
                }
            }
            //STEP 6. Close the DB Connection when done using it
            dBConnect.con.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }

}
