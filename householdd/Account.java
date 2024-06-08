package householdd;

import java.util.*;

/**
 * This class will sign up or log in the customer,also will holds the customer
 * accounts and check the validity of the information
 *
 * @version 1.0
 */
public class Account {

    //Data member .....
    /**
     * This static Array List will holds all the customers accounts its can be
     * common for all objects in of Account class ...
     */
    static ArrayList<Customer> Customer_Information = new ArrayList<Customer>();

    /**
     * The value of this instance field will be changed if the customer has the
     * correct information for sign up..
     */
    private boolean SignUp = false;

    /**
     * The value of this instance field will be changed if the customer has the
     * correct log in..
     */
    private boolean LogIn = false;

    /**
     * This instance object of type bill will contain bill information if the
     * customer choose to create bill..
     */
    private Bill Customer_Bill = new Bill();

    /**
     * This instance object of Basket class will holds the products of the
     * customer..
     */
    private Basket Customer_Basket = new Basket();

    /**
     * Create static Scanner object for reading from the user...
     */
    static Scanner read = new Scanner(System.in);

    /**
     * This instance field will store the choice of the customer depend on the
     * menu...
     */
    private String choice;

    /**
     * This instance reference variable will hold the exist address of the
     * customer ...
     */
    private Customer customer_address;

    /**
     * This instance variable will hold the password for the exist address of
     * the customer..
     */
    private String password;

    //Constructor 
    /**
     *
     */
    public Account() {
        System.out.println("*               *     * * * * *      *              * * * * *      * * * * *         *             *         * * * * *       ");
        System.out.println(" *             *      *              *              *       *      *       *         *  *       *  *         *             ");
        System.out.println("  *           *       *              *              *              *       *         *    *   *    *         *          ");
        System.out.println("   *    *    *        * * * * *      *              *              *       *         *      *      *         * * * * *  ");
        System.out.println("    *  * *  *         *              *              *       *      *       *         *             *         *          ");
        System.out.println("     *     *          * * * * *      * * * * *      * * * * *      * * * * *         *             *         * * * * * NOZOL");
        System.out.printf("%80s%n", "-----------------------------------------------------");
        System.out.printf("%66s%n", "   Do you have an account ? LOG IN ... ");
        System.out.printf("%60s%n", "Create an account ? SIGN UP...");
        System.out.printf("%80s%n", "-----------------------------------------------------");
    }//the end of the method

    //Other Methods
    /**
     * This instance method will perform methods based on the choice of the
     * customer...
     */
    public void Cutomer_Choice() {
        switch (choice) {
            case "LOG IN"://تسجيل دخول
                log_In();
                break;
            case "SIGN UP"://حساب جديد 
                sign_Up();
                break;
            default:
                //if the customer did not chose something from the menu
                //the method of sign up will be performed 
                sign_Up();
                break;
        }//the end of the swith 
    }//the end of the method 

    /**
     * This static method (utility method) to check the value SignUp and LogIn
     * if one of them true , the method in the Shop_Menu will be performed
     * Categories_Menu()..
     */
    public static void Show_Menu() {
        Shop_Menu.Categories_Menu();//dependncy relation
    }//the end of the method 

