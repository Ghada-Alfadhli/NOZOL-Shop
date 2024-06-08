package householdd;

import java.util.Date;//create date from Date class 

/**
 * This class will show the Categories Menu to the customer ,it also enables
 * customers to search for an specific item.
 *
 * @version 1.0
 */
public class Shop_Menu {

    //Data members...
    /**
     * This instance static Array will holds all the category of the shop.
     */
    private static String Category_List[][] = {
        {"Accessories", "Vases", "Paintings"},
        {"Lights", "office lightings", "Chandeliers"}};

    /**
     * This instance static object of the Date class will check the period of
     * discount.
     */
    private static Date Period_Of_Descount = new Date();

    /**
     * The value of this instance field will be true if the period is correct.
     */
    private static boolean Found_Discount;

    /**
     * This instance field will specific three period for discount.
     */
    private static int Range_Discount;

    /**
     * This instance field will hold the value of discount for each period.
     */
    private static String value_of_discount;

    //constrctur...
    /**
     *
     */
    public Shop_Menu() {
    }
    //Methods...

    /**
     * This static method to return the value of discount.
     *
     * @return String
     */
    public static String getValue_of_discount() {
        return value_of_discount;
    }

    /**
     * This static method to return the period of discount.
     *
     * @return Date
     */
    public static Date getPeriod_Of_Descount() {
        return Period_Of_Descount;
    }

    /**
     * This instance method to return if there is a discount or not in specific
     * period.
     *
     * @return Found_Discount
     */
    public static boolean getFound_Discount() {
        return Found_Discount;
    }

    /**
     * This instance method to return the range of discount.
     *
     * @return int
     */
    public static int getRange_Discount() {
        return Range_Discount;
    }

    /**
     * This static method to show Categories_Menu..
     */
    public static void Categories_Menu() {
        System.out.println("       **____ Shop Menu ____**");
        System.out.println("__________________________________");
        System.out.println(Category_List[0][0]);
        System.out.printf("%5s%-35s%n", " ", ("-" + Category_List[0][1]));
        System.out.printf("%5s%-35s%n", " ", ("-" + Category_List[0][2]));
        System.out.println();
        System.out.println(Category_List[1][0]);
        System.out.printf("%5s%-35s%n", " ", ("-" + Category_List[1][1]));
        System.out.printf("%5s%-35s%n", " ", ("-" + Category_List[1][2]));
        System.out.println("__________________________________");
    }//The end of the method

