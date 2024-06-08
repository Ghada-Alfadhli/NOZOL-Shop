/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package householdd;


/**
 * This class is a type of item from Light_Category (Chandelier_Items) it will
 * create object from this class depend on the choice of the customer (in the
 * main ) ..This class will have a relation with the Basket class we give an
 * address to the reference variable in the parent class
 *
 * @version 1.0
 */

public class Chandelier_Items  extends Light_Category {

    /**
     * This static final field will hold the Chandelier_Item_information of each
     * product (product ID ,product name ,quantity that available‏ of the
     * product)...
     */
    public static final String[][] Chandelier_Item_information
            //by default each product will have item id = 0 
            ={{"0","Classis", "gold with cristels 100cm ", "5", "500"},
            {"0","Bohemian",  "Silver 50 cm ", "5", "280"},
            {"0","Crystal", "gold 100cm  ", "5", "500"},
            {"0","Modern", "Silver 50 cm ", "5", "280"}};

    //Constructor...
    /**
     * This constructor will assign special item id for each product in the 2D
     * array (Chandelier_Item_information[][]) by using the (item_ID)field that 
     * is in the Product abstract Class and then it will joined with the 
     * category id ( abstract class )also joined with the section ID (interface )... 
     */
    public Chandelier_Items() 
    {
        for (int index=0;index<Chandelier_Item_information.length;index++)
        {
            item_ID = "" + (Integer.parseInt(item_ID.replaceAll("[^0-9]", "")) + 1);
            Chandelier_Item_information[index][0]=item_ID+CATEGORY_ID;
        }//the end of the for loop 
    }

    
    /**
     *will give a value for the reference variable of the Basket class the
     * address of the object of type Basket  will be assigned by reference
     * @param Customer_Basket
     */
    public Chandelier_Items(Basket Customer_Basket) {
        Basket_Of_Customer=Customer_Basket;
    }//the end of the mehtod 

    /**
     * This method will print the Chandelier items information and check the
     * period of discount and change the price of the products depend on the
     * discount it will print the new price to the customer ( the price in the
     * 2D array will be not change it is the original price  )...
     */
    @Override
    public void Item_Menu_New_Price() {
     System.out.println("          __________CHANDELIER ITEMS__________");
        if (Shop_Menu.getFound_Discount() == true)
{
    for (int index_row=0;index_row<Chandelier_Item_information.length;index_row++)
    {
        for (int index_column=0;index_column<Chandelier_Item_information[index_row].length;index_column++)
        {
            if (index_column==3)continue;
            if (index_column!=3||index_column!=4)
            System.out.printf("%10s%s%n"," ",Chandelier_Item_information[index_row][index_column]);
            if (index_column==4)
            {
                switch(Shop_Menu.getRange_Discount())
                {
                    case 1:
                         System.out.printf("%1$10s%.2f%n"," ",(Integer.valueOf(Chandelier_Item_information[index_row][index_column]) * 0.20), "         ");
                         break;
                    case 2:
                         if (index_row == 0) {
                                    System.out.printf("%1$10s%.2f%n", " ",(Integer.valueOf(Chandelier_Item_information[index_row][index_column]) * 0.20), "         ");
                                }//the end of the if  
                                else if (index_row == 1 || index_row == 2) {
                                    System.out.printf("%10s%.2f%n"," ",(Integer.valueOf(Chandelier_Item_information[index_row][index_column]) * 0.25), "         ");
                                }//the end of the if 
                                else {
                                    System.out.printf("%10s%.2f%n"," ",(Integer.valueOf(Chandelier_Item_information[index_row][index_column]) * 0.30), "         ");
                                }//the end of the else block 
                         break;
                    case 3:
                         if (index_row == 0) {
                                    System.out.printf("%10s%.2f%n"," ",(Integer.valueOf(Chandelier_Item_information[index_row][index_column]) * 0.50), "         ");
                                }//the end of the if 
                                else if (index_row == 1 || index_row == 2) {
                                    System.out.printf("%10s%.2f%n"," ", (Integer.valueOf(Chandelier_Item_information[index_row][index_column]) * 0.60), "         ");
                                } //the end of the if 
                                else {
                                    System.out.printf("%10s%.2f%n"," ",(Integer.valueOf(Chandelier_Item_information[index_row][index_column]) * 0.70), "         ");
                                }//the end of the else 
                         break;
                    case 4:
                        System.out.printf("%10s%.2f%n"," ", (Integer.valueOf(Chandelier_Item_information[index_row][index_column]) * 0.50), "         ");
                        break;
                    default: 
                        System.out.printf("%10s%.2f%n"," ",(Integer.valueOf(Chandelier_Item_information[index_row][index_column])));
                        break;
                }//the end of the switch block 
            }//the end of the if statement 
        }//the end of the inner for loop 
                System.out.println("          ____________________________________");
    }//the end of the inner for loop 
    System.out.println();
}//the end of the ouetr for loop statement 
    }//the end of the method 