    /**
     * This instance method will be performed if the customer choose (SIGN
     * UP)from the menu and will check if correct (email or user name) and
     * password is entered it is a support method ...
     */
    private void sign_Up() {

        //create object of customer 
        Customer c = new Customer();//create new customer in the application 
        //Read important information from the customer
        System.out.println("                      SIGN UP");
        System.out.println("             ***Create New Account ***");
        System.out.println("___________________________________________________");
        System.out.print("- First name :");
        String first_name = read.next();
        //set the First name in the Customer object via set method 
        c.setFirst_Name(first_name);
        System.out.println();//new line

        System.out.print("- Last name :");
        String last_name = read.next();
        System.out.println();
        //set the Last name in the Customer object via set method 
        c.setLast_Name(last_name);
        //System.out.println();//new line 
        String line = read.nextLine();//to read nextline cause of if it not exist it will cause a problem

        /*
        read email and handle the invalid email... 
        it will not move to the next information until correct email entered
         */
        System.out.print("- Email: ");
        String Email;
        boolean notCorrect = true;//assume that the email not correct 
        boolean containsAt = false;//assume that the email doesn't contain @
        do {
            /*
            cause of to check that the input from the user has ( @ ) 
            if it not exits the index of it will be -1 and this will cause
            a problem ( String Index Out Of Bound Exception )
            so we will make sure that the input is correct ....
             */
            Email = read.nextLine().trim();//read email and remove spaces from the start and the end 
            do {
                try {
                    if (Email.indexOf("@") == -1)//there is no @
                    {
                        throw new StringIndexOutOfBoundsException();
                    }
                    containsAt = true;
                }//the end of the try block 
                catch (Exception e) {
                    System.out.println("SORRY ! WRONG EMAIL....");
                    Email = read.nextLine().trim();
                    System.out.println();
                }//the end of the catch block 
            } while (!containsAt);

            try {
                isValidEmail(Email, "Sign Up");
                notCorrect = false;
                c.setEmail(Email);
            }//the end of the try block 
            catch (InvalidException e) {

                System.out.println(".......................................................");
                System.out.printf("%1$50s%n", (e.getMessage() + " " + e.ValidEmail()));
                System.out.println(".......................................................");
                System.out.println();
                System.out.println("Please!Enter a correct Email ");
            }//the end of the catch block 
        } while (notCorrect);

        System.out.println();//new line

        /*
        read password and handle the invalid password... 
        it will not move to the next information until correct password entered
         */
        System.out.print("- Password: ");
        String password;
        boolean notCorrect1 = true;//assume that the password not correct 
        do {
            password = read.next();
            try {
                isValidPassword_Or_UserName(password, "Password");
                System.out.println("Correct Password ..");
                notCorrect1 = false;
                c.setPassword(password);
                this.password = password;
            }//the end of the try block 
            catch (InvalidException e) {
                System.out.println(".......................................................");
                System.out.printf("%1$50s%n", (e.getMessage() + e.ValidPassword_Or_UserName("Password")));
                //System.out.println(e.ValidPassword_Or_UserName("Password"));
                System.out.println(".......................................................");
                System.out.println();
                System.out.println("Please!Enter a correct password ");
            }//the end of the catch 
        } while (notCorrect1);//the end of the while loop 
        System.out.println();//nextline 
        /*
        read Phone Number and handle the invalid Phone Number... 
        it will not move to the next information until correct Phone Number entered
         */
        System.out.print("- Phone Number:\t +966 ");
        String Phone_Number;
        boolean notCorrect2 = true;//assume that the phone number not correct 
        do {
            Phone_Number = read.next();
            try {
                isValidPhone(Phone_Number);
                notCorrect2 = false;
                c.setPhone_Number(Phone_Number);
            }//the end of the try block 
            catch (InvalidException e) {
                System.out.println(".......................................................");
                System.out.printf("%1$50s%n", (e.getMessage() + e.ValidPhoneNumber()));
                System.out.println(".......................................................");
                System.out.println("Please!Enter a correct phone number ");
                System.out.println();
                System.out.print("+966\t");
            }//the end of the catch  
        } while (notCorrect2);//the end of the while loop 
        System.out.println();
        /*
        read User name and handle the invalid User name... 
        it will not move to the next information until correct User name entered
         */
        System.out.print("- User name:");
        String user_name;
        boolean notCorrect3 = true;//assume that the user name is not correct 
        do {
            user_name = read.next();
            try {
                isValidPassword_Or_UserName(user_name, "User name");
                notCorrect3 = false;
                c.setUser_Name(user_name);
            }//the end of the try block 
            catch (InvalidException e) {
                System.out.println(".......................................................");
                System.out.printf("%1$50s%n", e.getMessage() + e.ValidPassword_Or_UserName("username"));
                System.out.println(".......................................................");
                System.out.println();
                System.out.println("Please!Enter a user name ");
            }//the end of the catch block 
        } while (notCorrect3);//the end of the do while loop 
        System.out.println();//new line

        //the customer can't change the value of the country it will be final 
        System.out.println("- Country: " + c.getCOUNTRY());
        System.out.println();
        /*
        let the customer choose a city from the menu and handle it if the city not exist 
         */
        System.out.println("- City: ");
        Customer.City_Menu();
        String city;
        boolean notInList = true;
        do {
            city = read.next();
            try {
                ExistCity(city);
                notInList = false;
            }//the end of the try block
            catch (InvalidException e) {
                System.out.println(".......................................................");
                System.out.printf("%1$50s%n", (e.getMessage() + e.ValidCity()));
                System.out.println(".......................................................");
                System.out.println();
                System.out.println("Please choose city from the list:  ");
            }//the end of the catch block 
        } while (notInList);//the end of the do while loop 

        //cause of the currency related with the country also it will not be changed by the customer 
        System.out.println("Currency:" + c.getCURRENCY());
        Customer_Information.add(c);//add customer to the array list
        System.out.println("___________________________________________________");
        SignUp = true;//that means the customer succefuly create a new account 
        System.out.println();//new line
        System.out.println();
        System.out.println("__________________________________________");
        System.out.println("|                        **               |");
        System.out.println("|                       **                |");
        System.out.println("|                      **                 |");
        System.out.println("|                 **  **                  |");
        System.out.println("|                   **                    |");
        System.out.println("|    your account created successfuly     |");//approipitae message
        System.out.println("|          WELCOME TO OUR FAMILY          |");
        System.out.println("|_________________________________________|");
    }//the end of the method 

