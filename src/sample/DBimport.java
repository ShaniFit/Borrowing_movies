package sample;
import java.sql.*;

import java.sql.*;

public class DBimport {
    private Statement statement;
    private ResultSet resultSet;
    private Connection connection;
    private PreparedStatement p;
    public DBimport() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook", "root", "king1471");
            statement = connection.createStatement();
            p=null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void printDB() {
        try {
            resultSet = statement.executeQuery("select * from pepole");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstname") + " " + resultSet.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertToTable(String city, String name) {
        try {
            statement.executeUpdate("INSERT INTO addresses " + "VALUES ('"+city+"','"+name+"','"+city+"','"+name+"','"+city+"','"+name+"')");
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deletFromTable(int id){
        String sql=String.format( "delete from pepole where id=%d",id);
        try {
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeProcess()
    {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void printName(String name)
    {
        System.out.println(name);
    }
}
