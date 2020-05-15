/*
 * name: raghad zohair - ID: 1705628 - CPCS204 - secion: BBR
 * email: ryahya0010@stu.kau.edu.sa
 * Program 4: Grocery Store Cashier Line Simulator 
 */
package grocerystoresim;

import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author Raghad
 */
public class TransactionStack {
    
    private CustomerCheckout top;
    
    public TransactionStack() {
        top = null;
    }
    
    public CustomerCheckout getTop() {
        return top;
    }

    public void setTop(CustomerCheckout top) {
        this.top = top;
    }
    
    // Method to check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Methods to printStack
    public void PrintStack(PrintWriter write) {
        PrintStack(top,write);
    }

    private void PrintStack(CustomerCheckout top,PrintWriter write) {
        // We need traverse
        CustomerCheckout helpPtr = top;
        while (helpPtr != null) {
            // Print the info. of customer
            write.println("Customer Name:\t " + helpPtr.getFirstName() + " " + helpPtr.getLastName());
            write.println("Time Completed:\t"+helpPtr.getTimeNeededForCheckout()+"\r\n");

            helpPtr = helpPtr.getNext();
        }
        write.println();
    }
    
    
    // Methods to push new info.
    public void push(Customer c, String time) {
        
        top = push( c,time,top);
    }
    
    private CustomerCheckout push(Customer c,String time,CustomerCheckout top) {
        // Insert new info.
        top = new CustomerCheckout(c,time);
        
        return top;
    }
    
    
    //Metods two remove the info, of customer
    public CustomerCheckout pop() {

        CustomerCheckout temp = top;
        top = pop(top);
        return temp;
    }

    private CustomerCheckout pop(CustomerCheckout top) {

        top = top.getNext();
        return top;
    }
    
    // Methods to gets the info. without remove
    public CustomerCheckout top() {
        CustomerCheckout Thetop = top(top);
        return Thetop;
    }
    
    private CustomerCheckout top(CustomerCheckout top) {
        return top;
    }

    public boolean search(String name) {
        return search(top, name);
    }

    private boolean search(CustomerCheckout p, String name) {
        // To search, we must traverse. Therefore, we need helpPtr.
        CustomerCheckout helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getFirstName().equals(name)) {
                return true;
            }
            helpPtr = helpPtr.getNext(); // step one node over		
        }
        return false;
    }
    
}
