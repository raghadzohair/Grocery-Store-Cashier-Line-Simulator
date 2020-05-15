/*
 * name: raghad zohair - ID: 1705628 - CPCS204 - secion: BBR
 * email: ryahya0010@stu.kau.edu.sa
 * Program 4: Grocery Store Cashier Line Simulator 
 */
package grocerystoresim;

/**
 *
 * @author Raghad
 */
public class Customer {
    
    private String firstName;
    private String lastName;
    private int numItems; 
    private int entryTime;   
    private Customer next;

    public Customer(int entryTime,String firstName, String lastName, int numItems) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numItems = numItems;
        this.entryTime = entryTime;
        this.next = null;
    }
    


    Customer(String name) {
        this.firstName = name;
    }
    
    

    public Customer getNext() {
        return next;
    }

    public void setNext(Customer next) {
        this.next = next;
    }


    public int getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }


    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
