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
public class CustomerCheckout {
    private String firstName;
    private String lastName;
    private int numItems; 
    private int entryTime;
    private String timeNeededForCheckout;
    private CustomerCheckout next;

    public CustomerCheckout(Customer c, String time) {
        this.firstName = c.getFirstName();
        this.lastName = c.getLastName();
        this.numItems = c.getNumItems();
        this.entryTime = c.getEntryTime();
        this.timeNeededForCheckout = time;
    }
    

    public CustomerCheckout(int entryTime,String firstName, String lastName, int numItems ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numItems = numItems;
        this.entryTime = entryTime;
        this.next =null;
    }
 
    public CustomerCheckout(int entryTime,String firstName, String lastName, int numItems,  CustomerCheckout next) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numItems = numItems;
        this.entryTime = entryTime;
        this.next = next;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public int getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }

    public CustomerCheckout getNext() {
        return next;
    }

    public void setNext(CustomerCheckout next) {
        this.next = next;
    }
    
    public String getTimeNeededForCheckout() {
        return timeNeededForCheckout;
    }

    public void setTimeNeededForCheckout(String timeNeededForCheckout) {
        this.timeNeededForCheckout = timeNeededForCheckout;
    }

    
}
