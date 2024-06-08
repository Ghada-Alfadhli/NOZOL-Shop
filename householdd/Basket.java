package householdd;

import java.util.Scanner;//to read from user

/**
 * This class will have the customer basket content (it will be stored in an 2D
 * array)....
 *
 * @version 1.0
 */
public class Basket {

//Data member ..... 
    static Scanner c = new Scanner(System.in);
    //create object of Scanner class (to read from the user)

    /**
     * This instance final field will be the basket for the customer (each
     * customer will have only one basket-final) each customer have a maximum
     * number of products to add in the basket which will be (20 products) the
     * basket will store for each product ( product name ,product ID ,
     * description , quantity as the customer wants and price) it is a protected
     * so it can be accessed by the items classes ..
     */
    protected final String[][] Customer_Basket = new String[20][5];
    //0- 4 name Id description quantity price 

    /**
     * This instance field will store last index of the customer basket (the
     * customer may not add all the 20 products )....
     */
    private int Last_item_Index = -1;

    //Constructor 
    /**
     *
     */
    public Basket() {
    }//the end of the method 

    //Other methods
    /**
     * This utility method will print a menu for the customer to continue or go
     * to the bill...
     */
    public static void Check_Continues() {
        System.out.println("____________________________________________");
        System.out.println("1.continue shopping\t2.Go to the bill");
        System.out.println("____________________________________________");
    }//end mthod Update_Basket 

    /**
     * This static method (utility method) will check the range for the input
     * that entered from the user if the user enter 1(return 1) , 2 (return 2)or
     * any number (return 0)
     *
     * @param num
     * @return int
     */
    public static int Check_Range(int num) {
        switch (num) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }//the end of the switch block 
    }//the end of the method 

    /**
     * in this method , we will call the form in the customer This instance
     * method will print the basket information to the user ..
     */
    public void Show_Basket() {
        //int index_column=0;
        System.out.println("..................................");
        outer:
        for (int index_row = 0; index_row < Last_item_Index + 1; index_row++) {
            inner:
            for (int index_column = 0; index_column < 5; index_column++) {
                if (!(this.Customer_Basket[index_row][index_column].equals(""))) {
                    if (index_column != 4) {
                        /*
                    if the index of column not equals to 4 ( column of the prices )
                    we will printed normally
                         */
                        System.out.println(this.Customer_Basket[index_row][index_column]);
                    }//the end of the if statement
                    else /*
                    if the index of column ==4 then we want just 2 digits after 
                    the decimal points
                    first we need to convert the String to double by the method 
                    valueOf(String ) in the wrapper class double 
                    and the print with formating .....
                     */ {
                        System.out.printf("%.2f%n", Double.valueOf(this.Customer_Basket[index_row][index_column]));
                    }//the end of the else block 
                }//the end of the outer if statement
                else {
                    continue outer;
                }
            }//end for 2
            System.out.println("..................................");
        }//end for1
    }//end mthood Show_Basket

    /**
     * This instance method will remove item form the basket there are 3 cases
     * first case if the customer want to remove all quantity of this product (
     * the row of this product will be filled by empty string) second case if
     * the customer want to remove quantity less than quantity stored in the
     * basket third case if the customer want to remove quantity more than in
     * the basket
     *
     * @param product_name
     * @param quantity_of_product
     */
    public void Remove_Item(String product_name, int quantity_of_product) {
        int index_Of_Remove = 0;
        int quantity_Of_Basket = 0;

        //store the index of the product that will be removed
        if (this == null || !this.Customer_Basket[0][0].equalsIgnoreCase(" ")) {
            for (int i1 = 0; i1 < Last_item_Index + 1; i1++) {
                if (this.Customer_Basket[i1][0].equalsIgnoreCase(product_name)) {
                    index_Of_Remove = i1;
                    quantity_Of_Basket = Integer.valueOf(this.Customer_Basket[i1][3].substring(1));
                    //store the quantity of the remove product 

                    if (quantity_Of_Basket - quantity_of_product == 0) {
                        this.Customer_Basket[i1][0] = "";//name
                        this.Customer_Basket[i1][1] = "";//ID
                        this.Customer_Basket[i1][2] = "";//description 
                        this.Customer_Basket[i1][3] = "";//quantity 
                        this.Customer_Basket[i1][4] = "";//price

                    }//the end 
                    else if (quantity_of_product <= quantity_Of_Basket) {  //3 330 ->2 330    (1)-> (330/2) 

                        this.Customer_Basket[i1][3] = "X" + (quantity_Of_Basket - quantity_of_product);
                        /*
                       first we will get the price that stored and the quantity 
                       then price/quantity from this equation we will get the price
                       of one product
                       then it will be multipled by the (quantity_of_product)
                       the result from this will be minuse from the price 
                         */
                        double price = Double.valueOf(this.Customer_Basket[i1][4]);
                        double price_of_each_product = price / quantity_Of_Basket;
                        this.Customer_Basket[i1][4] = (price - (price_of_each_product * quantity_of_product)) + "";
                    }//the end of the else block
                    else {
                        System.out.println("The quantity that you want to remove is more than in the basket.....");
                    }
                }//assign a value for it 
            }

        }//the end of the if statement

    }//end mthood Remove_Item 

    //getter method 
    /**
     *
     * @return Last_item_Index
     */
    public int getLast_item_Index() {
        return Last_item_Index;
    }//the end of the method 

    /**
     *
     * @return Customer_Basket
     */
    public String[][] getCustomer_Basket() {
        return Customer_Basket;
    }//the end of the method 

    /**
     *
     * @param n
     */
    public void setLast_item_Index(int n) {
        Last_item_Index = n;
    }//the end of the method 

}//the end of the class 
