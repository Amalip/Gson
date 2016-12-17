package amalip.gson.Models;

/**
 * Created by Amalip on 12/17/2016.
 */

public class Customer {
    private int CostumerID;
    private String FirstName;
    private String LastName;
    private String Address;

    public Customer(int pId, String pFN, String pLN, String pAddr){
        this.CostumerID = pId;
        this.FirstName = pFN;
        this.LastName = pLN;
        this.Address = pAddr;
    }

    public int getCostumerID() {
        return CostumerID;
    }
    public void setCostumerID(int costumerID) {
        CostumerID = costumerID;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
}
