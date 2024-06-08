package householdd;

/**
 * The bill class will print the bill for the customer with the correct
 * information there is a relation between the Bill and Basket object of type
 * Basket in the Bill class
 *
 * @version 1.0
 */
public class Bill {

    //Data memebers ....
    /**
     * This instance filed from String will store the bill number, it is
     * instance cause of each bill will have different number Each bill number
     * will starts with #0 and then the unique number ..
     */
    private String Bill_Number;//for each customer 

    /**
     * This static variable each time will change the value of it,and then this
     * value will be assigned to the Bill_Number...
     */
    private static String BillNumber_for_all = "#0000";//#0

    /**
     * This instance variable will store the total price (products prices ,
     * shipment price ,tax price ....etc)...
     */
    private double Total_Price;

    /**
     * This instance variable will store the discount price depend on the period
     * if there is discount in it or not by using the methods or variables in
     * the shop menu class....
     */
    private String Discount_Percent;

    /**
     * This static final variable will store the shipment price, the variable
     * will be final cause of the shipment price will be the same for all order
     * this price for all order from all cities (this price will not change)..
     */
    private final static double SHIPMENT_PRICE = 35;

    /**
     * This static final variable will store the price of the tax ...
     */
    private static final double TAX_PRICE = 1.15;

    /**
     * This instance object will store the Basket object of the customer ...
     */
    private Basket customer_Basket;

    /**
     * this instance variable will changed to true when the bill is created for
     * each customer ...
     */
    private boolean BillCreated = false;//assume that the bill is not created 

    //Constructor...
    //default constructor 
    /**
     * In the constructor it will take part of the BillNumber_for_all (the last
     * three digits) from the index 2 till the end and then increase the value
     * of it then assign it to the Bill_Number and the constructor will give a
     * value to the reference variable of type Basket...
     */
    public Bill() {
        /*
         use the valueOf (String) in the wrapper class integar to convert from String to an integar 
         so this value can be increase
         */
        int number = Integer.valueOf(BillNumber_for_all.substring(3));//three last digits 

        /*
         reassign the value after increasing to the BillNumber_for_all 
         with #0 at the start 
         */
        BillNumber_for_all = "#0000" + (++number);
        //after this statment the value of the number increased by one 

        /*
          assign the value of the BillNumber_for_all to the Bill_Number
         */
        Bill_Number = BillNumber_for_all;

        /*
          Assing a a value to the refernce variable 
         */
        this.customer_Basket = customer_Basket;
    }//the end of the method 

    //Getter Methods 
    /**
     * This instance method will return the total prices (products prices
     * ,shipment,tax...) it is private cause of it only be used in this class in
     * the CreateBill()
     *
     * @return double
     */
    private double getTotal_Price() {
        return Total_Price;//return the value of the Total_Price()
    }//the end of the method 

    /**
     * This instance method will return the tax price
     *
     * @return double
     */
    private double getTAX_PRICEE() {
        return TAX_PRICE;//the value of the tax price in the Saudi Arabia
    }//the end of the method 

    /**
     * This instance method will return the shipment price
     *
     * @return double
     */
    private double getSHIPMENT_PRICE() {
        return SHIPMENT_PRICE;
    }//the end of the method 

    /**
     * This instance method will return the Discount percent (the discount
     * percent if the period of the discount exit) so this method first will
     * check field Found_Discount by the get method from the Shop_Menu class if
     * it true then it will return the value of value_of_discount also by the
     * get method, if it false return (empty String )
     *
     * @return String
     */
    private String getDiscount_Price() {
        if (Shop_Menu.getFound_Discount()) //Shop_Menu.getFound_Discount()means if the return of this method==true
        //static method called via the class name 
        {
            return Shop_Menu.getValue_of_discount();
        } else //if the return of the method != false
        //means there is no discount 
        {
            return "";
        }
    }//the end of the method 