    /**
     * This static method (utility method) to Check if there is a Discount or
     * not..
     */
    public static void Check_Discount() {

        if (Period_Of_Descount.getDay() >= 19 && Period_Of_Descount.getDay() <= 24 && Period_Of_Descount.getMonth() == 9) {
            Found_Discount = true;
            Range_Discount = 1;
            value_of_discount = "20%";
        } else if (Period_Of_Descount.getDay() >= 15 && Period_Of_Descount.getDay() <= 25 && Period_Of_Descount.getMonth() == 9) {
            Found_Discount = true;
            Range_Discount = 2;
            value_of_discount = "20%-30%";//20 25 30 
        } else if (Period_Of_Descount.getDay() >= 15 && Period_Of_Descount.getDay() <= 31 && Period_Of_Descount.getMonth() == 3 || Period_Of_Descount.getDay() == 1 && Period_Of_Descount.getDay() <= 3 && Period_Of_Descount.getMonth() == 4) {

            Found_Discount = true;
            Range_Discount = 3;
            value_of_discount = "50%-70%";
        } else if (Period_Of_Descount.getDay() == 12 && Period_Of_Descount.getDay() <= 30 && Period_Of_Descount.getMonth() == 4) {

        }
        Found_Discount = true;
        Range_Discount = 4;
        value_of_discount = "50%";

        System.out.println();//new line 
        if (Found_Discount) {
            switch (Range_Discount) {
                case 1://saudi national day 
                    System.out.println("_________________________________________________________________________________________________________________________________________");
                    System.out.println("                                        * * * * *   * * * * *     * * *       *       ");
                    System.out.println("                                                *   *       *     *   *      *        ");
                    System.out.println("                                                *   *       *     * * *     *         ");
                    System.out.println("                                        * * * * *   *       *              *          ");
                    System.out.println("                                        *           *       *             *     * * * ");
                    System.out.println("                                        *           *       *            *      *   *  SAUDI NATIONAL DAY");
                    System.out.println("                                        * * * * *   * * * * *           *       * * *  DISCOUNT ");
                    System.out.println("_________________________________________________________________________________________________________________________________________");
                    break;
                case 2://saudi foundation day 
                    System.out.println("_________________________________________________________________________________________________________________________________________");
                    System.out.println("* * * * *   * * * * *     * * *       *                              * * * * *   * * * * *     * * *       *     ");
                    System.out.println("*       *   *       *     *   *      *                                       *   *       *     *   *      *      ");
                    System.out.println("*       *   *       *     * * *     *          SAUDI FOUNDATION DAY          *   *       *     * * *     *       ");
                    System.out.println("* * * * *   *       *              *             ****************    * * * * *   *       *              *         ");
                    System.out.println("*           *       *             *     * * *        DISCOUNT                *   *       *             *     * * *");
                    System.out.println("*           *       *            *      *   *                                *   *       *            *      *   *");
                    System.out.println("* * * * *   * * * * *           *       * * *                        * * * * *   * * * * *           *       * * *   ");
                    System.out.println("_________________________________________________________________________________________________________________________________________");
                    break;
                case 3://Ramadan 
                    System.out.println("_________________________________________________________________________________________________________________________________________");
                    System.out.println("                                        * * * * *   * * * * *     * * *       *                            * * * * * *         * * * * *     * * *       *    ");
                    System.out.println("                                        *           *       *     *   *      *                             *         *         *       *     *   *      *     ");
                    System.out.println("                                        *           *       *     * * *     *                              *         *         *       *     * * *     *      ");
                    System.out.println("                                        * * * * *   *       *              *                 RAMADAN                 *         *       *              *       ");
                    System.out.println("                                                *   *       *             *     * * *    ****************            *         *       *             *     * * * ");
                    System.out.println("                                                *   *       *            *      *   *        DISCOUNT                *         *       *            *      *   * ");
                    System.out.println("                                        * * * * *   * * * * *           *       * * *                                *         * * * * *           *       * * *   ");
                    System.out.println("_________________________________________________________________________________________________________________________________________");
                    break;
                case 4://Eid 
                    System.out.println("_________________________________________________________________________________________________________________________________________");
                    System.out.println("                                        * * * * *   * * * * *     * * *       *       ");
                    System.out.println("                                        *           *       *     *   *      *        ");
                    System.out.println("                                        *           *       *     * * *     *         ");
                    System.out.println("                                        * * * * *   *       *              *          ");
                    System.out.println("                                                *   *       *             *     * * * ");
                    System.out.println("                                                *   *       *            *      *   * EID ");
                    System.out.println("                                        * * * * *   * * * * *           *       * * * DISCOUNT ");
                    System.out.println("_________________________________________________________________________________________________________________________________________");
                    break;
                default:
                    System.out.println("_________________________________________________________________________________________________________________________________________");
                    System.out.println("  *        *   * * * *   *               *       * * * * *      *        *          * * * *    * * * * *         * * * * *    * * * * *   * * * * * * * * * *  *   *        *   * * * * * *        ");
                    System.out.println("  * *      *   *          *             *        *            *   *      *          *          *                 *            *       *   *        *        *  *   *  *     *   *              ");
                    System.out.println("  *    *   *   * * * *     *     *     *         * * * * *   * * * *     *          * * * *    * * * * *         *            *       *   *        *        *  *   *    *   *   *   * * * *   ");
                    System.out.println("  *      * *   *            *  *   *  *                  *  *       *    *          *                  *         *            *       *   *        *        *  *   *      * *   *         *    ");
                    System.out.println("  *        *   * * * *       *       *           * * * * * *         *   * * * * *  * * * *    * * * * *         * * * * *    * * * * *   *        *        *  *   *        *   * * * * * *     ");
                    System.out.println("_________________________________________________________________________________________________________________________________________");
                    System.out.println();
                    break;
            }

        }// the end of Switch case
        System.out.println();//new line
        System.out.println();//new line 
    }//The end of the method

    /**
     * This instance method to enables the customer search for specific item
     *
     * @param item
     */
    public void Search_item(String item) {
        for (int i = 0; i < Category_List.length; i++) {
            for (int j = 0; j < Category_List[i].length; j++) {
                if (item.equalsIgnoreCase("vases") | item.equalsIgnoreCase("paintings") | item.equalsIgnoreCase("office lightings") | item.equalsIgnoreCase("Chandeliers")) {
                    Categories_Menu();
                } //the end of the if block 
                else {
                    System.out.println(item + "is not found");
                }//the end of the else block 
            }//the end of the inner for loop 
        }//the end of the outer for loop
    }//The end of the method

}//the end of the class 
