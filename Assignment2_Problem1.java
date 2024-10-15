public class Assignment2_Problem1 {
     private static final int DEFAULT_CAPACITY = 10;
     private Object[] stackArray; 
    private int size;  
   
    // Constructor with default initial capacity
    public Assignment2_Problem1() {
        this(DEFAULT_CAPACITY); 
    }

    // Constructor with specified initial capacity
    public Assignment2_Problem1(int capacity) {
        stackArray = new Object[capacity];  
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int getSize() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) 
        	System.out.print("The stack is empty");
        return stackArray[size - 1];  // Return the top element
    }

    public void push(Object input) {
        if (size == stackArray.length) 
            resize();
        stackArray[size++] = input;  // Add element and increment size
    }

    public Object pop() {
        if (isEmpty()) 
            System.out.print("The stack is empty");
        Object ouput = stackArray[--size];  //Deincrement size, then remove top element
        stackArray[size] = null; 			// Clear element from array
        return ouput;
    }

    private void resize() {
        Object[] newArray = new Object[stackArray.length * 2]; 
        for (int i = 0; i < size; i++) 
            newArray[i] = stackArray[i];
        stackArray = newArray; 
    }

}
