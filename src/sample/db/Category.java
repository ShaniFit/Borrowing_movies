package sample.db;

import java.sql.PreparedStatement;

public class Category extends DBimport {
    private int categoryID;
    private String categoryName;

    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }
    public Category(){
        categoryID =0;
        categoryName = null;
    }
    // TODO - fix the sql query
    protected static Category getCategoryByID(int categoryID) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM category WHERE CategoryID = ?");
            statement.setInt(1, categoryID); // Set the value for the first placeholder to the value of the categoryID variable

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Category(resultSet.getInt("CategoryID"), resultSet.getString("CategoryName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Category();
    }

    public static String categoryIdToCategoryName(int categoryID) {
        Category category = getCategoryByID(categoryID);
        if (category.isEmpty()) {
            return null;
        }
        return category.getCategoryName();
    }

    public void newCategory()
    {
        try {
            insertNewCategory(categoryID, categoryName);
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public static int catgtoryNameToCategoryID(String categoryName) {
        Category category = DBimport.getCategoryByName(categoryName);
        if (category.isEmpty()) {
            return -1;
        }
        return category.getCategoryID();
    }

    private boolean isEmpty() {
        return  (categoryID == 0 && categoryName == null);
    }
}
