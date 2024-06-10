package sample.db;

import java.sql.*;


public class DBimport {
    private Statement statement;
    protected static ResultSet resultSet;
    protected static Connection connection;
    private PreparedStatement p;

    public DBimport() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "king1471");
            statement = connection.createStatement();
            p = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Those delete funcion, delete data depend the pramery and forigens Keys and deleting them from the dataBase
     * */
    public void deleteUser(int id) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM user WHERE ID = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteReview(int reviewID, int movieID, int userID) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM review WHERE ReviewID = ? AND MovieID = ? AND UserID = ?;");
            st.setInt(1, reviewID);
            st.setInt(2, movieID);
            st.setInt(3, userID);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteOreder(int orderID, int movieID, int userID) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM review WHERE OrderID = ? AND MovieID = ? AND UserID = ?;");
            st.setInt(1, orderID);
            st.setInt(2, movieID);
            st.setInt(3, userID);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteMovie(int movieID, int categoryID) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM review WHERE MovieID = ? AND categoryID = ?;");
            st.setInt(1, movieID);
            st.setInt(2, categoryID);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCategory(int categoryID) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM user WHERE CategoryID = ?");
            st.setInt(1, categoryID);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
     * Those insert funcion, inserts to the dataBase the data
     * */
    public void insertNewReview(int reviewID, int rating, String text, int userID, int movieID) {
        try {
            statement.executeUpdate("INSERT INTO review " + "VALUES ('" + reviewID + "','" + rating + "','" + text + "','" + userID + "','" + movieID + "')");
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertNewUser(int id, String userName, String passward, Boolean isAdmin) {
        try {
            statement.executeUpdate("INSERT INTO user " + "VALUES ('" + id + "','" + userName + "','" + passward + "','" + isAdmin + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("add successfully");
    }

    public void insertNewOrder(int orderID, int totalPrice, String date, int userID, int movieID) {
        try {
            statement.executeUpdate("INSERT INTO order " + "VALUES ('" + orderID + "','" + totalPrice + "','" + date + "','" + userID + "','" + movieID + "')");
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertNewMovie(int movieID, String movieTitle, String description, String releaseDate,
                               int duration, int categoryID, boolean isAvailable, int price){
        try {
            // TODO - fix the sql query
            statement.executeUpdate("INSERT INTO movie " + "VALUES ('" + movieID + "','" + movieTitle + "','" + description + "'," +
                    "'" + releaseDate + "','" + duration + "','" + categoryID + "','" + isAvailable + "')");
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertNewCategory(int categoryID, String categoryName) {
        try {
            statement.executeUpdate("INSERT INTO category " + "VALUES ('" + categoryID + "','" + categoryName + "')");
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     *The next export funcion export from the dataBase the data
     * */
    public void exportReview() {
        try {
            //insert the data into resultSet object
            resultSet = statement.executeQuery("select * from review");

            //print from the resultSet object to the app
            while (resultSet.next()) {
                System.out.println(resultSet.getString("reviewID") + " " + resultSet.getString("MovieID")
                        + "" + resultSet.getString("Rating") + " " + resultSet.getString("Text")
                        + " " + resultSet.getString("UserID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportSpesificReview(int movieID) {
        try {
            //Exporting the data by movieID
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE MovieID = ?");
            statement.setString(1, String.valueOf(movieID)); // Set the value for the first placeholder to the value of the userName variable

            resultSet = statement.executeQuery();

            //print all the movieID's reviews
            while (resultSet.next()) {
                if (resultSet.next())
                    System.out.println(resultSet.getString("reviewID") + " " + resultSet.getString("MovieID")
                            + "" + resultSet.getString("Rating") + " " + resultSet.getString("Text")
                            + " " + resultSet.getString("UserID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportUser() {
        try {
            resultSet = statement.executeQuery("select * from user");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID") + " " + resultSet.getString("usename")
                        + "" + resultSet.getString("passward") + " " + resultSet.getString("isAdmin"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUserExist(String userName, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            statement.setString(1, userName); // Set the value for the first placeholder to the value of the userName variable
            statement.setString(2, password); // Set the value for the second placeholder to the value of the password variable

            resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void exportOrder() {
        try {
            resultSet = statement.executeQuery("select * from order");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("OrderID") + " " + resultSet.getString("Date")
                        + "" + resultSet.getString("MovieID") + " " + resultSet.getString("TotalPrice")
                        + " " + resultSet.getString("UserID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO - fix the sql query
    public static Movie[] exportMovieByCategory(int categoryID) {
        Movie[] movies = null;
        try {
            PreparedStatement statement = connection.prepareStatement("");
            resultSet = statement.executeQuery("select * from movie");

            movies = new Movie[resultSet.getFetchSize()];
            while (resultSet.next()) {
                // add movie to the array
                movies[resultSet.getRow()] = new Movie(resultSet.getInt("MovieID"), resultSet.getString("MovieTitle"),
                        resultSet.getString("Description"), resultSet.getString("ReleaseDate"),
                        resultSet.getInt("Duration"), resultSet.getInt("CategoryID"), resultSet.getBoolean("IsAvailable"), resultSet.getInt("Price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }


    public void exportCategory(int categoryID) {
        try {
            resultSet = statement.executeQuery("select * from category");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("CategoryID") + " " + resultSet.getString("CategoryName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 // TODO - fix the sql query and all the db handle
    public static Category getCategoryByName(String categoryName) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE CategoryName = ?");
            statement.setString(1, categoryName); // Set the value for the first placeholder to the value of the categoryName variable

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Category(resultSet.getInt("CategoryID"), resultSet.getString("CategoryName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Category();
    }
    /*
     *when the app closed we have to use this function.
     * it's closing the conection with the DB
     */
    public void closeProcess() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printName(String name) {
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