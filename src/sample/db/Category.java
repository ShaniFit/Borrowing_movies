package sample.db;

public class Category extends DBimport {
    private int categoryID;
    private String categoryName;

    private static int categoryIDCounter = 10;

    public Category(int categoryID, String categoryName) {
        if (categoryID== -1) {
            this.categoryID = categoryIDCounter++;
        } else {
            this.categoryID = categoryID;
        }
        this.categoryName = categoryName;
    }
    public Category(){
        this.categoryID = -1;
        this.categoryName = "";
    }

    /**
     * Add new category to the database
     */
    public void addNewCatogoryToDB()
    {
        try {
            insertNewCategory(categoryID,categoryName);
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Given category id and returns the object of the id
     */
    protected Category getCategoryByID(int categoryID) {
        Category c = exportSpesificCategory(categoryID);
        if(c == null) {
            return new Category();
        }
        return c;
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

}
