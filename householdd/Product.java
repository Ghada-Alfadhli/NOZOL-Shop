package householdd;

/**
 * This abstract class will have the information for our shop products this
 * class will have a relation with the Basket class we define reference variable
 * of type Basket
 *
 * @version 1.0
 */
public abstract class Product {

    //Data members.....
    /**
     * This instance field will be store the name of the product.
     */
    private String Product_Name;

    /**
     * This instance field will be an object of the Basket class this is a
     * relation between the basket class and each items classes this value will
     * be assigned by reference in the items classes(subclasses) ...
     */
    protected Basket Basket_Of_Customer;

    /**
     * This instance field will be store the description of the product.
     */
    private String Description;

    /**
     * This instance field will be store the price of the product.
     */
    private int Price;
    /**
     * This instance field will be store the quantity of the product.
     */
    private int Quantity;

    /**
     * This instance static field will have the item IDs for all items (
     * products in the store )...
     */
    protected static String item_ID = HouseHoldProducts_Section.SECTION_ID + "" + "00";

    //Constructor...
    /**
     *
     */
    public Product() {
    }//the end of the method 

    //getter methods...
    /**
     * This instance method will get the reference of the Basket object
     *
     * @return Basket
     */
    public Basket getBasket_Of_Customer() {
        return Basket_Of_Customer;
    }//the end of the method 

    /**
     * This abstract method will be performing the method Check_Discount()
     * located in the Shop_Menu class , to check if there is a discount or not
     * and then prices will be changed depending on the discount..
     */
    public abstract void Item_Menu_New_Price();

    /**
     * This instance method is used to add items from the item list that been
     * chosen by the customer to the customer basket ...
     *
     * @param name_of_item
     * @param quantity_of_item
     */
    public abstract void Add_Item(String name_of_item, int quantity_of_item);

}//the end of the class 
