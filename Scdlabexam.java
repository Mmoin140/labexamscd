package scdlabexam;

import java.util.*;
public class Scdlabexam {
    // Immutable class
    static class ImmutableNumber {
        private final int number;
        public ImmutableNumber(int number) {
            this.number = number;
        }
        public int getNumber() {
            return number;
        }
    }
    // Mutable class
    static class MutableNumber {
        private int number;
        public MutableNumber(int number) {
            this.number = number;
        }
        public int getNumber() {
            return number;
        }
        public void setNumber(int number) {
            this.number = number;
        }
    }
    public static void main(String[] args) {
        // Thread for Even Numbers
        Thread evenThread = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i += 2) {
                    ImmutableNumber immutableNum = new ImmutableNumber(i); // immutable object
                    MutableNumber mutableNum = new MutableNumber(i); // mutable object
                    System.out.println("Even Thread - Immutable: " + immutableNum.getNumber() + 
                    		", Mutable: " + mutableNum.getNumber());            
                    // modifying the mutable object
                    mutableNum.setNumber(mutableNum.getNumber() + 1);
                    System.out.println("Even Thread - Modified Mutable: " + mutableNum.getNumber());        
                    Thread.sleep(1000); // Simulating delay
                }
            } catch (InterruptedException e) {
                System.out.println("Even thread interrupted");
            }
        });
        // Thread for Odd Numbers
        Thread oddThread = new Thread(() -> {
            try {
                for (int i = 1; i < 19; i += 2) {
                    ImmutableNumber immutableNum = new ImmutableNumber(i); // immutable object
                    MutableNumber mutableNum = new MutableNumber(i); // mutable object
                    System.out.println("Odd Thread - Immutable: " + immutableNum.getNumber() + ""
                    		+ ", Mutable: " + mutableNum.getNumber());               
                    // Simulate mutability: modifying the mutable object
                    mutableNum.setNumber(mutableNum.getNumber() + 1);
                    System.out.println("Odd Thread - Modified Mutable: " + mutableNum.getNumber());
                    
                    Thread.sleep(500); // Simulating delay
                }
            } catch (InterruptedException e) {
                System.out.println("Odd thread interrupted");
            }
        });

        // Starting both threads
        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
//           
//        }
    }
}
}