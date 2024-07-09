package sample.db;

import java.util.Random;

public class Order extends DBimport{
    private int orderID;
    private String date;
    private int userID;
    private int movieID;
    private int totalPrice;

    public Order(int orderID,int totalPrice, String date, int userID, int movieID) {
        if (orderID == -1) {
            Random rand = new Random();
            this.orderID = rand.nextInt(9999);
        } else {
            this.orderID = orderID;
        }
        this.totalPrice = totalPrice;
        this.date = date;
        this.userID = userID;
        this.movieID = movieID;
    }

    public Order() {

    }

    public void addNewOrderToDB()
    {
            try {
                insertNewOrder(orderID,totalPrice, date, userID, movieID);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Override
    public Order[] exportSpesificOrder(int userID) {
        return super.exportSpesificOrder(userID);
    }
    public Order[] exportOrders(){
        return super.exportOrders();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

//    public int getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(int totalPrice) {
//        this.totalPrice = totalPrice;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }
}
