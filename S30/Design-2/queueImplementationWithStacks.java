class MyQueue {
	Stack<Integer> queueStack;
	Stack<Integer> queue;

    /** Initialize your data structure here. */
    public MyQueue() {
        queueStack = new Stack<>();
        queue = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        queueStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (queue.empty()) {
        	shiftElements();
        }
        
        return queue.peek();
    }
    
    /** Shifts elements from queueStack to queue */
    private void shiftElements() {
    	while (!queueStack.empty()) {
    		queue.push(queueStack.pop());
    	}
    }
    
    /** Get the front element. */
    public int peek() {
    	if (queue.empty()) {
    		shiftElements();
    	}
    	
        return queue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queueStack.empty() && queue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */