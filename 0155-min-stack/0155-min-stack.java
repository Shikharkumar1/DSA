import java.util.Stack;

class MinStack {
    private Stack<Long> st;  // Using long to prevent overflow issues
    private long mini;       // Variable to store the minimum value

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            mini = val;
            st.push(0L);  // Push 0 as the difference between val and mini is 0
        } else {
            st.push((long)val - mini);  // Push the difference
            if (val < mini) {
                mini = val;  // Update the minimum value
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) {
            return;
        }

        long popVal = st.pop();
        if (popVal < 0) {  // If the popped value is negative, mini needs to be adjusted
            mini = mini - popVal;  // Restore the previous minimum value
        }
    }

    public int top() {
        if (st.isEmpty()) {
            return -1;  // Or throw an exception for an empty stack
        }

        long topVal = st.peek();
        if (topVal > 0) {
            return (int) (mini + topVal);  // Return the original value
        } else {
            return (int) mini;  // Return the minimum value if it's encoded
        }
    }

    public int getMin() {
        return (int) mini;  // Return the current minimum
    }
}