    /**
     * This instance method will check if the information is entered in the
     * correct way and match with the customer account that been saved in the
     * array list it is a support method ..
     */
    private void log_In() {

        //Read user name or Email ....
        String line1 = read.nextLine();//to read nextLine cause of if it not exist it will cause a problem
        System.out.println("                      LOG IN");
        System.out.print("- User name or email: ");
        String email_or_user;
        boolean notCorrect = true;//assume that the email or username not correct
        String the_user_entered = " ";//to know which one has the user entered (email or user name) to catch the invalid input 

        do {
            email_or_user = read.nextLine().trim();
            System.out.println();
            if (email_or_user.contains("@gmail.com") || email_or_user.contains("@hotmail.com")) {
                the_user_entered = "email";
            } else {
                the_user_entered = "user name";
            }
            try {
                if (the_user_entered.equals("email")) {
                    isValidEmail(email_or_user, "Log in");
                    notCorrect = false;
                    the_user_entered = "email";
                }//the end of the if 
                else //it is a user name 
                {
                    isValidPassword_Or_UserName(email_or_user, "User name");
                    notCorrect = false;
                    the_user_entered = "user name";
                }//the end of the else block 
            }//the end of the try block 
            catch (InvalidException e) {
                //catch the email 
                if (the_user_entered.equalsIgnoreCase("email")) {
                    System.out.print(e.getMessage());
                    System.out.println(e.ValidEmail());
                    System.out.println("Please!enter a correct email or username...");
                }//the end of the if statement 
                //catch the user name 
                else {
                    System.out.print(e.getMessage());
                    System.out.println(e.ValidPassword_Or_UserName("User Name"));
                    System.out.println("Please!enter a correct email or username...");
                }//the end of the else block 
            }//the end of the catch block 
        } while (notCorrect);//the end of the do while loop 

        //Read password 
        System.out.print("- Password: ");
        String password;
        boolean notCorrect1 = true;//assume that the email or username not correct
        do {
            password = read.next();
            try {
                isValidPassword_Or_UserName(password, "Password");
                System.out.println();
                System.out.println("Correct Password ..");
                notCorrect1 = false;
                this.password = password;
            }//the end of the try block 
            catch (InvalidException e) {
                System.out.println(".......................................................");
                System.out.print(e.getMessage() + " ");
                System.out.print(e.ValidPassword_Or_UserName("Password"));
                System.out.println(".......................................................");
                System.out.println("Please!Enter a correct password ");
            }//the end of the catch 
        } while (notCorrect1);//the end of the do while loop

        //check if these informations exist in the customers account in the array list of type Customer 
        boolean found = false;
        //assume that the account is not found yet 
        //its value will be change to true once the account is found 

        Loop:
        for (int index = 0; index < Customer_Information.size(); index++) {
            //outer if 
            if (the_user_entered.equals("email")) {
                //inner if 
                if ((email_or_user.equals(Customer_Information.get(index).getEmail()) && password.equals(Customer_Information.get(index).getPassword()))) {
                    found = true;
                    LogIn = true;//that means the customer succefuly log in 
                    customer_address = Customer_Information.get(index);
                    break Loop;

                }//the end
                else {
                    System.out.println("Wrong LOG IN");
                    System.out.println("Please Create New Account...");
                    sign_Up();
                }//the end of else block 
            }//the end of the outer if 
            else {
                if ((email_or_user.equals(Customer_Information.get(index).getUser_Name()) && password.equals(Customer_Information.get(index).getPassword()))) {
                    found = true;
                    LogIn = true;//that means the customer succefuly log in 
                    break Loop;
                }//the end
                else {
                    System.out.println("Wrong LOG IN");
                    System.out.println("Please Create New Account...");
                    sign_Up();
                }//the end of else block 
            }//outer if the end of the lese 
        }//the end of the for loop   
    }//the end of the method 

