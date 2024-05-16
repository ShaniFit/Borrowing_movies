package sample.db;

public class Order extends DBimport{
    private int orderID;
    private int totalPrice;
    private String date;
    private int userID;
    private int movieID;

    public Order(int orderID, int totalPrice, String date, int userID, int movieID) {
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.userID = userID;
        this.movieID = movieID;
    }
    public void newOrder()
    {
            try {
                insertNewOrder(orderID, totalPrice, date, userID, movieID);
                System.out.println("add successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

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
