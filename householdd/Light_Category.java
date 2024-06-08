package householdd;

/**
 * This abstract class is called Light_Category which is one of two categories
 * that we have in our shop section , the class extends from the product class
 * and implements the HouseHoldProducts_Section interface this class in an
 * abstract class cause of it will not give an implementation for methods in the
 * product abstract class (the subclasses of Light_Category will give the
 * implementation)
 *
 * @version 1.0
 */
public abstract class Light_Category extends Product implements HouseHoldProducts_Section {

    //Data member...
    /**
     * This instance field will store the category name,this value not allowed
     * to be changed ..
     */
    public static final String CATEGORY_NAME = "Lighting";
    /**
     * This instance field will store two digit which is the ID number for this
     * category ..
     */
    public static final String CATEGORY_ID = "20";

    //Constructor ....
    /**
     *
     */
    public Light_Category() {
    }//the end of the method 

    //method
    /**
     * This method will be implemented from the interface class and it's used to
     * print the useful information about the class..
     *
     * @return string
     */
    @Override
    public String toString() {
        return ("Section Id: " + SECTION_ID + "\t Category name: " + CATEGORY_NAME + "\tCategory ID: " + CATEGORY_ID);
    }//the end of the method 

}//the end of the class 