    //Validity methods ( used in handle )......
    /**
     * This instance private method will check the email and each time the
     * customer entered wrong password it will throw a message it is private
     * cause of it is needed just in this class, it will be accessed by methods
     * in this class
     *
     * @param Email
     * @param n
     * @throws InvalidException
     */
    private void isValidEmail(String Email, String n) throws InvalidException {
        //First condition :it the email contain spaces 
        if (Email.contains(" ")) {
            throw new InvalidException(1, "Email");
        }//the end of the if 

        //Second condition: if the email wasn't @gmail.com 
        int index = Email.lastIndexOf("@");//@gmail.com
        String After_at = Email.substring(index);
        if (!(After_at.equals("@gmail.com"))) {
            throw new InvalidException(2, "Email");
        }//the end of if statement 

        /*Third condition: we will check if the email is taken by another customer ..
        just when the sign up method has called this method 
         */
        if (n.equals("Sign Up")) {
            for (int index1 = 0; index1 < Customer_Information.size(); index1++) {
                String email = Customer_Information.get(index1).getEmail();
                if (email.equalsIgnoreCase(Email)) {
                    throw new InvalidException(3, "Email");
                }//the end of the if statement 
            }//the end of the for loop 
        }//the end of the if statement 
    }//the end of the method 

    /**
     * This instance private method will check the phone number and each time
     * the customer entered wrong password it will throw a message it is private
     * cause of it is needed just in this class, it will be accessed by methods
     * in this class
     *
     * @param number
     * @throws InvalidException
     */
    private void isValidPhone(String number) throws InvalidException {
        //First condition: to check that the phone number starts with 5 cause of there is +966 at the first 
        if (number.charAt(0) != '5') {
            throw new InvalidException(1, "Phone number");
        }//the end of the if statement
        //Second condition: check the length of the phone number 
        if (number.length() != 9) {
            throw new InvalidException(2, "Phone number");
        }//the end of the if statement

        //third condition :to check that the phone number only contains number 
        for (int i = 0; i < number.length(); i++) {
            /*
            take each character from the String and check if it not each 
            to any number it will throw an error
             */
            if (!(number.charAt(i) == '0' || number.charAt(i) == '1'
                    || number.charAt(i) == '2' || number.charAt(i) == '3' || number.charAt(i) == '4' || number.charAt(i) == '5' || number.charAt(i) == '6' || number.charAt(i) == '7' || number.charAt(i) == '8'
                    || number.charAt(i) == '9')) {
                throw new InvalidException(3, "Phone number");
            }//the end of the if statement    
        }//the end of the for loop 
    }//the end of the mehtod 

