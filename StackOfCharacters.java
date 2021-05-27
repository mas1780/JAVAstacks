package class18_stack;

// This is the StackOfCharacters class.
// A stack that holds characters is constructed, and the behaviors
// of a stack are defined.

public class StackOfCharacters {
  private Character[] list;
  private int capacity;   // Capacity of the stack
  
  // itemsOnStack keeps track of how many items have been pushed onto
  // the stack:
  private int itemsOnStack = 0;
  final static int DEFAULT_CAPACITY = 16;

  // Constructor that accepts capacity as a parameter
  public StackOfCharacters(int capacity) {
    // If capacity is < 1, set it to the default
    // The capacity defines how many items, at most, the stack can hold
    this.capacity = capacity < 1 ? DEFAULT_CAPACITY : capacity;
    list = new Character[this.capacity];
  }

  // Constructor that initializes default capacity
  public StackOfCharacters() {
    // Use "this" to call a constructor from within the class.
    this(DEFAULT_CAPACITY);
  }

  // Convenient methods for testing common stack conditions:
  
  public boolean isEmpty() {
    return this.itemsOnStack == 0;
  }

  public boolean full() {
    return this.itemsOnStack == this.capacity;
  }

  // Getters:
  
  public int getNumItemsOnStack() {
    return this.itemsOnStack;
  }

  public int getCapacity() {
    return this.capacity;
  }

  // The primary operations of the StackOfCharacters data structure:

  // "push" an element (Character) onto the stack:
  public boolean push(Character value) {
    if (!this.full() && value != null) {
      // Stack is not full and value to push is valid (not null) so
      // continue with "push".
        
      // As long as the stack is not full, itemsOnStack can be used
      // as the array position where the new value can be written:
      this.list[this.itemsOnStack] = value;
      
      // We just added one element to the stack so we need to 
      // increment the item counter - itemsOnStack:
      this.itemsOnStack++;
      
      // Return true to indicate the operation was successful
      return true;
    } 
    
    // If the stack is full or the value to push is invalid (is null),
    // return false:
    return false;
  }

  // "pop" an element off the top of the stack.
  // This reads the element from the top of the stack and returns 
  // it to the caller. "pop" adjusts the top of stack pointer 
  // by moving it to point to the previous element on the stack.
  public Character pop() {
    if (this.isEmpty()) {
      // There is nothing to pop, so we will return null
      return null;
    } 
    else {
      // itemsOnStack tells us the number of items on the stack.
      // We can use itemsOnStack to read the element at the top of
      // the stack if we decrement it first (array indexes start at
      // zero so we need to adjust).
      // Decrement the number of items on the stack:
      this.itemsOnStack--;
      
      // Return the item that's at the top of the stack:
      return this.list[this.itemsOnStack];
      
      // Note: The value in itemsOnStack is accurate; we've removed
      //       one item but we pre-decremented itemsOnStack, so it  
      //       does reflect the correct number of elements.
    }
  }

  // Similar to "pop", "peek" returns the element at the top of the 
  // stack, however, "peek" doesn't remove the element (it doesn't 
  // adjust the top of stack pointer).
  public Character peek() {
    if (this.isEmpty()) {
      // If the stack is empty, return null:
      return null;
    } 
    else {
      // If the stack is not empty, return the item at the top of 
      // the stack:
      return this.list[this.itemsOnStack - 1];
      
      // Notice that the contents of the stack hasn't changed - we
      // haven't removed anything so we don't need to modify 
      // itemsOnStack.
    }
  }

  // This method returns the string representation of the stack.
  // If there are 3 items were pushed on the stack in this order:
  //     push 'A'     push 'B'    push 'C' 
  // Then toString() prints the following:
  //      bottom [A, B, C] top
  public String toString() {
    String s = "BOTTOM [ ";

    for (int i = 0; i < this.itemsOnStack; i++) {
      s += this.list[i] + " ";
    }

    return s + "] TOP";
  }
}