/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banking;

import java.util.Scanner;

/**
 *
 * @author fbarasa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("....SIMPLE BANKING APPLICATION HOME PAGE....");
        String username;
        String password;
        //Ask user to enter username and password
     
        Scanner in = new Scanner(System.in);
        System.out.println("Enter username to register: ");
        username = in.nextLine();
        System.out.println("Enter password: ");
        password = in.nextLine();
        
        //Call the register method in the customer class
        Customer customer = new Customer();
        customer.register(username, password);
    }
    
}
