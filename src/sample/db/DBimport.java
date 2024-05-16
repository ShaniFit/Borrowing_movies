package sample.db;

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
    /*
     * Those delete funcion, delete data depend the pramery and forigens Keys and deleting them from the dataBase
     * */
    public void deleteUser(int id){
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM user WHERE ID = ?");
            st.setInt(1,id);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void deleteReview(int reviewID,int movieID, int userID){
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM review WHERE ReviewID = ? AND MovieID = ? AND UserID = ?;");
            st.setInt(1,reviewID);
            st.setInt(2,movieID);
            st.setInt(3,userID);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void deleteOreder(int orderID,int movieID,int userID){
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM review WHERE OrderID = ? AND MovieID = ? AND UserID = ?;");
            st.setInt(1,orderID);
            st.setInt(2,movieID);
            st.setInt(3,userID);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void deleteMovie(int movieID, int categoryID){
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM review WHERE MovieID = ? AND categoryID = ?;");
            st.setInt(1,movieID);
            st.setInt(2,categoryID);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void deleteCategory(int categoryID){
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM user WHERE CategoryID = ?");
            st.setInt(1,categoryID);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
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
    public void insertNewUser(int id, String userName, String passward, int isAdmin) {
        try {
            statement.executeUpdate("INSERT INTO user " + "VALUES ('"+id+"','"+userName+"','"+passward+"','"+isAdmin+"')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("add successfully");
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
    public void exportReview(){
        try {
            //insert the data into resultSet object
            resultSet = statement.executeQuery("select * from review");

            //print from the resultSet object to the app
            while (resultSet.next()) {
                System.out.println(resultSet.getString("reviewID") + " " + resultSet.getString("MovieID")
                        +""+resultSet.getString("Rating") + " " +resultSet.getString("Text")
                        + " " +resultSet.getString("UserID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void exportUser(){
        try {
            resultSet = statement.executeQuery("select * from user");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID") + " " + resultSet.getString("usename")
                +""+resultSet.getString("passward") + " " +resultSet.getString("isAdmin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void exportOrder(){
        try {
            resultSet = statement.executeQuery("select * from order");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("OrderID") + " " + resultSet.getString("Date")
                        +""+resultSet.getString("MovieID") + " " +resultSet.getString("TotalPrice")
                        + " " +resultSet.getString("UserID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void exportMovie(int movieID, int categoryID){
        try {
            resultSet = statement.executeQuery("select * from movie");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("MovieID") + " " + resultSet.getString("CategoryID")
                        +" "+resultSet.getString("Description") + " " +resultSet.getString("Duration")
                        + " " +resultSet.getString("IsAvailable")+""+resultSet.getString("MovieTitle")
                        + " " +resultSet.getString("ReleaseDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void exportCategory(int categoryID){
        try {
            resultSet = statement.executeQuery("select * from category");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("CategoryID") + " " + resultSet.getString("CategoryName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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