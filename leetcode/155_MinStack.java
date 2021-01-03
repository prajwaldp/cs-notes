class StackElement {
    // TODO Replace with private, add setter methods instead
    public int minElem;
    public int elem;

    public StackElement(int elem, int minElem) {
        this.elem = elem;
        this.minElem = minElem;
    }
}

class MinStack {

    Deque<StackElement> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.addLast(new StackElement(x, x));
        } else {
            int newMin = Math.min(x, stack.getLast().minElem);
            stack.addLast(new StackElement(x, newMin));
        }
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.getLast().elem;
    }

    public int getMin() {
        return stack.getLast().minElem;
    }
}

class MinStackAlt {
    Deque<Integer> stack;
    int minElem = Integer.MAX_VALUE;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (x < minElem) {
            stack.addLast(minElem);
            minElem = x;
        }
        stack.addLast(x);
    }

    public void pop() {
        int top = stack.removeLast();
        if (top == minElem) {
            minElem = stack.removeLast();
        }
        return top;
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minElem;
    }
}