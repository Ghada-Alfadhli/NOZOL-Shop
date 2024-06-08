package householdd;

import java.util.*;

/**
 * The Driver Program ...
 */
public class HouseHoldd {

    static Scanner read = new Scanner(System.in);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        /*
        We will create an objects of each item class ( Paintings_Items,
        Chandelier_Items ,vases_Items and OfficeLighting_Items ) by default 
        constructor so we can assign a ID for each product ( with special 
        techniqe)with specific technique 
         */
        Paintings_Items m1 = new Paintings_Items();
        Vases_Items m2 = new Vases_Items();
        Chandelier_Items m3 = new Chandelier_Items();
        OfficeLighting_Items m4 = new OfficeLighting_Items();

        //من هذا الكلاس راح نكون حسابات للعملاء مع كل حساب يتكون اوبجيكت من البل واوبجيكت من الباكست  
        //الوصول لهم عن طريق اوبجيكت الاكاونت 
        //راح نعرض له منيو يختار يا حساب جديد او تسجيل دخول بناء على قراءه اختيار العميل     
        //يتم ادخال البيانات وفق شروط ولازم المدخل موافق لها 
        // بعدها راح تتنفذ ميثود من خلالها راح نعرض منيو الفئات المتوفره 
        //راح  نقرا اختيار العمي اختياره اختياره يكون للمنتجات وليس الفئات  
        //we create refernce variable of type product 
        // switch 
        //في كل كيس نكون اوبجيكت من اتيم معين 
        //after that we will have if else ( instance of )
        //بناء على اختياره نعرض المنيو لهذا الاتيم 
        //بعد كل اضافه اتيم راح تتنفذ ميثود موجوده في الباسكيت كلاس 
        //بناء على اختياره 
        Account c[] = new Account[5];//create array of type Account length 2 
        for (int i = 0; i < c.length; i++) {

            //Task 1:...
            c[i] = new Account();//first customer 
            String Line;
            if (i != 0) {
                Line = read.nextLine();
            }
            System.out.println();
            //to read next line it cause a problem when we read the next customer 
            //choice 

            //a menu will be shown to the customer (log in and sign up )
            String choice = read.nextLine().toUpperCase().trim();
            System.out.println();//new line 
            System.out.println();//new line 
            /*
        read the customer choice and convert it to upper case 
        if the customer did not chose something from the menu
        the method of sign up will be performed 
             */

            c[i].setChoice(choice);//set the value to the choice field

            c[i].Cutomer_Choice();
            if (c[i].isLogIn() == true && c[i].getCustomer_Bill().getBillCreated() == false) {
                if (i != 0) {
                    for (int index = 0; index < i; index++) {
                        if (c[i].getCustomer_address().getPassword().equals(c[index].getPassword())) {
                            c[i] = c[index];
                        }//the end of the if statement 
                    }
                }//the end of the if statement

                if (c[i].getCustomer_Basket().getCustomer_Basket()[0][0] != null) {
                    c[i].getCustomer_Basket().Show_Basket();//1
                    //show basket to the customer before the customer delete items from it 
                    //int c1=c[i].getCustomer_Basket().getLast_item_Index();
                    //c[i].getCustomer_Basket().setLast_item_Index(c1--);
                    System.out.println("Do you want to delete item from the basket (y or n)? ");
                    char answer = read.next().toLowerCase().charAt(0);
                    if (answer == 'y') {
                        System.out.println("How many items ? ");
                        int num_remove = read.nextInt();
                        for (int a = 1; a <= num_remove; a++) {
                            System.out.print("Item: ");
                            String name = read.next();
                            System.out.println();
                            System.out.print("Quantity:");
                            int quantity_remove = read.nextInt();
                            System.out.println();
                            c[i].getCustomer_Basket().Remove_Item(name, quantity_remove);
                        }//the end of the for loop
                    }//the end of the if statement
                    c[i].getCustomer_Basket().Show_Basket();//show basket to the customer 
                    c[i].getCustomer_Bill().getBill(c[i].getCustomer_Basket());
                    for (int index1 = 0; index1 < c[i].getCustomer_Basket().getLast_item_Index(); index1++) {
                        for (int index2 = 0; index2 < 5; index2++) {
                            c[i].getCustomer_Basket().getCustomer_Basket()[index1][index2] = null;
                        }//the end of the inner loop 
                    }//the end of the outer for loop

                    //we will need to update the value of the Last_index_item
                    c[i].getCustomer_Basket().setLast_item_Index(-1);
                }//the end of the block 
                else {
                    System.out.println("Your basket is empty....");
                }//the end of the else block

            }//the end of the if statement
            else //sign up
            {
                /*
            depend on the choice of the customer this method will perform 
            the appropiate method either  log_In() or sign_Up()
                 */
                System.out.println();//new line
                System.out.println();//new line

                //Task 2:...
                Account.Show_Menu();
                /*
            This static method will show the 2 categories and 2 items of each one 
                 */
                System.out.println();
                System.out.println();
                System.out.print("# Please Choose Item From the List: ");
                //String line=read.nextLine();
                String customer_request = read.nextLine().toLowerCase().trim();
                System.out.println();
                while (!(customer_request.equalsIgnoreCase("chandeliers") || customer_request.equalsIgnoreCase("office lightings") || customer_request.equalsIgnoreCase("paintings") || customer_request.equalsIgnoreCase("Vases"))) {
                    /*
            This while loop will check if the customer chose from the list or 
            not ... while the customer did not chose anything from the list 
            an appropiate message will be printed ..
                     */
                    System.out.print("Not Found!!Please Choose Item From the List");
                    customer_request = read.nextLine().toLowerCase();
                    System.out.println();
                }//the end of the while loop

                Product n = null;//polymorphism
                //نكون اوبجيكت من كلاس الاب ومن خلال السويتش راح نخليه ياشر علو اوبجيكت من نوع احد الاتيمز 

                /*
        from the switch block we will let the refernce variable of type Product
        refer to an object of (Chandelier ,Office Lighting,Paintings or Vases)
        each item class will take a parameter in the constructor which is object 
        of type Basket (it passed the object Basket which in the Account object 
        via get method )
                 */
                switch (customer_request) {
                    case "chandeliers":
                        n = new Chandelier_Items(c[i].getCustomer_Basket());

                        break;
                    case "office lightings":
                        n = new OfficeLighting_Items(c[i].getCustomer_Basket());

                        break;
                    case "paintings":
                        n = new Paintings_Items(c[i].getCustomer_Basket());

                        break;
                    case "vases":
                        n = new Vases_Items(c[i].getCustomer_Basket());

                        break;
                    default:
                        break;
                }//the end of the switch block 
                /*
            بناء على الاوبجيكت اللي ياشرعليه المتغير راح نستخدم انستينس اوف اوبيراتير
     من خلالها راح نعرض المنيو لهذا الاتيم الذي تم اختياره       
           nested if - else    
                 */
                Shop_Menu.Check_Discount();
                /*
            we have to call this static method from the Shop Menu Class 
            so to check if there is discount or not and this price will applied in the 
            prices of the products ....
                 */

                //Task 3:......
                if (n instanceof Chandelier_Items) {
                    n.Item_Menu_New_Price();
                    //show menu of the Chandelier_Items products
                }//the en of the if statement 
                else if (n instanceof OfficeLighting_Items) {
                    n.Item_Menu_New_Price();
                    //show menu of the OfficeLighting_Items products
                }//the end of the else block 
                else if (n instanceof Paintings_Items) {
                    n.Item_Menu_New_Price();
                    //show menu of the Paintings_Items products
                }//the end of the else block 
                else {
                    n.Item_Menu_New_Price();
                    //show menu of the vases products
                }//the end of the else block 

                //Task 4:......
                /*
            After the menu of the choosen item is shown it will read from the customer 
            how many products wants to add to the basket (the basket that passed to the 
            items classes as a parameter )
                 */
                System.out.println();

                System.out.print("    # How many items do you want to add to the basket ? ");
                int num = 0;
                /*
            we use the while loop to check that the customer exactly enter a number not 
            anything else, cause of we don't want the run time error appear to the user 
                 */
                while (!read.hasNextInt())//new thing  
                {
                    System.out.println("Please enter a number");
                    read.next();
                }//the end of the while loop 

                num = read.nextInt();

                System.out.println();//new line 
                for (int a = 1; a <= num; a++) {
                    System.out.println("- Item " + a + "....");
                    System.out.print("Product: ");//enter the name of the product 
                    String product = read.next();
                    System.out.print("Quantity:");
                    int quantity = read.nextInt();
                    System.out.println();
                    n.Add_Item(product, quantity);
                }//the end of the for loop 
                System.out.println();
                Basket.Check_Continues();
                //we will print a menu for the customer 
                //if the customer want to continue or go to the bill
                System.out.print("YOUR CHOICE NUMBER ? ");
                int number = read.nextInt();//read from the user 
                /*
        Depend on the choice of the customer ( If the number was not 2)
        then the cudtomer want to continue shopping (we will allow the shop
        menue to be printed to the customer only 2 times after it the basket will
        be shown no the bill
        The bill will be shown to the customer 
                 */
                System.out.println();
                System.out.println();
                if (Basket.Check_Range(number) != 2) {//continue shopping 
                    /*
        if the customer choose 1 or another number then the categories 
        will be shown another time 
                     */
                    Account.Show_Menu();//it will show the menu another time to the customer 
                    System.out.println();
                    System.out.println();
                    System.out.print("# Please Choose Item From the List:");
                    String line = read.nextLine();
                    String customer_request1 = read.nextLine().toLowerCase().trim();
                    Product n1 = null;//polymorphism

                    switch (customer_request1) {
                        case "chandeliers":
                            n1 = new Chandelier_Items(c[i].getCustomer_Basket());

                            break;
                        case "office lightings":
                            n1 = new OfficeLighting_Items(c[i].getCustomer_Basket());

                            break;
                        case "paintings":
                            n1 = new Paintings_Items(c[i].getCustomer_Basket());

                            break;
                        case "vases":
                            n1 = new Vases_Items(c[i].getCustomer_Basket());

                            break;
                        default:
                            break;
                    }//the end of the switch block 

                    if (n1 instanceof Chandelier_Items) {
                        n1.Item_Menu_New_Price();
                        //show menu of the Chandelier_Items products
                    }//the en of the if statement 
                    else if (n1 instanceof OfficeLighting_Items) {
                        n1.Item_Menu_New_Price();
                        //show menu of the OfficeLighting_Items products
                    }//the end of the else block 
                    else if (n1 instanceof Paintings_Items) {
                        n1.Item_Menu_New_Price();
                        //show menu of the Paintings_Items products
                    }//the end of the else block 
                    else {
                        n1.Item_Menu_New_Price();
                        //show menu of the vases products
                    }//the end of the else block 

                    System.out.println();//new line 

                    System.out.print("    # How many items do you want to add to the basket ? ");
                    int num1 = 0;
                    /*
                we use the while loop to check that the customer exactly enter a number not 
                anything else, cause of we don't want the run time error appear to the user 
                     */
                    while (!read.hasNextInt())//new thing  
                    {
                        System.out.println("Please enter a number");
                        read.next();
                    }//the end of the while loop 
                    num1 = read.nextInt();

                    for (int a = 1; a <= num1; a++) {
                        System.out.println("- Item " + a + "....");
                        System.out.print("Product: ");//enter the name of the product 
                        String product = read.next();
                        System.out.print("Quantity:");
                        int quantity = read.nextInt();
                        System.out.println();
                        n1.Add_Item(product, quantity);
                    }//the end of the for loop 
                    System.out.print("# Do you want to purchase( y or n) ? ");
                    /*
        if the customer enter yes or y then the basket will be shown and 
        the bil,else nothing will be printed 
                     */
                    char answer = read.next().toLowerCase().charAt(0);
                    System.out.println();
                    if (answer == 'y') {
                        System.out.println("______________________________YOUR BASKET______________________________");
                        System.out.println();
                        c[i].getCustomer_Basket().Show_Basket();//show basket to the customer
                        System.out.println("_______________________________________________________________________");
                        System.out.println();
                        System.out.println();
                        c[i].getCustomer_Bill().getBill(c[i].getCustomer_Basket());
                        //the bill will be shown 
                    }//the end of the if statement

                }//the end of the if statment 
                else {
                    System.out.println();
                    System.out.println("______________________________YOUR BASKET______________________________");
                    System.out.println();
                    c[i].getCustomer_Basket().Show_Basket();//show basket to the customer 
                    System.out.println("_______________________________________________________________________");
                    System.out.println();
                    System.out.println();
                    System.out.print("# Do you want to delete item from the basket (y or n)? ");
                    char answer = read.next().toLowerCase().charAt(0);
                    System.out.println();
                    if (answer == 'y') {
                        System.out.print("    #How many items ? ");
                        int num_remove = read.nextInt();
                        System.out.println();
                        for (int a = 1; a <= num_remove; a++) {
                            System.out.print("- Item: ");
                            String name = read.next();
                            System.out.print("- Quantity:");
                            int quantity_remove = read.nextInt();
                            System.out.println();
                            c[i].getCustomer_Basket().Remove_Item(name, quantity_remove);
                        }//the end of the for loop
                    }//the end of the if statement
                    System.out.println("______________________________YOUR BASKET______________________________");
                    System.out.println();
                    c[i].getCustomer_Basket().Show_Basket();//show basket to the customer 
                    System.out.println("_______________________________________________________________________");
                    System.out.println();
                    System.out.println();
                    c[i].getCustomer_Bill().getBill(c[i].getCustomer_Basket());
                    System.out.println();

                    /*
                if the bill is created then the basket will be empty
                by fill it with null 
                     */
                    for (int index1 = 0; index1 < 20; index1++) {
                        for (int index2 = 0; index2 < 5; index2++) {
                            c[i].getCustomer_Basket().getCustomer_Basket()[index1][index2] = null;
                        }//the end of the inner loop 
                    }//the end of the outer for loop

                    //we will need to update the value of the Last_index_item
                    c[i].getCustomer_Basket().setLast_item_Index(-1);
                }//the end of the else block 

            }//the end of the for loop 
            System.out.println();
            System.out.println();
            System.out.println();
        }//the end of the for loop 

    }//the end of the main method 

}//the end of the class 
