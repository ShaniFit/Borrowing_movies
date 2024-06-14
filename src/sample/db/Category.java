package sample.db;

public class Category extends DBimport {
    private int categoryID;
    private String categoryName;

    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }
    public Category(){ }
    public void addNewCatogoryToDB(int categoryID, String categoryName)
    {
        try {
            insertNewCategory(categoryID,categoryName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("add successfully");
    }
    public void newCategory()
    {
        try {
            insertNewCategory(this.categoryID, this.categoryName);
            System.out.println("add successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Given category id and returns the object of the id
    protected Category getCategoryByID(int categoryID) {
        Category c = exportSpesificCategory(categoryID);
        return c;
    }
    protected Category[] getCategories(int categoryID) {
        return exportCategory();
    }
    public int catgtoryNameToCategoryID(String categoryName) {
        Category category = getCategoryByName(categoryName);
        if (category == null) {
            return -1;
        }
        return category.getCategoryID();
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
