package sample;

public class User extends DBimport {
    private int id;
    private String userName;
    private String passward;
    private int userID;
    private boolean isAdmin;

    public User(int id, String userName, String passward, int userID, boolean isAdmin) {
        this.id = id;
        this.userName = userName;
        this.passward = passward;
        this.userID = userID;
        this.isAdmin = isAdmin;
    }
    public void newUser()
    {
        try {
            insertNewUser(id,  userName,  passward,  userID,  isAdmin);
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

