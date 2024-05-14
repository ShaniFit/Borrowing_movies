package sample;

public class User extends DBimport {
    private int id;
    private String userName;
    private String passward;
    private int userID;
    private int isAdmin;

    public User()
    {

    }
    public User(int id, String userName, String passward, int isAdmin) {
        this.id = id;
        this.userName = userName;
        this.passward = passward;
        this.isAdmin = isAdmin;
    }
    public void newUser()
    {
        try {
            insertNewUser(id,  userName,  passward,  isAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("add successfully");
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



    public int isAdmin() {
        return isAdmin;
    }

    public void setAdmin(int admin) {
        isAdmin = admin;
    }
}

