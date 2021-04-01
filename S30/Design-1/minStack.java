import java.util.Stack;

public class MinStack {
	Stack<Integer> currentStack;
	Stack<Integer> minStack;
	
		
	public MinStack() {
		currentStack = new Stack<>();
		minStack = new Stack<>();
	}
	
 	public void push(int val) {
        currentStack.push(val);
        minStack.push(getMin());
    }
    
    public void pop() {
    	currentStack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	return currentStack.peek();
    }
    
    public int getMin() {   	
    	if (minStack.empty() || top() < minStack.peek()) {
    		return currentStack.peek();
    	}
    	
    	return minStack.peek();
    }
}