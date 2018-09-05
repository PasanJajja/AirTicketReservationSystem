package main;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {
    public static Connection connect(){//need to use this method in other places
                                        //so public.. and it should not be changed
                                        //in other places so static
        Connection conn = null;//to return conn temporally
        
        try{
            Class.forName("com.mysql.jdbc.Driver");//introducing the driver to the class
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
                                                        //has to pass 3 parameters to the connection
                                                         //1. the link of the database location
                                                         //2.phpmyadmin access user's name is root
                                                         //3. password is null
        } catch(ClassNotFoundException | SQLException e){//or catch(Exception e)
            //these two are the exceptions that can handle..and we have handle
            //both exceptions
            System.out.println(e);
            // e will give us the exception name
        }
        
        return conn;
    }
}