    /**
     * This instance method will return the Bill number as String
     *
     * @return Bill_Number
     */
    private String getBill_Number() {
        return Bill_Number;
    }//the end of the method 

    /**
     * This instance method is support method it just used in the class methods,
     * assign a value for the Total_Price variable in the getTotal_Price()
     * method..
     */
    private void setTotal_Price() {
        double price = 0;//to store the prices of the product in the customer basket

        outer://label
        for (int index_row = 0; index_row < customer_Basket.getLast_item_Index() + 1; index_row++) {
            inner:
            for (int index_column = 0; index_column < 5; index_column++) {
                /*
             first get the prices in the basket of the customer access it via 
             Basket object ... 
                 */
                if (!(this.customer_Basket.getCustomer_Basket()[index_row][index_column].equals(""))) {
                    price += Double.valueOf(customer_Basket.Customer_Basket[index_row][4]);
                }
                continue outer;
                //the column index =3 is the price column 
            }//the end of the 
        }//the end of the for loop
        Total_Price = (price * TAX_PRICE) + SHIPMENT_PRICE;
        //set the value of the total price in the fied Total_Price()
    }//the end of the method 

    /**
     * This method will set a value for the Discount_Percent assign value of the
     * percent of the discount if there is discount period this method will
     * first check the value of Found_Discount via get method if it true then
     * this method will assign Discount_Percent to the return of the method
     * Value_of_discount if it false assign Discount_Percent to ( empty String )
     * means the period not a discount period
     *
     * @param Discount_Percent
     */
    private void setDiscount_Percent(String Discount_Percent) {
        if (Shop_Menu.getFound_Discount()) //Shop_Menu.getFound_Discount()means if the return of this method==true
        //static method called via the class name 
        {
            Discount_Percent = Shop_Menu.getValue_of_discount();
        } else //if the return of the method != false
        //means there is no discount 
        {
            Discount_Percent = "";
        }
    }//the end of the method 

