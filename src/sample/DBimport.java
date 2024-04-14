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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "king1471");
            statement = connection.createStatement();
            p=null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void printDB() {
        try {
            resultSet = statement.executeQuery("select * from user");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    * Those insert funcion, inserts to the dataBase the data
    * */
    public void insertNewReview(int reviewID, int rating, String text, int userID, int movieID) {
        try {
            statement.executeUpdate("INSERT INTO review " + "VALUES ('"+reviewID+"','"+rating+"','"+text+"','"+userID+"','"+movieID+"')");
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertNewUser(int id, String userName, String passward, int userID, boolean isAdmin) {
        try {
            statement.executeUpdate("INSERT INTO user " + "VALUES ('"+id+"','"+userName+"','"+passward+"','"+userID+"','"+isAdmin+"')");
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertNewOrder(int orderID, int totalPrice, String date, int userID, int movieID) {
        try {
            statement.executeUpdate("INSERT INTO order " + "VALUES ('"+orderID+"','"+totalPrice+"','"+date+"','"+userID+"','"+movieID+"')");
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertNewMovie(int movieID, String movieTitle, String description, String releaseDate,
                               int duration,int categoryID, boolean isAvailable) {
        try {
            statement.executeUpdate("INSERT INTO movie " + "VALUES ('"+movieID+"','"+movieTitle+"','"+description+"'," +
                    "'"+releaseDate+"','"+duration+"','"+categoryID+"','"+isAvailable+"')");
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertNewCategory(int categoryID, String categoryName) {
        try {
            statement.executeUpdate("INSERT INTO category " + "VALUES ('"+categoryID+"','"+categoryName+"')");
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     *The next export funcion export from the dataBase the data
     * */
    ////The exoprt functions still not working so don't use them.////
    public void exportReview(int reviewID, int userID, int movieID){
        try {
            resultSet = statement.executeQuery("select * from review");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("reviewID") + " " + resultSet.getString("text"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void exportUser(int id){

    }
    public void exportOrder(int orderID, int userID){}
    public void exportMovie(int movieID, int categoryID){}
    public void exportCategory(int categoryID){}

    /*
    *when the app closed we have to use this function.
    * its closing the conection with the DB
     */
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

//    public void insertToTable(String city, String name) {
//        try {
//            statement.executeUpdate("INSERT INTO addresses " + "VALUES ('"+city+"','"+name+"','"+city+"','"+name+"','"+city+"','"+name+"')");
//            System.out.println("add successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void deletFromTable(int id){
//        String sql=String.format( "delete from pepole where id=%d",id);
//        try {
//            statement.execute(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }