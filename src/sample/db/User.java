package sample.db;

public class User extends DBimport {
    // TODO: change user to work with mail maybe instead of username
    private int id;
    private String userName;
    private String passward;
    private Boolean isAdmin;

    static int idCounter = 0;

    public User()
    {

    }
    public User(int id, String userName, String passward, Boolean isAdmin) {
        this.id = idCounter++;
        this.userName = userName;
        this.passward = passward;
        this.isAdmin = isAdmin;
    }

    protected static boolean User_login(String username, String password) {
        if (checkUserExist(username, password)){//check if user exist return true
            //type some code
            return true;
        }
        else{//user not exist
            return false;
        }
    }

    public static User login(String username, String password) {
//        TODO - temp
        if(true){
//        if (checkUserExist(username, password)){//check if user exist return true
            //type some code
            return new User(1, username, password, false);
        }
        else{//user not exist
            return null;
        }
    }

    public void addNewUserInDB()
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


    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }


    public boolean saveOnDB() {
        try {
            insertNewUser(id, userName, passward, isAdmin);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