    //Customer_Basket the information dtored in it like that :
    //product name*0 ..... product ID1.....description* 2.......quantity* 3......Total price*4
    /**
     * This method will print the bill for the customer include all the
     * important information in the bill date and day (it will get from the date
     * object that is in the Shop_Menu class (by the toString method cause of we
     * need the return to be String so we can sub string the day and the date
     * each one will be individual Also it will contain the products in the
     * basket (name ,description, quantity as the customer wants and the total
     * price) in this method we will assign a reference to the reference
     * variable of type basket so we can deal with the same basket of the
     * customer
     *
     * @param customer_Basket
     */
    public void getBill(Basket customer_Basket) {
        System.out.println();
        this.customer_Basket = customer_Basket;
        System.out.println("* * * * * * * * * * *");
        System.out.println("*      INVOICE      *");
        System.out.println("* * * * * * * * * * *");
        System.out.println();//formating for bill
        System.out.printf("%40s%n", "***** Bill Number *****");
        System.out.printf("%-25S%s%n", " ", getBill_Number());
        System.out.println();//formating for bill
        System.out.printf("%s%s", "Date:", Shop_Menu.getPeriod_Of_Descount().toString()
                .substring(0, 10).concat(Shop_Menu.getPeriod_Of_Descount().toString()
                .substring(23)));
        System.out.printf("     %5s%s%n", "Time", Shop_Menu.getPeriod_Of_Descount().toString()
                .substring(10, 19));
        /*
        Shop_Menu.getPeriod_Of_Descount().toString().substring(0,4) means we 
        will get the object of the date from Shop_Menu class by get method
        then we will call the toString method cause of we want to take part of 
        the return ( the object of type date return the name of the day 
        the month the number of the day ,the time and the year.
        we will take the part of the (name of the day,the month the number of 
        the day and the year)
        Shop_Menu.getPeriod_Of_Descount().toString().substring(24))
        to get the year cause of it the end of the return 
        it will be joined with the first part via .concat(n:String)method
         */

        System.out.println("___________________________________________________________________________");//formating for bill
        System.out.printf("%-20S%-20S%-20S%-20S%n", "item name", "description", "quantity", "total price");//formating for bill
        System.out.println("___________________________________________________________________________");//formating for bill

        /*
         using for each loop to print the products information from the customer basket
         that will be accessed by the basket object in the bill class(aggregation relationship)
         */
        //it will take row by row in the 2D array and print form it the useful information in the bill
        outer:
        for (int index_row = 0; index_row < this.customer_Basket.getLast_item_Index() + 1; index_row++) {
            inner:
            for (int index_column = 0; index_column < 5; index_column++) {
                if (!(this.customer_Basket.getCustomer_Basket()[index_row][index_column].equals(""))) {
                    if (index_column != 4 && index_column != 1) {
                        System.out.print(this.customer_Basket.getCustomer_Basket()[index_row][index_column] + "      ");
                    } //the end of the if block 
                    else if (index_column == 1) {
                        continue;
                    }//the end of the else block 
                    else //index2==4
                    {
                        System.out.printf("%.2f%6s%n", Double.valueOf(this.customer_Basket.getCustomer_Basket()[index_row][index_column]), " ");
                    }//the end of the else block 
                }//the end of the if statament 
                else {
                    continue outer;
                }
            }//the end of the for loop outer
        }//the end of the outer for loop     
        //Printing information of the prices ....
        setTotal_Price();//call the method so the Total price assign a value 
        System.out.println("___________________________________________________________________________");//formating 
        System.out.printf("%s%2$.2f%n", "Total Price ", Total_Price);
        System.out.printf("%s%2$.2f%n", "Shipping price ", getSHIPMENT_PRICE());
        System.out.printf("%s%2$.2f%n", "Tax Price ", TAX_PRICE);
        System.out.println("Discount Range " + getDiscount_Price());
        System.out.println("_________________________________________________________________________");//formating

        BillCreated = true;//the bill is created 
        System.out.println();
        System.out.println();
        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        java.util.Random random = new java.util.Random();

        // specify length of random string
        int length = 5;

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();

        System.out.println("        - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("       |         * * *     * * *    * * * * *          |");
        System.out.println("       |       *           *            *              |");
        System.out.println("       |       *   * *     * * *        *              |");
        System.out.println("       |       *      *    *            *              |");
        System.out.println("       |        * * *      * * *        *              |");
        System.out.println("       |                                               |");
        System.out.println("       |                                               |");

        System.out.println("       |         *     * * * *   * * *     *           |");
        System.out.println("       |       * *     *     *   *   *    *            |");
        System.out.println("       |         *     *     *   * * *   *   * * *     |");
        System.out.println("       |         *     *     *          *    *   *     |");
        System.out.println("       |         *     * * * *         *     * * *     |");

        System.out.println("       |                                               |");
        System.out.println("       |        * * * *     * * * *  * * * *           |");
        System.out.println("       |        *     *     *        *                 |");
        System.out.println("       |        *     *     * * *    * * *             |");
        System.out.println("       |        *     *     *        *                 |");
        System.out.println("       |        * * * *     *        *                 |");
        System.out.println("       |                                               |");
        System.out.println("       |       We give you a gift of 10% off           |");
        System.out.println("       |  that you can use on your next purchase!      |");
        System.out.println("       |    We really hope you'll be back soon!        |");
        System.out.println("       | _____________________________________________ |");
        System.out.println("       |                                               |");
        System.out.println("       |              THE CODE : " + randomString + "               |");
        System.out.println("       |                                               |");
        System.out.println("        - - - - - - - - - - - - - - - - - - - - - - - - ");

    }//the end of the method

//getter method 
    /**
     *
     * @return BillCreated
     */
    public boolean getBillCreated() {
        return BillCreated;
    }//the end of the method 

}//the end of the class 
