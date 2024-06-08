package householdd;

/**
 * This interface will have the section for our shop products
 *
 * @version 1.0
 */
public interface HouseHoldProducts_Section {

    //Data members
    /**
     * This static field will store two digit which will be the ID number for
     * the section ,this value not allowed to be changed..
     */
    public static final String SECTION_ID = "20";//before int 

    //Methods....
    /**
     * This abstract method is for printing useful information about the class..
     *
     * @return string
     */
    @Override
    public String toString();
}//the end of the interface 
