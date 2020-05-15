/*
 * name: raghad zohair - ID: 1705628 - CPCS204 - secion: BBR
 * email: ryahya0010@stu.kau.edu.sa
 * Program 4: Grocery Store Cashier Line Simulator 
 */
package grocerystoresim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;

/**
 *
 * @author Raghad
 */
public class GroceryStoreSim {
    public static void main(String[] args) throws Exception {
        
        File input = new File("GroceryStoreSim.in");
        // check if the file is exists
        if(!input.exists()){
            System.out.println("GroceryStoreSim File does not exists !!");
            System.exit(0);
        }
        // Else creat file outPut 
        File output = new File("GroceryStoreSim.out");
        //create scanner to reed from file input objects
        Scanner scan = new Scanner(input);
        //create PrintWriter to write in output file
        PrintWriter write = new PrintWriter(output);
        
        write.println("Welcome to the Grocery Store Simulator\r\n");
        int days = scan.nextInt();
        int countDay = 0;
        
        // create queue and stack objects
        CashierQueue line1 = new CashierQueue();
        CashierQueue line2 = new CashierQueue();
        CashierQueue line3 = new CashierQueue();
        CashierQueue entryLine = new CashierQueue();
        TransactionStack stack = new TransactionStack();
        int count1 = 0, count2 = 0, count3 = 0;
        while(countDay != days){
            write.println("**********\r\nDay "+(countDay+1)+":\r\n**********");
            int numOfCustomers = scan.nextInt();

            for (int i = 0; i < numOfCustomers; i++) {
                int entryTime = scan.nextInt();
                String fName = scan.next();
                String lName = scan.next();
                int numItem = scan.nextInt();
                Customer c = new Customer(entryTime,fName, lName,numItem );
                entryLine.enqueue(c);
            }
            
            for (int j = 0; j < 300; j++) {
                
                if (j ==  entryLine.getFront().getEntryTime()) {//minutes
                               
                    if(line1.isEmpty()||count1<count2 && count1<count3 ){
                        line1.enqueue(entryLine.dequeue());
                        write.println(hours(line1.getFront().getEntryTime())+""+line1.getFront().getFirstName()+" "+line1.getFront().getLastName()
                                +" arrived at the Grocery Store and entered Cashier Line 1");
                        line1.getFront().setEntryTime(line1.getFront().getEntryTime()+1);
                        count1++;
                        
                    }
                    else if(line2.isEmpty()|| count2<count1 && count2<count3){
                        line2.enqueue(entryLine.dequeue());
                        write.println(hours(line2.getFront().getEntryTime())+""+line2.getFront().getFirstName()+" "+line2.getFront().getLastName()
                                +" arrived at the Grocery Store and entered Cashier Line 2");
                        line2.getFront().setEntryTime(line2.getFront().getEntryTime()+1);
                        count2++;
                    }
                    else{
                        line3.enqueue(entryLine.dequeue());
                        write.println(hours(line3.getFront().getEntryTime())+""+line3.getFront().getFirstName()+" "+line3.getFront().getLastName()
                                +" arrived at the Grocery Store and entered Cashier Line 3");
                        line3.getFront().setEntryTime(line3.getFront().getEntryTime()+1);
                        count3++;
                    }
                    j--;  // to check if onther customer enter store in same time     
                }
                if(!line1.isEmpty()&& line1.getFront().getEntryTime()==j){ // arrive customer at front
                    line1.getFront().setEntryTime(j);
                    write.println(hours(line1.getFront().getEntryTime())+" "+line1.getFront().getFirstName()+" "+line1.getFront().getLastName()
                            +"is at the front of Cashier Line 1 and is now beginning the check out.");
                }
                if(!line2.isEmpty()&& line2.getFront().getEntryTime()==j){
                    line2.getFront().setEntryTime(j);
                    write.println(hours(line2.getFront().getEntryTime())+" "+line2.getFront().getFirstName()+" "+line2.getFront().getLastName()
                            +"is at the front of Cashier Line 2 and is now beginning the check out.");
                }
                if(!line3.isEmpty()&&line3.getFront().getEntryTime()==j){
                    line3.getFront().setEntryTime(j);
                    write.println(hours(line3.getFront().getEntryTime())+" "+line3.getFront().getFirstName()+" "+line3.getFront().getLastName()
                            +"is at the front of Cashier Line 3 and is now beginning the check out.");
                }
                if(line1.getFront().getNumItems()+line1.getFront().getEntryTime()==j){
                    line1.getFront().setEntryTime(j);
                    write.println(hours(line1.getFront().getEntryTime())+" "+line1.getFront().getFirstName()+" "+line1.getFront().getLastName()+
                            " has finished Shopping and is now exiting the Line 1.");
                    
                    write.println(hours(line1.getFront().getEntryTime())+" "+line1.getFront().getFirstName()+" "+line1.getFront().getLastName()
                            +" has received Printed receipt and is leaving the Grocery Store.");
                    stack.push(line1.dequeue(),hours(j));
                }
                
                if(line2.getFront().getNumItems()+line2.getFront().getEntryTime()==j){
                    line2.getFront().setEntryTime(j);
                    write.println(hours(line2.getFront().getEntryTime())+" "+line2.getFront().getFirstName()+" "+line2.getFront().getLastName()+
                            " has finished Shopping and is now exiting the Line 1.");
                    write.println(hours(line2.getFront().getEntryTime())+" "+line2.getFront().getFirstName()+" "+line2.getFront().getLastName()
                            +" has received Printed receipt and is leaving the Grocery Store.");
                    stack.push(line2.dequeue(),hours(j));
                }
                
                if(line3.getFront().getNumItems()+line3.getFront().getEntryTime()==j){
                    line3.getFront().setEntryTime(j);
                    write.println(hours(line3.getFront().getEntryTime())+" "+line3.getFront().getFirstName()+" "+line3.getFront().getLastName()+
                            " has finished Shopping and is now exiting the Line 1.");
                    write.println(hours(line3.getFront().getEntryTime())+" "+line3.getFront().getFirstName()+" "+line3.getFront().getLastName()
                            +" has received Printed receipt and is leaving the Grocery Store.");
                    stack.push(line3.dequeue(),hours(j));
                }                      
            }
            write.println("\r\n*** Day " + (countDay + 1) + ":  Grocery Store Report ***:\r\nConfirmed Served:\r\n");
            stack.PrintStack(write);
            write.println();
            write.println();
            while (!stack.isEmpty()) {
                stack.pop();
            }

            countDay++;
        }
        scan.close();
        write.close();
    }
    public static String hours(int minute) {
        int hour = minute / 60;
        minute = minute %60;
        String p = "PM:";
        
        if (hour == 0) { // when hour 00:
            hour = 12;
        }
        if(minute<10){
            return hour+":0"+minute;
        }
        return hour+":"+minute;
    }
    
}
