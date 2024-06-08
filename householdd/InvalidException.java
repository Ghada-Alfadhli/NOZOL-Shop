package householdd;

/**
 * This class will handle the invalid inputs for email,phone number,password and
 * user name and the exist city
 *
 * @version 1.0
 */
public class InvalidException extends Exception {

    /**
     * This instance field store number of condition that is violated based on
     * the condition of the method ..
     */
    private int ConditionViolated;

    //Constructors ....
    /**
     *
     */
    public InvalidException() {
    }//the end of the method 

    /**
     * To specify the Invalid thing
     *
     * @param n
     */
    public InvalidException(String n) {
        super("Invalid " + n + ":");
    }//the end of the method

    /**
     * To specify the Invalid thing
     *
     * @param number
     * @param n
     */
    public InvalidException(int number, String n) {
        super("Invalid " + n + ":");
        this.ConditionViolated = number;
    }//the end of the method 

    /**
     * This method is to check the valid password that must achieve 7 conditions
     *
     * @param User_Or_Password
     * @return String
     */
    public String ValidPassword_Or_UserName(String User_Or_Password) {
        switch (ConditionViolated) {
            case 1:
                return (User_Or_Password + " length should be 8 chararcters");
            case 2:
                return (User_Or_Password + " should contain at least one digit (0-9)");
            case 3:
                return (User_Or_Password + "should contain at least one capital letter");
            case 4:
                return (User_Or_Password + " should contain at least one lowercase letter");
            case 5:
                return (User_Or_Password + " should contain at least one special character (_),($)or (-)");
            case 6:
                return (User_Or_Password + " is already taken");
            case 7:
                return (User_Or_Password + "spaces not allowed in the user name");
            default:
                return " ";
        }//the end of the switch block 
    }//the end of the method

    /**
     * This instance method will check the valid phone number that must achieve
     * 3 conditions
     *
     * @return String
     */
    public String ValidPhoneNumber() {
        switch (ConditionViolated) {
            case 1:
                return "Phone number should starts with 5 ";
            case 2:
                return "Phone number should contain 9 digits ";
            case 3:
                return "Please enter a correct phone number ";
            default:
                return " ";
        }//the end of the switch block 
    }//the end of the method 

    /**
     * This instance method will check the valid email that must achieve 3
     * conditions
     *
     * @return String
     */
    public String ValidEmail() {
        switch (ConditionViolated) {
            case 1:
                return "Email shouldn't contain spaces";
            case 2:
                return "Email should be (@gmail.com)";
            case 3:
                return "Email is already taken";
            default:
                return " ";
        }//the end of the switch block 
    }//the end of the method 

    /**
     * This instance method will check the exist city based on the menu in the
     * Customer class
     *
     * @return String
     */
    public String ValidCity() {
        return "Sorry...We can't provide our services to it... \n WE WILL PROVIDE IT SOON !";
    }//the end of the method 

}//the end of the class 
