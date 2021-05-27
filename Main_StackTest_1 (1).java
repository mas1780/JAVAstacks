package class18_stack;

import java.util.Scanner;

public class Main_StackTest_1 {
  
  public static void main(String[] args) {
    // Create stack with default capacity
    StackOfCharacters s1 = new StackOfCharacters();
    
    Scanner input = new Scanner(System.in);

    // Reverse a string using a stack data structure

    String forward = "";
    do {
      System.out.print("\nEnter the string to be reversed (up to " + 
                       s1.getCapacity() + " characters):");
      forward = input.nextLine();   
    } while (forward.length() > s1.getCapacity());
    input.close();
    
    for (int i = 0; i < forward.length(); i++) {
      s1.push(forward.charAt(i));
    }
    System.out.println("\nOriginal string is: " + forward);

    String reversed = "";
    for (int i = 0; i < forward.length(); i++) {
      reversed += s1.pop();
    }

    System.out.println("\nReversed string is: " + reversed);
  }
}
