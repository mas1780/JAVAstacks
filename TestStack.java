package class18_stack;

public class TestStack {
  
  public static void main(String[] args) {
    // Create stack with default capacity
    StackOfCharacters s1 = new StackOfCharacters();

    if (s1.getNumItemsOnStack() != 0) {
      System.err.println("Invalid size of stack s1");
      return;
    }

    if (s1.getCapacity() != StackOfCharacters.DEFAULT_CAPACITY) {
      System.err.println("Invalid capacity of stack s1");
      return;
    }

    // Create stack s2 with specified capacity
    final int S2_CAPACITY = 24;
    StackOfCharacters s2 = new StackOfCharacters(S2_CAPACITY);

    if (s2.getCapacity() != S2_CAPACITY) {
      System.err.println("Invalid capacity of stack s2");
    }

    // Test stack operations

    System.out.println("Before the first push, the stack contains: " + s2.toString());

    s2.push('a');
    System.out.println("After one push, the stack contains:    " + s2.toString());

    s2.push('b');
    System.out.println("After two pushes, the stack contains:    " + s2.toString());

    s2.push('c');
    System.out.println("After three pushes, the stack contains:    " + s2.toString());

    if (s2.getNumItemsOnStack() != 3) {
      System.err.println("Invalid size of stack s2");
      return;
    }

    if (s2.pop() != 'c') {
      System.err.println("Incorrect pop value returned.");
      return;
    }

    System.out.println("After one pop, the stack contains:         " + s2.toString());

    if (s2.peek() != 'b') {
      System.err.println("Incorrect peek value returned.");
      return;
    }

    System.out.println("After one peek, the stack contains:        " + s2.toString());

    // Reverse a string with our stack!

    System.out.println("\nReverse a String Using a Stack");

    String forward = "abcde";
    System.out.println("  Push each character of the string on the stack: ");
    for (int i = 0; i < forward.length(); i++) {
      s1.push(forward.charAt(i));
      System.out.println("    After push " + (i + 1) + ", the stack contains: " + s1.toString());
    }

    String reversed = "";
    System.out.println("\n  Pop each character off the stack: ");
    for (int i = 0; i < forward.length(); i++) {
      reversed += s1.pop();
      System.out.println("    After pop  " + (i + 1) + ", the stack contains: " + s1.toString());
    }

    if (!reversed.equals("edcba")) {
      System.err.println("Stack not preseving LIFO.");
      return;
    }
    else
        System.out.println("\n  Original string: " + forward + "  Reversed string: " + reversed);

    System.out.println("\nAll tests passed!");
  }
}
