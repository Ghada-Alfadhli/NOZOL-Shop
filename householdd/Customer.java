package householdd;

/**
 * This class will have the information for the customer
 *
 * @version 1.0
 */
public class Customer {

    //Data members.....
    /**
     * This instance field will store the customer number, this value not
     * allowed to be changed...
     */
    private final int CUSTOEMR_ID;

    /**
     * This static field will store how many customers...
     */
    private static int count = 0;

    /**
     * This instance field will store the first name of the customer...
     */
    private String First_Name;

    /**
     * This instance field will store the last name of the customer...
     */
    private String Last_Name;

    /**
     * This instance field will store the phone number of the customer...
     */
    private String Phone_Number;

    /**
     * This instance field will store the email for the customer...
     */
    private String Email;

    /**
     * This instance field will store a final value which is the country...
     */
    private final String COUNTRY = "Saudi Arabia";

    /**
     * This instance field will store the city that is entered by the
     * customer...
     */
    private String city;

    /**
     * This instance field will store a final value which is the currency...
     */
    private final String CURRENCY = "SR";

    /**
     * This instance field will store the password for the customer account...
     */
    private String Password;

    /**
     * This instance field will store the user name for the customer account...
     */
    private String User_Name;

    //Constructor
    /**
     *
     */
    public Customer() {
        /*
        we use the method that convert from String yo integar cause of we want the customer id to be 
        form of two digits 
         */
        count++;
        String number = count + "0";
        CUSTOEMR_ID = Integer.valueOf(number);
    }//the end of the method 

    /**
     *
     * @param Email
     * @param Password
     * @param User_Name
     */
    public Customer(String Email, String Password, String User_Name) {
        count++;
        this.Email = Email;
        this.Password = Password;
        this.User_Name = User_Name;
        String number = count + "0";
        CUSTOEMR_ID = Integer.valueOf(number);
    }//the end of the method 

    //getter methods 
    /**
     * This instance method to get the Customer_ID
     *
     * @return int
     */
    public int getCUSTOEMR_ID() {
        return CUSTOEMR_ID;
    }

    /**
     * This instance method to get the First name
     *
     * @return String
     */
    public String getFirst_Name() {
        return First_Name;
    }

    /**
     * This instance method to get the last name
     *
     * @return String
     */
    public String getLast_Name() {
        return Last_Name;
    }

    /**
     * This instance method to get the phone number
     *
     * @return int
     */
    public String getPhone_Number() {
        return Phone_Number;
    }

    /**
     * This instance method to get the email
     *
     * @return String
     */
    public String getEmail() {
        return Email;
    }

    /**
     * This instance method to get the country
     *
     * @return String
     */
    public String getCOUNTRY() {
        return COUNTRY;
    }

    /**
     * This instance method to get the currency
     *
     * @return String
     */
    public String getCURRENCY() {
        return CURRENCY;
    }

    /**
     * This instance method to get the password
     *
     * @return String
     */
    public String getPassword() {
        return Password;
    }

    /**
     * This instance method will get the value of the city
     *
     * @return String
     */
    public String getCity() {
        return city;
    }//the end of the method 

    /**
     * This instance method to get the user name
     *
     * @return String
     */
    public String getUser_Name() {
        return User_Name;
    }

    //Setter methods 
    /**
     * This instance method to set the first name
     *
     * @param First_Name
     */
    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    /**
     * This instance method to set the last name
     *
     * @param Last_Name
     */
    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    /**
     * This instance method to set the phone number
     *
     * @param Phone_Number
     */
    public void setPhone_Number(String Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    /**
     * This instance method to set the Email
     *
     * @param Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * This instance method to set the Password
     *
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * This instance method to set the user name
     *
     * @param User_Name
     */
    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    /**
     * This instance method will set a value to the city
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }//the end of the method 

    /**
     * This static method (utility method) show the available cites that the
     * customer can choose...
     */
    public static void City_Menu() {
        System.out.println("................");
        System.out.println(".    Riyadh    .");
        System.out.println(".    Jeddah    .");
        System.out.println(".    Makkah    .");
        System.out.println(".    Dammam    .");
        System.out.println("................");
    }//the end of the method 
}//the end of the class 