    /**
     * This instance private method will check the password and each time the
     * customer entered wrong password it will throw a message it is private
     * cause of it is needed just in this class, it will be accessed by methods
     * in this class
     *
     * @param n
     * @param password_Or_Username
     * @throws InvalidException
     */
    private void isValidPassword_Or_UserName(String password_Or_Username, String n) throws InvalidException {
        //First condition: to check if the password is 8 characters 
        if (password_Or_Username.length() != 8) {
            throw new InvalidException(1, n);
        }//the end of the mehtod 

        //Second condition: to check if the password contains at least one digit from 0 to 9
        int count1 = 0;//when the value of this variable change to 1 means there is a digit
        for (int i = 0; i <= 9; i++) {
            String String = Integer.toString(i);
            if (password_Or_Username.contains(String)) {
                count1 = 1;
            }//the end of the if block 
        }//the end of the for loop 
        //if the count=1 means ok if not means there is no digits
        if (count1 == 0) {
            throw new InvalidException(2, n);
        }//the end of the if statement

        //Third condition: to check if the password contains at leats one capital letter 
        int count2 = 0;//when the value of this variable change to 1 means there is a capital letter
        for (int index = 0; index < password_Or_Username.length(); index++) {
            if (password_Or_Username.charAt(index) >= 'A' && password_Or_Username.charAt(index) <= 'Z') {
                count2 = 1;
                break;//once the value change it will go out the loop, we don't need to check another time
                //at least we want just one capital letter in the password
            }//the end of the if statement 
        }//the end of the for loop 

        if (count2 == 0) {
            throw new InvalidException(3, n);
        }//the end of the if statement

        //Fourth condition:to check if the password contain at least one lowercase letter 
        int count3 = 0;
        for (int index = 0; index < password_Or_Username.length(); index++) {
            if (password_Or_Username.charAt(index) >= 'a' && password_Or_Username.charAt(index) <= 'z') {
                count3 = 1;
                break;//once the value change it will go out the loop, we don't need to check another time
                //at least we want just one lowercase letter in the password
            }//the end of the if statement 
        }//the end of the for loop 

        if (count3 == 0) {
            throw new InvalidException(4, n);
        }//the end of the if statement

        //Fifth condition: to check if the password contain at least one special character (_),(-) or ($) 
        if (!(password_Or_Username.contains("_") || password_Or_Username.contains("-") || password_Or_Username.contains("$"))) {
            throw new InvalidException(5, n);
        }//the end of the if statement

        String p_or_u;
        //Sixth condition :we will check if the password or username is taken by another customer 
        for (int index = 0; index < Customer_Information.size(); index++) {
            if (n.equals("Password")) {
                p_or_u = Customer_Information.get(index).getPassword();
            } else {
                p_or_u = Customer_Information.get(index).getUser_Name();
            }//the end of the else block 
        }//the end of the for loop 
    }//the end of the method 

    /**
     * This instance method to check if the customer choose available‏ city or
     * not
     *
     * @param city
     * @throws InvalidException
     */
    private void ExistCity(String city) throws InvalidException {
        if (!(city.equalsIgnoreCase("Riyadh") || city.equalsIgnoreCase("Jeddah") || city.equalsIgnoreCase("Makkah") || city.equalsIgnoreCase("Dammam"))) {
            throw new InvalidException("City");
        }//the end of the if statement 
    }//the end of the method

    //setter method.... 
    /**
     * This instance method to set a value to the choice depend on the customer
     * choice from the menu
     *
     * @param choice
     */
    public void setChoice(String choice) {
        this.choice = choice;
    }//the end of the method 

    //getter method ....
    /**
     * To get a the value of the choice
     *
     * @return String
     */
    public String getChoice() {
        return choice;
    }//the end of the method 

    /**
     * this instance method will return the Bill object ..
     *
     * @return Bill
     */
    public Bill getCustomer_Bill() {
        return Customer_Bill;
    }//the end of the method 

    /**
     * This instance method will return Basket Object of the customer..
     *
     * @return Basket
     */
    public Basket getCustomer_Basket() {
        return Customer_Basket;
    }//the end of the method

    /**
     * return the value of the variable isSignUp
     *
     * @return SignUp
     */
    public boolean isSignUp() {
        return SignUp;
    }

    /**
     * return the value of isLogIn
     *
     * @return LogIn
     */
    public boolean isLogIn() {
        return LogIn;
    }

    /**
     * return the address of the customer_address
     *
     * @return customer_address
     */
    public Customer getCustomer_address() {
        return customer_address;
    }

    /**
     * return the password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

}//the end of the class 
