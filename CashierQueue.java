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
public class CashierQueue {
    
    private Customer front;  
    private Customer back;  
    private String name;
    
    public CashierQueue() {
        this.front = null;
        this.back = null;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Customer getBack() {
        return back;
    }

    public void setBack(Customer back) {
        this.back = back;
    }


    public Customer getFront() {
        return front;
    }

    public void setFront(Customer front) {
        this.front = front;
    }

    public boolean isEmpty() {
        return front == null;
    }
    
    public void enqueue(Customer customer) {
        if (isEmpty()) {
            front = back = enqueue(front, back, customer);
        }
        else {
            back = enqueue(front, back, customer);
        }
    }

    private Customer enqueue(Customer front, Customer back, Customer customer) {
        
        Customer temp = customer;
       
        if (isEmpty()) {
            return temp;
        } 
        else {
            back.setNext(temp);
            back = back.getNext();
            return back;
        }
    }
    
    public Customer dequeue() {
        Customer temp = front;
        front = dequeue(front);
        if (front == null) {
            back = null;
        }
        return temp;
    }
    

    private Customer dequeue(Customer front) {
        front = front.getNext();
        return front;
    }

    
    public Customer peek() {
        
        Customer frontinfo = peek(front);
        return frontinfo;
    }

    private Customer peek(Customer front) {
        return front;
    }
    
    
    // Methods to pint info.
    public void printQueue() {
        printQueue(front);
    }

    private void printQueue(Customer front) {
        // We need to traverse
        Customer helpPtr = front;
        while (helpPtr != null) {
            System.out.println(helpPtr.getEntryTime()+" "+helpPtr.getFirstName()+" "+helpPtr.getLastName()+" "+helpPtr.getNumItems());
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
    }
    
    public boolean search(String data) {
        return search(front, data);
    }

    private boolean search(Customer p, String data) {
    
        Customer helpPtr = p;
        while (helpPtr != null) {
            if (helpPtr.getFirstName().equals(data)) {
                return true;
            }
            helpPtr = helpPtr.getNext(); 	
        }
        return false;
    }

    

}