    /**
     * This method will add item to the customer_Basket that is in the Basket
     * Class accessed it by the object Basket_Of_Customer ( that is inherited
     * from product abstract class- multilevel inheritance‏) First it will 
     * check if the product exist in the basket or not ,if it exist it will just
     * increase the quantity  Before add item to the basket it will check if the
     * item in stock or not by (quantity of the
     * item - quantity that customer wants ) then a conditions will performed,
     * if the customer choose all the quantity that is available‏ the value of
     * this item in the information 2D array will be changed to "0"means out of stock 
     * @param name_of_item
     * @param quantity_of_item
     */
    @Override
    public void Add_Item(String name_of_item, int quantity_of_item) {
       boolean found =false;//assume that the name_of_item not duplicated
         int indexOfProduct=0;
         int total_Quantity=0;
        if (Basket_Of_Customer.getLast_item_Index()!=-1)
        {
            for (int i=0;i<Basket_Of_Customer.getLast_item_Index() + 1;i++)
            {
                if (Basket_Of_Customer.Customer_Basket[i][0].equalsIgnoreCase(name_of_item))
                {
                    /*
                    This for loop to store the index of the product ( in the 2D array)
                    */
                    for (int i1=0;i1<Chandelier_Item_information.length;i1++)
                    {
                        if (Chandelier_Item_information[i1][1].equalsIgnoreCase(name_of_item))
                        {
                            indexOfProduct=i1;//store the index of the product 
                            total_Quantity=(Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)));
                        }//the end of the if statement
                    }//the end of the for loop 
                    
                    /*
                    we found that the product is already in the basket 
                    so first the value of found will be change to true 
                    then it will add the value of (quantity_of_item) to the value 
                    that stired in the column quantity ( after substraing - to
                    remove the symbol X - and converting String to an integar )
                    so we can add then normally..
                    also we will change the price we will multiply the quantity 
                    by (quantity_of_item)
                    */
                    found=true;
                     if (!Chandelier_Item_information[indexOfProduct][3].equalsIgnoreCase("0")) {
                        if ((Integer.valueOf(Chandelier_Item_information[indexOfProduct][3])-quantity_of_item) >= 0) {

                            Basket_Of_Customer.Customer_Basket[i][3] = "X" +(total_Quantity+quantity_of_item);

                            switch (Shop_Menu.getRange_Discount()) {
                                case 1://20%
                                    Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.20)) + "";
                                    break;
                                case 2://20 %-30%
                                    switch (i) {
                                        case 0:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.20)) + "";
                                            break;
                                        case 1:
                                        case 2:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.25)) + "";
                                            break;
                                        case 3:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.30)) + "";
                                            break;
                                        default:
                                            break;
                                    }//the end of the switch block 
                                    break;
                                case 3://50 -70 
                                    switch (i) {
                                        case 0:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.50)) + "";
                                            break;
                                        case 1:
                                        case 2:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.60)) + "";
                                            break;
                                        case 3:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.70)) + "";
                                            break;
                                        default:
                                            break;
                                    }//the end of the switch block 
                                    break;
                                case 4://50 %
                                    Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.50)) + "";
                                    break;
                                default://there is no discount it will deal with the price 
                                    //that stored in the 2D array (original price)
                                    Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Chandelier_Item_information[i][4].substring(1)) * Integer.valueOf(Basket_Of_Customer.Customer_Basket[indexOfProduct][3])) + "";
                                    break;
                            }//the end of the switch 
                            //+"" to convert the number to String 

                        }//the end of the inner if
                        else if ((Integer.valueOf(Chandelier_Item_information[indexOfProduct][3])-quantity_of_item) == 0) {
                        Basket_Of_Customer.Customer_Basket[i][3] = "X" + (total_Quantity+quantity_of_item);

                            switch (Shop_Menu.getRange_Discount()) {
                                case 1://20%
                                    Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.20)) + "";
                                    break;
                                case 2://20 %-30%
                                    switch (i) {
                                        case 0:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.20)) + "";
                                            break;
                                        case 1:
                                        case 2:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.25)) + "";
                                            break;
                                        case 3:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.30)) + "";
                                            break;
                                        default:
                                            break;
                                    }//the end of the switch block 
                                    break;
                                case 3://50 -70 
                                    switch (i) {
                                        case 0:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.50)) + "";
                                            break;
                                        case 1:
                                        case 2:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.60)) + "";
                                            break;
                                        case 3:
                                            Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.70)) + "";
                                            break;
                                        default:
                                            break;
                                    }//the end of the switch block 
                                    break;
                                case 4://50 %
                                    Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Basket_Of_Customer.Customer_Basket[i][3].substring(1)) * (Integer.valueOf(Chandelier_Item_information[indexOfProduct][4]) * 0.50)) + "";
                                    break;
                                default://there is no discount it will deal with the price 
                                    //that stored in the 2D array (original price)
                                    Basket_Of_Customer.Customer_Basket[i][4] = (Integer.valueOf(Chandelier_Item_information[i][4].substring(1)) * Integer.valueOf(Basket_Of_Customer.Customer_Basket[indexOfProduct][3])) + "";
                                    break;
                            }//the end of the switch 
                            //+"" to convert the number to String
                    }//the end of else
                        else 
                        {
                            System.out.println("Not enough in the store ");
                            System.out.println();
                        }//the end of the else block 
                        
                    }//the end of the if statament
                     else 
                         System.out.println("Out of stock");
                     System.out.println();
                }//the end of the inner if  
            }//the end of the for loop
        }//the end of if 
        
        if (!found)
        {     
        int index_of_item= 0;//this variable will store the index of the product row that the customer choose 
        int quantity =0;//the we have 
        for (int index = 0; index < Chandelier_Item_information.length; index++) {
            //convert the value the store for each product in the quantity column to String 
            //check if the customer enter a correct product name 
            if (name_of_item.equalsIgnoreCase(Chandelier_Item_information[index][1])) 
            {
                index_of_item = index;//store the index of product row 
                quantity = Integer.valueOf(Chandelier_Item_information[index_of_item][3]);
                break;//go out of the loop 
            }//the end of the if statement 
        }//the end of the for loop
        
        if (!Chandelier_Item_information[index_of_item][3].equalsIgnoreCase("0"))
        {   if ((quantity-quantity_of_item) > 0) {//when it is +
            
                    /*
                        the value of the quantity product will be decresed
                        based on the quantity that the customer want 
                    */
                    Chandelier_Item_information[index_of_item][3] = (quantity - quantity_of_item) + "";
                    //name ID description quantity price customer 
                    //ID name description quantitty price
                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][0] = name_of_item;//name
                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][1] = Chandelier_Item_information[index_of_item][0];//prodect id
                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][2] = Chandelier_Item_information[index_of_item][2];  //prodect description
                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][3] = "X" + quantity_of_item;
                    
                    /*
                    In this switch block we will check the range of the discount
                    and it will applied on the price of the product before
                    multily it by the quantity that the customer wants 
                    */
                    switch(Shop_Menu.getRange_Discount())
                    {
                        case 1://20%
                             Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.20))+"";
                            break;
                        case 2://20 %-30%
                            switch(index_of_item)
                            {
                                case 0:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.20))+"";
                                break;
                                case 1:
                                case 2:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.25))+"";
                                    break;
                                case 3:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.30))+"";
                                    break;
                                default :
                                    break;
                            }//the end of the switch block 
                            break;
                        case 3://50 -70 
                            switch(index_of_item)
                            {
                                case 0:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.50))+"";
                                break;
                                case 1:
                                case 2:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.60))+"";
                                    break;
                                case 3:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.70))+"";
                                    break;
                                default :
                                    break;
                            }//the end of the switch block 
                            break;
                        case 4://50 %
                         Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.50))+"";
                            break;
                        default ://there is no discount it will deal with the price 
                            //that stored in the 2D array (original price)
                            Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(Integer.valueOf(Chandelier_Item_information[index_of_item][4])*quantity_of_item)+"";
                            break; 
                    }//the end of the switch 
                   
                 Basket_Of_Customer.setLast_item_Index(Basket_Of_Customer.getLast_item_Index() + 1);
                 //update the value of the last index 
         
                }//the end of te if block 
                else if ((quantity - quantity_of_item) == 0) {
                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][0] = name_of_item;//name
                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][1] = Chandelier_Item_information[index_of_item][0];//prodect id
                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][2] = Chandelier_Item_information[index_of_item][2];  //prodect description
                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][3] = "X" + quantity_of_item;
                    System.out.println(Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][3]);
                   switch(Shop_Menu.getRange_Discount())
                    {
                        case 1://20%
                             Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.20))+"";
                            break;
                        case 2://20 %-30%
                            switch(index_of_item)
                            {
                                case 0:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.20))+"";
                                break;
                                case 1:
                                case 2:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.25))+"";
                                    break;
                                case 3:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.30))+"";
                                    break;
                                default :
                                    break;
                            }//the end of the switch block 
                            break;
                        case 3://50 -70 
                            switch(index_of_item)
                            {
                                case 0:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.50))+"";
                                break;
                                case 1:
                                case 2:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.60))+"";
                                    break;
                                case 3:
                                    Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.70))+"";
                                    break;
                                default :
                                    break;
                            }//the end of the switch block 
                            break;
                        case 4://50 %
                         Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(quantity_of_item * (Integer.valueOf(Chandelier_Item_information[index_of_item][4])*0.50))+"";
                            break;
                            default ://there is no discount it will deal with the price 
                            //that stored in the 2D array (original price)
                            Basket_Of_Customer.Customer_Basket[Basket_Of_Customer.getLast_item_Index() + 1][4] =(Integer.valueOf(Chandelier_Item_information[index_of_item][4])*quantity_of_item)+"";
                            break; 
                    }//the end of the switch 
                    Chandelier_Item_information[index_of_item][3] = "0";//means outof stock 
                    Basket_Of_Customer.setLast_item_Index(Basket_Of_Customer.getLast_item_Index() + 1);
                    //update the value of the last index 
                }//end if 
                else if (quantity==0){//2 -3 
                   Chandelier_Item_information[index_of_item][3] = "0";
                   System.out.println("The product is out stock");
                }//the end of else
                else //minus equal negative 
                {
                    System.out.println("The product is not enough in the store ");
                }//the end of the else block 
        }//the end of the outer if statement 
        }//the end of the outer if statement(!found)
            }// the end of the method 
   
    
}//the end of the class 
